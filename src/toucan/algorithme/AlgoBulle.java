package toucan.algorithme;

import toucan.graphique.animation.AffectationCaseCase;
import toucan.graphique.animation.AffectationCaseVar;
import toucan.graphique.animation.AffectationVarCase;
import toucan.modele.Case;
import toucan.modele.LesCases;

import static toucan.modele.Modele.TAILLE_CASE;

public class AlgoBulle extends Algo {

	public AlgoBulle(LesCases lesCases) {
		super(lesCases);
	}

	@Override
	public void trier() {
		boolean inversion;
		do {
			inversion = false;
			for (int i = 0; i < lesCases.getNbCases() - 1; i++) {
				Case c1 = lesCases.getCase(i);
				Case c2 = lesCases.getCase(i + 1);

				if (c1.getValeurActuel() > c2.getValeurActuel()) {
					AffectationVarCase aVC1 = new AffectationVarCase();
					AffectationCaseCase aCC1 = new AffectationCaseCase();
					AffectationCaseVar aCV1 = new AffectationCaseVar();
					aVC1.executer(lesCases, i);
					equilibreStable();
					aCC1.executer(lesCases, i, i+1);
					equilibreStable();
					aCV1.executer(lesCases, i+1);
					equilibreStable();
					inversion = true;
				} else {
					// couleur quand on affecte pas
				}
				equilibreStable();
			}
		}
		while (inversion);
	}
}
