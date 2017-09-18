package toucan.algorithme;

import toucan.Case;
import toucan.LesCases;

public class AlgoInsert extends Algo {
	public AlgoInsert(LesCases lesCases) {
		super(lesCases);
	}

	public void trier() {
		for (int i = 1; i < lesCases.getNbCases(); i++) {
			Case c1 = lesCases.getCase(i);
			int j = i;
			while (j > 0 && lesCases.getCase(j - 1).getValeur() > c1.getValeur()) {
				lesCases.setCase(j, lesCases.getCase(j - 1));
				j = j - 1;
			}
			lesCases.setCase(j, c1);
		}
	}
}

