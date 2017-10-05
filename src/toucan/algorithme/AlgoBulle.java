package toucan.algorithme;

import toucan.graphique.animation.AffectationCaseCase;
import toucan.graphique.animation.AffectationVarCase;
import toucan.graphique.animation.ComparaisonCaseCase;
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
                ComparaisonCaseCase comparaisonCaseCase = new ComparaisonCaseCase();
                comparaisonCaseCase.executer(lesCases, i, i + 1); // Animation comparaison des cases
                if (lesCases.getCase(i).getValeur() > lesCases.getCase(i + 1).getValeur()) {
                    swap(lesCases, i, i + 1);
                    inversion = true;
                }
            }
        }
        while (inversion);
    }

    private void swap(LesCases lesCases, int c1, int c2) {
        AffectationVarCase affectationVarCase = new AffectationVarCase();
        affectationVarCase.executer(lesCases, c1); // Animation affectation de case
        Case cTemp = lesCases.getCase(c1);
        AffectationCaseCase affectationCaseCase = new AffectationCaseCase();
        affectationCaseCase.executer(lesCases, c1, c2); // Animation affectation d'une case à une autre
        lesCases.setCase(c1, lesCases.getCase(c2));
        AffectationVarCase affectationCaseVar = new AffectationVarCase();
        affectationCaseVar.executer(lesCases, c2); // Animation affectation de case
        lesCases.setCase(c2, cTemp);
    }
}
