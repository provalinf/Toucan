package toucan.mouvement;

public class Mouvement {
	protected int xDepl;
	protected int yDepl;
	protected int xInit;
	protected int yInit;
	private int tStable;

	protected boolean mouvVal;
	protected boolean mouvVisib;
	protected boolean mouvColor;

	public Mouvement(int xDepl, int yDepl, int xInit, int yInit) {
		this(0, xInit, yInit);
		this.xDepl = xDepl;
		this.yDepl = yDepl;
	}

	public Mouvement(int temps, int xInit, int yInit) {
		this(xInit, yInit);
		tStable = temps;
	}

	public Mouvement(int xInit, int yInit) {
		this.xInit = xInit;
		this.yInit = yInit;
		xDepl = 0;
		yDepl = 0;
		tStable = 0;
		mouvVal = false;
		mouvVisib = false;
		mouvColor = false;
	}

	public int getPosX() {
		return xInit + xDepl;
	}

	public int getPosY() {
		return yInit + yDepl;
	}

	/**
	 * Calcule la position de X à un temps t
	 *
	 * @param tmp : Integer, Temps t
	 * @return Integer, Position X
	 */
	public int getPosXTmps(int tmp) {
		if (xDepl < 0 && tmp < Math.abs(xDepl)) return xInit - tmp;
		if (tmp < xDepl) return tmp + xInit;
		return getPosX();
	}

	/**
	 * Calcule la position de Y à un temps t
	 *
	 * @param tmp : Integer, Temps t
	 * @return Integer, Position Y
	 */
	public int getPosYTmps(int tmp) {
		if (yDepl < 0 && tmp < Math.abs(yDepl)) return yInit - tmp;
		if (tmp < yDepl) return tmp + yInit;
		return getPosY();
	}

	/**
	 * Calcule le temps max du mouvement
	 *
	 * @return : Integer, Temps max du mouvement
	 */
	public int getTMax() {
		return Math.abs(xDepl) + Math.abs(yDepl) + tStable;
	}

	public boolean isMouvVal() {
		return mouvVal;
	}

	public boolean isMouvVisib() {
		return mouvVisib;
	}

	public boolean isMouvColor() {
		return mouvColor;
	}

	@Override
	public String toString() {
		return "\n\t\tMouvement{" +
				" xInit=" + xInit +
				", yInit=" + yInit +
				",\n\t\txDepl=" + xDepl +
				", yDepl=" + yDepl +
				", tStable=" + tStable +
				",\n\t\tAprès mouvement : x=" + getPosX() + ", y=" + getPosY() +
				"\n\t}";
	}
}
