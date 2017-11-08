package toucan.modele;

import toucan.algorithme.*;
import toucan.graphique.animation.ComparaisonCaseCase;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Modele extends Observable implements Runnable {

	public static final int NORD = 0;
	public static final int SUD = 1;
	public static final int EST = 2;
	public static final int OUEST = 3;
	public static final int STABLE = 4;

	public static final int TAILLE_CASE = 50;
	public static final Color DEFAULT_COLOR_CASE = Color.BLACK;

	private LesCases lesCases;
	private int vitesseAnimation;
	private boolean threadLaunch;
	private boolean mouvCalc;

	private HashMap<Integer, Algo> collectionAlgo;
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

	/**
	 * Temporaire, sera remplacé par une detection des classes afin de rendre le tout automatique et propre
	 */
	private void declareAlgo() {
		ArrayList<Algo> collectionAlgo2 = new ArrayList<>();
		/*try {*/
		Object o = null;


		/*try {
			URLClassLoader loader = new URLClassLoader(new URL[]{file.toURI().toURL()});
			Class c = Class.forName("editeur.styles."+file.getName().split(".jar")[0], true, loader);
			Object o = null;
			try {
				o = c.getConstructor().newInstance();
			} catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
				e.printStackTrace();
			}
			return (Style) o;
		} catch (ClassNotFoundException | MalformedURLException e) {
			e.printStackTrace();
		}
		*/
		getClassesForPackage();


		collectionAlgo = new HashMap<>(3);
		collectionAlgo.put(0, new AlgoBulle(lesCases));
		collectionAlgo.put(1, new AlgoInsert(lesCases));
		collectionAlgo.put(2, new AlgoSelection(lesCases));
	}


	private List<Class> getClassesForPackage(){
		String pkgname = "toucan.algorithme";

		List<Class> classes = new ArrayList<Class>();
		List<String> exclude = Arrays.asList("Algo.class");

		File directory = null;
		String relPath = pkgname.replace('.', '/');

		URL resource = ClassLoader.getSystemClassLoader().getResource(relPath);
		if (resource == null) {
			throw new RuntimeException("No resource for " + relPath);
		}

		try {
			directory = new File(resource.toURI());
		} catch (URISyntaxException e) {
			throw new RuntimeException(pkgname + " (" + resource + ") does not appear to be a valid URL / URI.  Strange, since we got it from the system...", e);
		} catch (IllegalArgumentException e) {
			directory = null;
		}
		//System.out.println("ClassDiscovery: Directory = " + directory);

		if (directory != null && directory.exists()) {

			// Get the list of the files contained in the package
			String[] files = directory.list();
			for (int i = 0; i < files.length; i++) {

				if (files[i].endsWith(".class") && !exclude.contains(files[i])) {
					System.out.println(files[i]);
					// removes the .class extension
					String className = pkgname + '.' + files[i].substring(0, files[i].length() - 6);

					//System.out.println("ClassDiscovery: className = " + className);

					try {
						classes.add(Class.forName(className));
					} catch (ClassNotFoundException e) {
						throw new RuntimeException("ClassNotFoundException loading " + className);
					}
				}
			}
		}
		return classes;
	}



	private void initAndReset() {
		threadLaunch = false;
		mouvCalc = false;
	}

	/**
	 * Créer les mouvements à partir d'un tableau de int
	 *
	 * @param mouvs : Numéro de la case, Direction du mouvement, Distance
	 */
	/*public void creerLesMouvements(int... mouvs) {
		for (int i = 0; i + 3 <= mouvs.length; i += 3) {
			switch (mouvs[i + 1]) {
				case SUD:
					lesCases.monter(mouvs[i], mouvs[i + 2]);
					break;
				case NORD:
					lesCases.descendre(mouvs[i], mouvs[i + 2]);
					break;
				case EST:
					lesCases.droite(mouvs[i], mouvs[i + 2]);
					break;
				case OUEST:
					lesCases.gauche(mouvs[i], mouvs[i + 2]);
					break;
				case STABLE:
					lesCases.stable(mouvs[i], mouvs[i + 2]);
			}
		}
		setChanged();
		notifyObservers();
	}*/
	public void run() {
		setThreadLaunch(true);
		refreshUI();
		if (!isMouvCalc()) {
			AlgoFacade algoFacade = new AlgoFacade(this, lesCases);
			algoFacade.trier();
			/*AlgoTest algo = new AlgoTest(lesCases);
			algo.trier();*/
			//collectionAlgo.get(getSelectionAlgo()).trier();
			/*ComparaisonCaseCase comp = new ComparaisonCaseCase();
			comp.executer(lesCases, 0, 1);*/
			/*IAnimation affectCases = new AffectationCaseCase();
			affectCases.executer(lesCases, 0, 1);
			affectCases.executer(lesCases, 1, 3);*/
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
