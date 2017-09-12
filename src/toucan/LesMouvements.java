package toucan;

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
		lesMouvs.add(new MouvementMonter(dep, getPosX(), getPosY()));
	}

	public void gauche(int dep) {
		lesMouvs.add(new MouvementGauche(dep, getPosX(), getPosY()));
	}

	public void droite(int dep) {
		lesMouvs.add(new MouvementDroite(dep, getPosX(), getPosY()));
	}

	public void descendre(int dep) {
		lesMouvs.add(new MouvementDescendre(dep, getPosX(), getPosY()));
	}

	public void stable() {
		lesMouvs.add(new MouvementStable(getPosX(), getPosY()));
	}

	private int getPosX() {
		return getPosX(lesMouvs.size());
	}

	public int getPosX(int nbMouv) {
		int i = 0;
		int horizontal = xInit;
		while (nbMouv <= nbMouv() && i < nbMouv) {
			horizontal = lesMouvs.get(i).getPosX();
			i++;
		}
		return horizontal;
	}

	private int getPosY() {
		return getPosY(lesMouvs.size());
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

	public int nbMouv() {
		return lesMouvs.size();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Position actuelle/n");
		sb.append("x").append(getPosX()).append("/n");
		sb.append("y").append(getPosY()).append("/n");
		return sb.toString();
	}
}
