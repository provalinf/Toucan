package toucan.graphique;

import toucan.modele.LesMouvements;

import java.awt.*;
import java.awt.image.BufferedImage;

public class CaseAnimation extends BufferedImage {

	private final LesMouvements pos;
	protected Graphics2D rond;

	protected int cote = 50;
	protected Color couleur;
	protected String valeur;

	/**
	 * Instanciation d'un élément graphique à dessiner (ici un carré)
	 *
	 * @param pos
	 * @param v   chaîne de caractère à écrire au centre de d'élément graphique
	 */
	public CaseAnimation(LesMouvements pos, int v, Color coul) {
		super(150, 150, BufferedImage.TYPE_INT_ARGB);
		this.pos = pos;
		rond = createGraphics();
		valeur = Integer.toString(v);
		couleur = coul;

		dessinerCase();
	}

	/**
	 * Dessin de l'élément graphique (l'élément graphique est redessiné, car sa couleur et son contenu peuvent
	 * changer au cours de l'animation)
	 */
	private void dessinerCase() {
		rond.setPaint(Color.white);
		rond.fillOval(0, 0, cote, cote);

		rond.setColor(couleur);
		rond.drawOval(0, 0, cote, cote);

		// dessin de la valeur au centre de la case
		rond.setFont(new Font("Arial", Font.BOLD, 16));

		FontMetrics fm = rond.getFontMetrics();
		int xC = (cote - fm.stringWidth(valeur)) / 2;
		int yC = (fm.getAscent() + (cote - (fm.getAscent() + fm.getDescent())) / 2);
		rond.drawString(valeur, xC, yC);
	}

	/**
	 * Dessin de l'élément graphique et positionnement dans la fenêtre graphique
	 *
	 * @param g fenêtre graphique dans laquelle on dessine
	 */
	public void dessiner(Graphics g, int t) {
		dessinerCase();

		int positionX = pos.getPosX(t);
		int positionY = pos.getPosY(t);

		g.drawImage(this, positionX, positionY, null);
	}

}
