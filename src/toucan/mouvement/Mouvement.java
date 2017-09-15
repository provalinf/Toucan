package toucan.mouvement;

public class Mouvement {
	protected int xDepl;
	protected int yDepl;
	protected int xInit;
	protected int yInit;

	public Mouvement(int xDepl, int yDepl, int xInit, int yInit) {
		this.xDepl = xDepl;
		this.yDepl = yDepl;
		this.xInit = xInit;
		this.yInit = yInit;
	}

	public int getPosX() {
		return xInit + xDepl;
	}

	public int getPosY() {
		return yInit + yDepl;
	}
}
