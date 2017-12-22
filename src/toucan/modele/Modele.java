package toucan.modele;

import toucan.algorithme.Algo;
import toucan.exceptions.ToucanException;

import javax.swing.tree.ExpandVetoException;
import java.awt.*;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.ThreadLocalRandom;

public class Modele extends Observable implements Runnable {

	public static final int NORD = 0;
	public static final int SUD = 1;
	public static final int EST = 2;
	public static final int OUEST = 3;
	public static final int STABLE = 4;

	public static final int TAILLE_CASE = 50;
	public static final Color DEFAULT_COLOR_CASE = Color.BLACK;

	private static final String ALGO_PACKAGE = "toucan.algorithme";
	private static final List<String> EXCLUDE_ALGO_CLASSES = Arrays.asList("Algo.class", "AlgoPerso.class");

	private LesCases lesCases;
	private int vitesseAnimation;
	private boolean threadLaunch;
	private boolean mouvCalc;

	private List<Algo> collectionAlgo;
	private int selectionAlgo;

	private String algoPersoText;

	public Modele(int nbCases) {
		lesCases = new LesCases(nbCases);
		vitesseAnimation = 2;
		declareAlgo();
		initAndReset();
	}

	public Modele() {
		this(0);
	}

	private void declareAlgo() {
		collectionAlgo = new ArrayList<>();
		getAlgoClasses();
	}

	private void getAlgoClasses() {
		File directory = null;
		String relPath = ALGO_PACKAGE.replace('.', '/');

		URL resource = ClassLoader.getSystemClassLoader().getResource(relPath);
		if (resource == null) {
			throw new RuntimeException("No resource for " + relPath);
		}

		try {
			directory = new File(resource.toURI());
		} catch (URISyntaxException e) {
			throw new RuntimeException(ALGO_PACKAGE + " (" + resource + ") Invalid algos folder !", e);
		} catch (IllegalArgumentException e) {
			directory = null;
		}

		if (directory != null && directory.exists()) {
			// Get the list of the files contained in the package
			String[] files = directory.list();
			Class c = null;
			for (String file : directory.list()) {
				if (file.endsWith(".class") && !EXCLUDE_ALGO_CLASSES.contains(file)) {
					String className = ALGO_PACKAGE + '.' + file.substring(0, file.length() - 6);
					try {
						c = Class.forName(className);
						for (Constructor co : c.getConstructors()) {
							Object o;
							if (co.getParameterTypes().length == 1) {
								o = co.newInstance(lesCases);
							} else if (co.getParameterTypes().length == 2) {
								o = co.newInstance(this, lesCases);
							} else throw new AssertionError("Algo non supporté");

							if (o instanceof Algo) collectionAlgo.add((Algo) o);
						}
					} catch (ClassNotFoundException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	private void initAndReset() {
		threadLaunch = false;
		mouvCalc = false;
	}

	public void run() {
		setThreadLaunch(true);
		refreshUI();
		if (!isMouvCalc()) {
			try {
				collectionAlgo.get(getSelectionAlgo()).trier();
			}
			catch (Exception e){
			}
			setMouvCalc(true);
		}
		setThreadLaunch(false);
	}

	public void setVitesseAnimation(int vitesseAnimation) {
		this.vitesseAnimation = vitesseAnimation;
	}

	public int getNbAlgo() {
		return collectionAlgo.size();
	}

	public String getNomAlgo(int indice) {
		return collectionAlgo.get(indice).getNomAlgo();
	}

	public boolean isAlgoCustom() {
		return collectionAlgo.get(selectionAlgo).isAlgoCustom();
	}

	public int getSelectionAlgo() {
		return selectionAlgo;
	}

	public void setSelectionAlgo(int selectionAlgo) {
		this.selectionAlgo = selectionAlgo;
	}

	public void genererMouvements() {
		Thread creerMouv = new Thread((Runnable) this);
		creerMouv.start();
	}

	public Case getCase(int i) {
		return lesCases.getCase(i);
	}

	public int getNbCases() {
		return lesCases.getNbCases();
	}

	public int getVitesseAnimation() {
		return vitesseAnimation;
	}

	public int getMaxTemps() {
		return lesCases.getMaxTemps();
	}

	/**
	 * Créer une case
	 *
	 * @param xInit : Integer, Position X Initiale
	 * @param yInit : Integer, Position Y Initiale
	 * @param val   : Integer, Valeur de la case
	 */
	public void creerCase(int xInit, int yInit, int val) {
		lesCases.creerCases(xInit, yInit, val);
	}

	public void creerVariable(int xInit, int yInit, int val) {
		lesCases.creerVariable(xInit, yInit, val);
	}

	/**
	 * Redéfinie la position initiale d'une case
	 *
	 * @param numCase : Integer, Numéro de la case
	 * @param xInit   : Integer, nouvelle Position X
	 * @param yInit   : Integer, nouvelle Position Y
	 */
	public void setPosition(int numCase, int xInit, int yInit) {
		lesCases.getCase(numCase).setPosition(xInit, yInit);
	}

	public void refreshUI() {
		setChanged();
		notifyObservers();
	}

	@Override
	public String toString() {
		return lesCases.toString();
	}

	public int getNbVariables() {
		return lesCases.getNbVariables();
	}

	public boolean isMouvCalc() {
		return mouvCalc;
	}

	public void setMouvCalc(boolean mouvCalc) {
		this.mouvCalc = mouvCalc;
		refreshUI();
	}

	public void setThreadLaunch(boolean threadLaunch) {
		this.threadLaunch = threadLaunch;
	}

	public boolean isThreadLaunch() {
		return threadLaunch;
	}

	public void stopAndReset() {
		lesCases.resetMouv();
		initAndReset();
		refreshUI();
	}

	public void setRandomValeurs() {
		for (int i = 0; i < getNbCases(); i++) {
			getCase(i).setValeurInit(ThreadLocalRandom.current().nextInt(-100, 100));
		}
	}

	public void setAlgoPersoText(String text) {
		algoPersoText = text;
	}

	public String getAlgoPersoText() {
		return algoPersoText;
	}
}
