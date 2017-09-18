package toucan.modele;

import toucan.mouvement.*;

import java.util.ArrayList;

public class LesMouvements {
	private ArrayList<Mouvement> lesMouvs;
	private int xInit;
	private int yInit;

	public LesMouvements(int xInit, int yInit) {
		lesMouvs = new ArrayList<>(0);
		this.xInit = xInit;
		this.yInit = yInit;
	}

	public void monter(int dep) {
		lesMouvs.add(new MouvementMonter(dep, getPosXInit(), getPosYInit()));
	}

	public void gauche(int dep) {
		lesMouvs.add(new MouvementGauche(dep, getPosXInit(), getPosYInit()));
	}

	public void droite(int dep) {
		lesMouvs.add(new MouvementDroite(dep, getPosXInit(), getPosYInit()));
	}

	public void descendre(int dep) {
		lesMouvs.add(new MouvementDescendre(dep, getPosXInit(), getPosYInit()));
	}

	public void stable(int tmps) {
		lesMouvs.add(new MouvementStable(tmps, getPosXInit(), getPosYInit()));
	}

	private int getPosXInit() {
		return getPosXInit(lesMouvs.size());
	}

	/**
	 * Calcul de la position X initiale pour un mouvement donné
	 *
	 * @param nbMouv : Integer, Nombre de mouvement
	 * @return Integer, Position X
	 */
	public int getPosXInit(int nbMouv) {
		int i = 0;
		int horizontal = xInit;
		while (nbMouv <= lesMouvs.size() && i < nbMouv) {
			horizontal = lesMouvs.get(i).getPosX();
			i++;
		}
		return horizontal;
	}

	/**
	 * Calcul de la position X à un temps donné
	 *
	 * @param nbTemps : Integer, temps donné
	 * @return Integer, Position X
	 */
	public int getPosX(int nbTemps) {
		if (lesMouvs.size() == 0) return xInit;
		int i = 0;

		while (i + 1 < lesMouvs.size() && nbTemps > lesMouvs.get(i).getTMax()) {
			i++;
			nbTemps -= lesMouvs.get(i - 1).getTMax();
		}
		return lesMouvs.get(i).getPosXTmps(nbTemps);
	}

	private int getPosYInit() {
		return getPosYInit(lesMouvs.size());
	}

	/**
	 * Calcul de la position Y à un temps donné
	 *
	 * @param nbTemps : Integer, temps donné
	 * @return Integer, Position Y
	 */
	public int getPosY(int nbTemps) {
		if (lesMouvs.size() == 0) return yInit;
		int i = 0;

		while (i + 1 < lesMouvs.size() && nbTemps > lesMouvs.get(i).getTMax()) {
			i++;
			nbTemps -= lesMouvs.get(i - 1).getTMax();
		}
		return lesMouvs.get(i).getPosYTmps(nbTemps);
	}

	/**
	 * Calcul de la position Y initiale pour un mouvement donné
	 *
	 * @param nbMouv : Integer, Nombre de mouvement
	 * @return Integer, Position Y
	 */
	public int getPosYInit(int nbMouv) {
		int i = 0;
		int vertical = yInit;
		while (nbMouv <= lesMouvs.size() && i < nbMouv) {
			vertical = lesMouvs.get(i).getPosY();
			i++;
		}
		return vertical;
	}

	/**
	 * Temps maximum d'un mouvement
	 *
	 * @return integer : Temps max
	 */
	public int tempsMaxInit() {
		int tMax = 0;
		for (Mouvement lesMouv : lesMouvs) {
			if (lesMouv.getTMax() > tMax)
				tMax = lesMouv.getTMax();
		}
		return tMax;
	}

	/**
	 * Sommes des temps des mouvements
	 *
	 * @return integer : Temps max
	 */
	public int tempsMax() {
		int tMax = 0;
		for (Mouvement lesMouv : lesMouvs) {
			tMax += lesMouv.getTMax();
		}
		return tMax;
	}

	public void setPosition(int xInit, int yInit) {
		this.xInit = xInit;
		this.yInit = yInit;
	}

	@Override
	public String toString() {
		return "LesMouvements{\n" +
				"\txInit=" + xInit +
				", yInit=" + yInit +
				", \n\tlesMouvs=" + lesMouvs +
				"\n}";
	}
}
