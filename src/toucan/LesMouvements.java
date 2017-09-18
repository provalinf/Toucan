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
		lesMouvs.add(new MouvementMonter(dep, getPosXInit(), getPosY()));
	}

	public void gauche(int dep) {
		lesMouvs.add(new MouvementGauche(dep, getPosXInit(), getPosY()));
	}

	public void droite(int dep) {
		lesMouvs.add(new MouvementDroite(dep, getPosXInit(), getPosY()));
	}

	public void descendre(int dep) {
		lesMouvs.add(new MouvementDescendre(dep, getPosXInit(), getPosY()));
	}

	public void stable(int tmps) {
		lesMouvs.add(new MouvementStable(tmps, getPosX(), getPosY()));
	}

	private int getPosX() {
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
		while (nbTemps <= tempsMax() && i < nbTemps) {
			horizontal = lesMouvs.get(i).getPosXTmps(i);
			if (nbTemps > lesMouvs.get(i).getTMax())
				i++;
		}
		return horizontal;
	}

	private int getPosY() {
		return getPosY(lesMouvs.size());
	}

	public int getPosYInit(int nbTemps) {
		int i = 0;
		int vertical = yInit;
		while (nbTemps <= tempsMax() && i < nbTemps) {
			vertical = lesMouvs.get(i).getPosYTmps(i);
			i++;
		}
		return vertical;
	}

	public int getPosY(int nbMouv) {
		int i = 0;
		int vertical = yInit;
		while (nbMouv <= nbMouv() && i < nbMouv) {
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
		sb.append("x").append(getPosX()).append("/n");
		sb.append("y").append(getPosY()).append("/n");
		return sb.toString();
	}
}
