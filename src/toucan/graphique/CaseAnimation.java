package toucan.graphique;

import toucan.modele.LesMouvements;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 24 juin 2014 - maj 29 août 2017
 *
 * @author brigitte wrobel-dautcourt
 */

public class CaseAnimation extends BufferedImage {

	private final LesMouvements pos;
	protected Graphics2D carre;

	protected int cote = 50;
	protected Color couleur;
	protected int positionX;
	protected int positionY;
	protected String valeur;

	protected Random rand;

	/**
	 * Instanciation d'un élément graphique à dessiner (ici un carré)
	 *
	 * @param pos
	 * @param v chaîne de caractère à écrire au centre de d'élément graphique
	 * @param x abscisse initiale de l'élément graphique dans la fenêtre
	 * @param y ordonnée initiale de l'élément graphique dans la fenêtre
	 */
	public CaseAnimation(LesMouvements pos, int v, int x, int y, Color coul) {
		super(150, 150, BufferedImage.TYPE_INT_ARGB);
		this.pos = pos;
		carre = createGraphics();
		valeur = Integer.toString(v);
		positionX = x;
		positionY = y;
		couleur = coul;

		dessinerCase();
	}

	/**
	 * Dessin de l'élément graphique (l'élément graphique est redessiné, car sa couleur et son contenu peuvent
	 * changer au cours de l'animation)
	 */
	private void dessinerCase() {
		carre.setPaint(Color.white);
		carre.fillOval(0, 0, cote, cote);

		carre.setColor(couleur);
		carre.drawOval(0, 0, cote, cote);

		// dessin de la chaîne au centre de la case
		carre.setFont(new Font("Arial", Font.BOLD, 16));

		FontMetrics fm = carre.getFontMetrics();
		int xC = (cote - fm.stringWidth(valeur)) / 2;
		int yC = (fm.getAscent() + (cote - (fm.getAscent() + fm.getDescent())) / 2);
		carre.drawString(valeur, xC, yC);
	}

	/**
	 * Dessin de l'élément graphique et positionnement dans la fenêtre graphique
	 *
	 * @param g fenêtre graphique dans laquelle on dessine
	 */
	public void dessiner(Graphics g, int t) {
		dessinerCase();

		positionX = pos.getPosX(t);
		positionY = pos.getPosY(t);

		g.drawImage(this, positionX, positionY, null);
	}

}
