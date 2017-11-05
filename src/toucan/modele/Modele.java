package toucan.modele;

import toucan.algorithme.Algo;
import toucan.algorithme.AlgoBulle;
import toucan.algorithme.AlgoInsert;
import toucan.algorithme.AlgoSelection;

import java.util.HashMap;
import java.util.Observable;

public class Modele extends Observable implements Runnable {

	public static final int NORD = 0;
	public static final int SUD = 1;
	public static final int EST = 2;
	public static final int OUEST = 3;
	public static final int STABLE = 4;

	public static final int TAILLE_CASE = 50;

	private LesCases lesCases;
	private final int tempsDeLatence = 1;
	private boolean threadLaunch;
	private boolean mouvCalc;

	private HashMap<Integer, Algo> collectionAlgo;
	private int selectionAlgo;

	public Modele(int nbCases) {
		lesCases = new LesCases(nbCases);
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
		collectionAlgo = new HashMap<>(3);
		collectionAlgo.put(0, new AlgoBulle(lesCases));
		collectionAlgo.put(1, new AlgoInsert(lesCases));
		collectionAlgo.put(2, new AlgoSelection(lesCases));
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
			/*AlgoTest algo = new AlgoTest(lesCases);
			algo.trier();*/
			collectionAlgo.get(getSelectionAlgo()).trier();
			/*IAnimation affectCases = new AffectationCaseCase();
			affectCases.executer(lesCases, 0, 1);
			affectCases.executer(lesCases, 1, 3);*/
			setMouvCalc(true);
		}
		setThreadLaunch(false);
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

	public int getTempsDeLatence() {
		return tempsDeLatence;
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
}
