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

	public void monter(int d, int val) {
		pos.monter(d, val);
	}

	public void monter(int d) {
		pos.monter(d, getValeurActuel());
	}

	public void gauche(int d, int val) {
		pos.gauche(d, val);
	}

	public void gauche(int d) {
		pos.gauche(d, getValeurActuel());
	}

	public void droite(int d, int val) {
		pos.droite(d, val);
	}

	public void droite(int d) {
		pos.droite(d, getValeurActuel());
	}

	public void descendre(int d, int val) {
		pos.descendre(d, val);
	}

	public void descendre(int d) {
		pos.descendre(d, getValeurActuel());
	}

	public void stable(int tmps, int val) {
		pos.stable(tmps, val);
	}

	public void stable(int tmps) {
		pos.stable(tmps, getValeurActuel());
	}

	public void setPosition(int xInit, int yInit) {
		pos.setPosition(xInit, yInit);
	}

	@Override
	public String toString() {
		return "Case{" +
				"pos=" + pos +
				'}';
	}
}
