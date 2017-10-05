package toucan.modele;

import toucan.graphique.CaseAnimation;

import java.awt.*;

public class Case {
	private LesMouvements pos;
	private CaseAnimation cAnim;

	public Case(int xInit, int yInit, int val) {
		pos = new LesMouvements(xInit, yInit, val);
		cAnim = new CaseAnimation(pos, val, Color.BLACK);
	}

	public void dessiner(Graphics g, int tmps) {
		cAnim.dessiner(g, tmps);
	}

	public int getValeurActuel() {
		return pos.getValeur(getMaxTemps());
	}

	public int[] getPosActuel() {
		return new int[]{getPosX(getMaxTemps()), getPosY(getMaxTemps())};
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
