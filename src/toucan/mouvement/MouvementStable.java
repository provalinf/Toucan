package toucan.mouvement;

public class MouvementStable extends Mouvement {
	public MouvementStable(int temps, int xInit, int yInit, int val) {
		super(temps, xInit, yInit, val);
		if (temps < 0) throw new AssertionError("temps de stable ne doit pas etre négatif");
	}
}
