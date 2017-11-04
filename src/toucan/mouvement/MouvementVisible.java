package toucan.mouvement;

/**
 * Created by Valentin.
 */
public class MouvementVisible extends Mouvement {

	private boolean visible;

	public MouvementVisible(boolean visible, int xInit, int yInit) {
		super(xInit, yInit);
		mouvVisib = true;
		this.visible = visible;
	}

	public boolean isVisible() {
		return visible;
	}
}
