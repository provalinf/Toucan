package toucan.modele;

import toucan.graphique.CaseAnimation;

import java.awt.*;

public class Case {
	private LesMouvements pos;
	private CaseAnimation cAnim;

	public Case(int xInit, int yInit, int valInit) {
		pos = new LesMouvements(xInit, yInit, valInit);
		cAnim = new CaseAnimation(pos, Color.BLACK);
	}

	public void dessiner(Graphics g, int tmps) {
		cAnim.dessiner(g, tmps);
	}

	public int getValeur(int nbTmps) {
		return pos.getValeur(nbTmps);
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

	public void setColor(Color couleur){
		cAnim.setColor(couleur);
	}

	public Color getColor(){
		return cAnim.getColor();
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

	public void setVisible(boolean visible) {
		pos.setVisible(visible);
	}

	public void setPosition(int xInit, int yInit) {
		pos.setPosition(xInit, yInit);
	}

	public void setValeur(int valeur) {
		pos.setValeur(valeur);
	}

	@Override
	public String toString() {
		return "Case{" +
				"pos=" + pos +
				'}';
	}

	public void resetMouv() {
		pos.clearMouv();
	}
}
