package toucan.algorithme;

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
				int[] posC1 = c1.getPosActuel();
				int[] posC2 = c2.getPosActuel();

				c1.descendre(TAILLE_CASE * 2);
				c2.descendre(TAILLE_CASE * 2);

				if (c1.getValeurActuel() > c2.getValeurActuel()) {
					int diff = (posC2[0] - posC1[0]) / 2;
					int repl = (posC2[0] - posC1[0]) / 2;
					int valC1 = c1.getValeurActuel();
					c1.droite(diff);
					c2.gauche(diff);
					c1.setValeur(c2.getValeurActuel());
					c2.setValeur(valC1);
					c1.gauche(diff);
					c2.droite(diff);
					inversion = true;
				} else {
					int diff = (posC2[0] - posC1[0]) / 2 - TAILLE_CASE / 5;

					c1.droite(diff);
					c2.gauche(diff);

					c1.gauche(diff);
					c2.droite(diff);

				}

				c1.monter(TAILLE_CASE * 2);
				c2.monter(TAILLE_CASE * 2);

				equilibreStable();
			}
		}
		while (inversion);
	}
}
