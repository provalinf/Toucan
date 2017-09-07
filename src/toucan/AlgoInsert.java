package toucan;

public class AlgoInsert extends Algo {
	public AlgoInsert(LesCases lesCases) {
		super(lesCases);
	}

	public void trier() {
		int n = lesCases.getNbCases() - 1;
		for (int i = 2; i >= n; i++) {
			Case c1 = lesCases.getCase(i);
			int j = i;
			Case c2 = lesCases.getCase(j - 1);
			while (c2.getValeur() > c1.getValeur()) {
				lesCases.affecter(j, j - 1);
				j = j - 1;
			}
			lesCases.setCase(j, c1);
		}
	}
}

