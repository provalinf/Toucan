package toucan.mouvement;

public class MouvementDroite extends Mouvement {
	public MouvementDroite(int xDepl, int xInit, int yInit) {
		super(xDepl, 0, xInit, yInit);
		if (xDepl < 0) throw new AssertionError("xDepl ne doit pas etre négatif");

	}
}
