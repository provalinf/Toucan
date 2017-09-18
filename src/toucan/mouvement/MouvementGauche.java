package toucan.mouvement;

public class MouvementGauche extends Mouvement {
	public MouvementGauche(int xDepl, int xInit, int yInit) {
		super(-xDepl, 0, xInit, yInit);

	}
}
