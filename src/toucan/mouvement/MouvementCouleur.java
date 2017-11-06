package toucan.mouvement;

import java.awt.*;

/**
 * Created by Valentin.
 */
public class MouvementCouleur extends Mouvement {

	private Color couleur;

	public MouvementCouleur(Color couleur, int xInit, int yInit) {
		super(xInit, yInit);
		mouvColor = true;
		this.couleur = couleur;
	}

	public Color getCouleur() {
		return couleur;
	}
}
