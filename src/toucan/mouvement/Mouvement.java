package toucan.mouvement;

public class Mouvement {
	protected int xDepl;
	protected int yDepl;
	protected int xInit;
	protected int yInit;
	protected int tInit;
	protected int tArriv;
	protected int tMax;

	public Mouvement(int xDepl, int yDepl, int xInit, int yInit) {
		this(0, xInit, yInit);
		this.xDepl = xDepl;
		this.yDepl = yDepl;
	}

	public Mouvement(int temps, int xInit, int yInit) {
		this.xInit = xInit;
		this.yInit = yInit;
		xDepl = 0;
		yDepl = 0;
		tInit = 0;
		tArriv = temps;
	}

	public int getPosX() {
		return xInit + xDepl;
	}

	public int getPosY() {
		return yInit + yDepl;
	}

	public int getPosXTmps(int tmp) {
		if (tmp < xDepl) return tmp;
		return xDepl;
	}

	public int getPosYTmps(int tmp) {
		if (tmp < yDepl) return tmp;
		return yDepl;
	}

	public int getTMax() {
		return Math.abs(xDepl) + Math.abs(yDepl) + tArriv;
	}
}
