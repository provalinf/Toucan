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

	public int getPosX(int nbTmps) {
		return pos.getPosX(nbTmps);
	}

	public int getPosY(int nbTmps) {
		return pos.getPosY(nbTmps);
	}

	public int getMaxTemps() {
		return pos.tempsMax();
	}

	public void monter(int d) {
		pos.monter(d);
	}

	public void gauche(int d) {
		pos.gauche(d);
	}

	public void droite(int d) {
		pos.droite(d);
	}

	public void descendre(int d) {
		pos.descendre(d);
	}

	public void stable(int tmps) {
		pos.stable(tmps);
	}

	public void setPosition(int xInit, int yInit) {
		pos.setPosition(xInit, yInit);
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	@Override
	public String toString() {
		return "Case{" +
				"pos=" + pos +
				'}';
	}
}
