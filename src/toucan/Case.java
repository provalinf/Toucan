package toucan;

public class Case {
	private int valeur;
	private LesMouvements pos;

	public Case(int xInit, int yInit, int val) {
		valeur = val;
		pos = new LesMouvements(xInit, yInit);
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public void monter(int d) {
		pos.monter(d);
	}

	public int getPosX(int nbMouv) {
		return pos.getPosX(nbMouv);
	}

	public int getPosY(int nbMouv) {
		return pos.getPosY(nbMouv);
	}

	public int getNbMouv() {
		return pos.nbMouv();
	}
}
