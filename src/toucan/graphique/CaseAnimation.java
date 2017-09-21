package toucan.graphique;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 24 juin 2014 - maj 29 août 2017
 *
 * @author brigitte wrobel-dautcourt
 */

public class CaseAnimation extends BufferedImage {

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
     * @param v chaîne de caractère à écrire au centre de d'élément graphique
     * @param x abscisse initiale de l'élément graphique dans la fenêtre
     * @param y ordonnée initiale de l'élément graphique dans la fenêtre
     */
    public CaseAnimation(String v, int x, int y, Color coul) {
        super(150, 150, BufferedImage.TYPE_INT_ARGB);
        carre = createGraphics();
        valeur = v;
        positionX = x;
        positionY = y;
        couleur = coul;

        long germe = System.nanoTime();
        rand = new Random(germe);
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
     * Calcul aléatoire du déplacement à effectuer sur une coordonnée de l'élément graphique
     *
     * @return déplacement à effectuer
     * <p>
     * Cette fonction pourra être détruite lors de l'animation de vos propres cases
     */
    private int deplacement() {
        // calcul du signe du déplacement
        int signe;
        if (rand.nextInt(2) % 2 == 0) signe = 1;
        else signe = -1;

        // calcul du pas du déplacement
        int pas;
        pas = 1;

        return (pas * signe);
    }

    // l'argument t n'est pas utile pour cette version de code
    private int posX(int t) {
        return positionX + deplacement(); // à modifier lors de l'animation de vos propres cases
        // la fonction deplacement() devriendra inutile
    }

    // l'argument t n'est pas utile pour cette version de code
    private int posY(int t) {
        return positionY + deplacement(); // à modifier lors de l'animation de vos propres cases
        // la fonction deplacement() devriendra inutile
    }

    /**
     * Dessin de l'élément graphique et positionnement dans la fenêtre graphique
     *
     * @param g fenêtre graphique dans laquelle on dessine
     */
    public void dessiner(Graphics g, int t) {
        dessinerCase();

        positionX = posX(t);
        positionY = posY(t);

        g.drawImage(this, positionX, positionY, null);
    }

}
