package toucan.modele;

import toucan.LesCases;

public class Modele {

	public static final int NORD = 0;
	public static final int SUD = 1;
	public static final int EST = 2;
	public static final int OUEST = 3;
	public static final int STABLE = 4;

	private LesCases lesCases;

	public Modele(int nbCases) {
		lesCases = new LesCases(nbCases);
	}

	public void creerLesMouvements(int[] mouvs) {
		for (int i = 0; i+3 <= mouvs.length; i+=3) {
			switch (mouvs[i+1]) {
				case NORD:
					lesCases.monter(mouvs[i], mouvs[i+2]);
					break;
				case SUD:
					lesCases.descendre(mouvs[i], mouvs[i+2]);
					break;
				case EST:
					lesCases.droite(mouvs[i], mouvs[i+2]);
					break;
				case OUEST:
					lesCases.gauche(mouvs[i], mouvs[i+2]);
					break;
				case STABLE:
					lesCases.stable(mouvs[i]);
			}
		}
	}

	public void creerCase(int xInit, int yInit, int val) {
		lesCases.creerCases(xInit, yInit, val);
	}

	public void setPosition(int i, int i1, int i2) {
		creerCase(i, i1, i2);
	}

	@Override
	public String toString() {
		return lesCases.toString();
	}
}
