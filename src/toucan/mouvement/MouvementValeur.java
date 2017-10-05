package toucan.mouvement;

/**
 * Created by bonnal4u.
 */
public class MouvementValeur extends Mouvement {

	private int valeur;

	public MouvementValeur(int valeur, int xInit, int yInit) {
		super(xInit, yInit);
		mouvVal = true;
		this.valeur = valeur;
	}

	public int getValeur() {
		return valeur;
	}
}
