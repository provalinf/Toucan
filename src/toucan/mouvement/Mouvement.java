package toucan.mouvement;

public class Mouvement {
	protected int xDepl;
	protected int yDepl;
	protected int xInit;
	protected int yInit;
	protected int tStable;

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
		tStable = temps;
	}

	public int getPosX() {
		return xInit + xDepl;
	}

	public int getPosY() {
		return yInit + yDepl;
	}

	public int getPosXTmps(int tmp) {
		if (tmp < xDepl) return tmp + xInit;
		return getPosX();
	}

	public int getPosYTmps(int tmp) {
		if (tmp < yDepl) return tmp + yInit;
		return getPosY();
	}

	public int getTMax() {
		return Math.abs(xDepl) + Math.abs(yDepl) + tStable;
	}

	@Override
	public String toString() {
		return "\n\t\tMouvement{" +
				" xInit=" + xInit +
				", yInit=" + yInit +
				",\n\t\txDepl=" + xDepl +
				", yDepl=" + yDepl +
				"\n\t}";
	}
}
