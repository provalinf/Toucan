package toucan.algorithme;

import toucan.modele.Case;
import toucan.modele.LesCases;

public abstract class Algo {
	private final String nomAlgo;
	protected LesCases lesCases;
	protected boolean algoCustom;

	public Algo(LesCases lesCases, String nomAlgo) {
		this.lesCases = lesCases;
		this.nomAlgo = nomAlgo;
		algoCustom = false;
	}

	public boolean isAlgoCustom() {
		return algoCustom;
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
