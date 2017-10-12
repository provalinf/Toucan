package toucan.mouvement;

public class MouvementMonter extends Mouvement {
	public MouvementMonter(int yDepl, int xInit, int yInit) {
		super(0, -yDepl, xInit, yInit);
		if (yDepl < 0) throw new AssertionError("yDepl ne doit pas etre négatif");

	}
}
