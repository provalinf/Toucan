package toucan.algorithme;

import toucan.graphique.animation.AffectationCaseCase;
import toucan.graphique.animation.AffectationCaseVar;
import toucan.graphique.animation.AffectationVarCase;
import toucan.graphique.animation.ComparaisonVarCase;
import toucan.modele.Case;
import toucan.modele.LesCases;


/**
 * Classe qui utilise l'algorithme du tri par insertion avec des animations
 */
public class AlgoInsert extends Algo {
	public AlgoInsert(LesCases lesCases) {
		super(lesCases, "Tri par insertion");
	}

	public void trier() {
		AffectationVarCase aVC1 = new AffectationVarCase();
		AffectationCaseCase aCC1 = new AffectationCaseCase();
		AffectationCaseVar aCV1 = new AffectationCaseVar();
		ComparaisonVarCase cVC1 = new ComparaisonVarCase();
		for (int i = 0; i < lesCases.getNbCases(); i++) {
			Case c1 = lesCases.getCase(i);
			aVC1.executer(lesCases, i);
			int j = i;

			boolean compare = true;
			while (j > 0 && compare) {
				cVC1.executer(lesCases, j - 1);
				equilibreStable();
				if (lesCases.getCase(j - 1).getValeurActuel() > lesCases.getVariable(0).getValeurActuel()) {
					aCC1.executer(lesCases, j, j - 1);
					equilibreStable();
					j--;
				} else compare = false;
			}

			aCV1.executer(lesCases, j);
			equilibreStable();
		}
	}
}