package toucan.mouvement;

public class MouvementMonter extends Mouvement {
	public MouvementMonter(int yDepl, int xInit, int yInit, int val) {
		super(0, -yDepl, xInit, yInit, val);
		if (yDepl < 0) throw new AssertionError("yDepl ne doit pas etre négatif");
	}
}
