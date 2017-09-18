package toucan;

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
		return getPosX(lesMouvs.size());
	}

	public int getPosXInit(int nbMouv) {
		int i = 0;
		int horizontal = xInit;
		while (nbMouv <= lesMouvs.size() && i < nbMouv) {
			horizontal = lesMouvs.get(i).getPosX();
			i++;
		}
		return horizontal;
	}

	public int getPosX(int nbTemps) {
		int i = 0;
		int horizontal = xInit;
		if (nbTemps < tempsMax()) {
			while (nbTemps > lesMouvs.get(i).getTMax()) i++;
			return horizontal = lesMouvs.get(i).getPosXTmps(i);
		}
		if (lesMouvs.size() > 0)
			return lesMouvs.get(lesMouvs.size() - 1).getPosX();
		return horizontal;
	}

	private int getPosYInit() {
		return getPosY(lesMouvs.size());
	}

	public int getPosY(int nbTemps) {
		int i = 0;
		int vertical = yInit;
		if (nbTemps < tempsMax()) {
			while (nbTemps > lesMouvs.get(i).getTMax()) i++;
			return vertical = lesMouvs.get(i).getPosYTmps(i);
		}
		if (lesMouvs.size() > 0)
			return lesMouvs.get(lesMouvs.size() - 1).getPosY();
		return vertical;
	}

	public int getPosYInit(int nbMouv) {
		int i = 0;
		int vertical = yInit;
		while (nbMouv <= lesMouvs.size() && i < nbMouv) {
			vertical = lesMouvs.get(i).getPosY();
			i++;
		}
		return vertical;
	}

	public int tempsMax() {
		int tMax = 0;
		for (Mouvement lesMouv : lesMouvs) {
			if (lesMouv.getTMax() > tMax)
				tMax = lesMouv.getTMax();
		}
		return tMax;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Position actuelle/n");
		sb.append("x").append(getPosXInit()).append("/n");
		sb.append("y").append(getPosYInit()).append("/n");
		return sb.toString();
	}
}
