package toucan.algorithme;

import toucan.modele.Case;
import toucan.modele.LesCases;

public class AlgoBulle extends Algo {

    public AlgoBulle(LesCases lesCases) {
        super(lesCases);
    }


    public void trier() {
		int longueur = lesCases.getNbCases();
		boolean inversion;
		do {
			inversion = false;
			for (int i = 0; i < longueur - 1; i++) {
                comparaisonCaseCase.executer(lesCases, i, i+1) ;
				if (lesCases.getCase(i).getValeur() > lesCases.getCase(i + 1).getValeur()) {
					swap(lesCases, i, i + 1);
					inversion = true;
				}
			}
		}
		while (inversion);
	}

    private void swap(LesCases lesCases, int c1, int c2) {
        affectationVarCase.executer(lesCases, c1) ;
        Case cTemp = lesCases.getCase(c1);
        affectationCaseCase.executer(lesCases, c1, c2);
        lesCases.setCase(c1, lesCases.getCase(c2));
        affectationCaseVar.executer(lesCases, c2) ;
        lesCases.setCase(c2, cTemp);
    }
}
