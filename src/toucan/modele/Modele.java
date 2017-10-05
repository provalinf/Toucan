package toucan.modele;

import java.util.Observable;

public class Modele extends Observable {

	public static final int NORD = 0;
	public static final int SUD = 1;
	public static final int EST = 2;
	public static final int OUEST = 3;
	public static final int STABLE = 4;

	public static final int TAILLE_CASE = 50;

	private LesCases lesCases;
	private final int tempsDeLatence = 8;

	public Modele(int nbCases) {
		lesCases = new LesCases(nbCases);
	}

	public Modele() {
		this(0);
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
	public void creerLesMouvements(int... mouvs) {
		IAnimation affectCases = new AffectationCaseCase();
		affectCases.executer(lesCases, 0, 1);
		//affectCases.executer(lesCases, 1, 3);
		setChanged();
		notifyObservers();
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

	@Override
	public String toString() {
		return lesCases.toString();
	}
}
