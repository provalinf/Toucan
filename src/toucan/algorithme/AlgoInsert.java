package toucan.algorithme;

import toucan.graphique.animation.AffectationCaseCase;
import toucan.graphique.animation.AffectationCaseVar;
import toucan.graphique.animation.AffectationVarCase;
import toucan.modele.Case;
import toucan.modele.LesCases;

import static toucan.modele.Modele.TAILLE_CASE;


/**
 *Classe qui utilise l'algorithme du tri par insertion avec des animations
 */
public class AlgoInsert extends Algo {
    public AlgoInsert(LesCases lesCases) {
        super(lesCases, "Tri par insertion");
    }

    public void trier() {
        AffectationVarCase aVC1 = new AffectationVarCase();
        AffectationCaseCase aCC1 = new AffectationCaseCase();
        AffectationCaseVar aCV1 = new AffectationCaseVar();
        for (int i = 0; i < lesCases.getNbCases(); i++) {
            Case c1 = lesCases.getCase(i);
            aVC1.executer(lesCases, i);
            int j = i;

            while (j > 0 && lesCases.getCase(j-1).getValeurActuel() > lesCases.getVariable(0).getValeurActuel()){
                aCC1.executer(lesCases, j, j-1);
                equilibreStable();
                j--;
            }

            aCV1.executer(lesCases, j);
            equilibreStable();
        }
    }
}

/*			while (j > 0 && (c2 = lesCases.getCase(j - 1)).getValeurActuel() > c1.getValeurActuel()) {
				int[] posC2 = c2.getPosActuel();
				if () {
					c3 = lesCases.getCase(j);
				}
				lesCases.setCase(j, c2);
				j = j - 1;
			}*/