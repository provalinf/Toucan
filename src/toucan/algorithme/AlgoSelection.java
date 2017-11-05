package toucan.algorithme;

import toucan.graphique.animation.AffectationCaseCase;
import toucan.graphique.animation.AffectationCaseVar;
import toucan.graphique.animation.AffectationVarCase;
import toucan.modele.LesCases;

public class AlgoSelection extends Algo {
	public AlgoSelection(LesCases lesCases) {
		super(lesCases);
	}

	@Override
	public void trier() {
		for (int i = 0; i < lesCases.getNbCases() - 1; i++) {
			int mini = i;
			for (int j = i + 1; j < lesCases.getNbCases(); j++) {
				if (lesCases.getCase(j).getValeurActuel() < lesCases.getCase(mini).getValeurActuel()) {
					mini = j;
				}
			}
			if(mini!=i) {
				AffectationVarCase v1 = new AffectationVarCase();
				AffectationCaseCase c1 = new AffectationCaseCase();
				AffectationCaseVar c2 = new AffectationCaseVar();

				v1.executer(lesCases, mini);
				equilibreStable();
				c1.executer(lesCases, mini, i);
				equilibreStable();
				c2.executer(lesCases, i); // modifier
				equilibreStable();
				/*Case temp = lesCases.getCase(mini);
				Case casei = lesCases.getCase(i);
				int valTemp = casei.getValeurActuel();
				int[] posCMini = temp.getPosActuel();
				int[] posCi = casei.getPosActuel();
				temp.descendre(TAILLE_CASE * 2);
				casei.descendre(TAILLE_CASE * 2);
				if (posCi[0] < posCMini[0]) {
					temp.gauche((posCMini[0] - posCi[0])/2);
					casei.droite((posCMini[0] - posCi[0])/2);
					temp.setValeur(casei.getValeurActuel());
					casei.setValeur(valTemp);
					temp.gauche((posCMini[0] - posCi[0])/2);
					casei.droite((posCMini[0] - posCi[0])/2);
				} else {
					temp.droite(posCi[0] - posCMini[0]);
					casei.gauche(posCi[0] - posCMini[0]);
					temp.setValeur(casei.getValeurActuel());
					casei.setValeur(valTemp);
					temp.droite(posCi[0] - posCMini[0]);
					casei.gauche(posCi[0] - posCMini[0]);
				}

				temp.monter(TAILLE_CASE * 2);
				casei.monter(TAILLE_CASE * 2);*/

			}
		}
	}
}
