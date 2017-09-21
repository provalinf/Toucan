package toucan.modele;

import toucan.graphique.CaseAnimation;

import java.awt.*;

public class Case {
	private int valeur;
	private LesMouvements pos;
	private CaseAnimation cAnim;

	public Case(int xInit, int yInit, int val) {
		valeur = val;
		pos = new LesMouvements(xInit, yInit);
		cAnim = new CaseAnimation(pos, val, xInit, yInit, Color.BLACK);
	}

	public void dessiner(Graphics g, int tmps) {
		cAnim.dessiner(g, tmps);
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
