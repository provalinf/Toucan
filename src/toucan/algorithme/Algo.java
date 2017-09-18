package toucan.algorithme;

import toucan.modele.LesCases;

public abstract class Algo {
	protected LesCases lesCases;

	public Algo(LesCases lesCases) {
		this.lesCases = lesCases;
	}

	public abstract void trier();
}
