package toucan.mouvement;

public class MouvementStable extends Mouvement {
	public MouvementStable(int temps, int xInit, int yInit) {
		super(temps, xInit, yInit);
		if (temps < 0) throw new AssertionError("temps de stable ne doit pas etre négatif");
	}
}
