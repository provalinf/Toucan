package toucan.algorithme;

import toucan.modele.Case;
import toucan.modele.LesCases;

public abstract class Algo {
	private final String nomAlgo;
	protected LesCases lesCases;

	public Algo(LesCases lesCases, String nomAlgo) {
		this.lesCases = lesCases;
		this.nomAlgo = nomAlgo;
	}

	public abstract void trier();

	public String getNomAlgo() {
		return nomAlgo;
	}

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
