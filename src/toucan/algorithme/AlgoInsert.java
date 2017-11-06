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
        super(lesCases);
    }

    public void trier() {
        for (int i = 1; i < lesCases.getNbCases(); i++) {
            Case c1 = lesCases.getCase(i);
            Case c2;

            int j = i - 1;
            boolean verif = true;
            do{
                verif = false;
                c2 = lesCases.getCase(j);
                if (c2.getValeurActuel() > c1.getValeurActuel()) {
                    AffectationVarCase aVC1 = new AffectationVarCase();
                    AffectationCaseCase aCC1 = new AffectationCaseCase();
                    AffectationCaseVar aCV1 = new AffectationCaseVar();
                    aVC1.executer(lesCases, i);
                    equilibreStable();
                    aCC1.executer(lesCases, i, j - 1);
                    equilibreStable();
                    aCV1.executer(lesCases, j - 1);
                    equilibreStable();
                    j--;
                    verif = true;
                } else {
                    // couleur : on ne modifie pas la place de cette case car bien placée
                    verif = false;
                }
            }
            while (j > 0 && verif);
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