package toucan.algorithme;

import toucan.modele.Case;
import toucan.modele.LesCases;

public abstract class Algo {
	protected LesCases lesCases;

	public Algo(LesCases lesCases) {
		this.lesCases = lesCases;
	}

	public abstract void trier();

	protected void equilibreStable() {
		int maxtemps = lesCases.getMaxTemps();
		for (int i = 0; i < lesCases.getNbCases() + lesCases.getNbVariables(); i++) {
			Case cTmp = lesCases.getCase(i);
			if (cTmp.getMaxTemps() != maxtemps) {
				cTmp.stable(maxtemps - cTmp.getMaxTemps());
			}
		}
	}
}
