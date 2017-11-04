package toucan.algorithme;

import toucan.modele.Case;
import toucan.modele.LesCases;

import static toucan.modele.Modele.TAILLE_CASE;

public class AlgoInsert extends Algo {
	public AlgoInsert(LesCases lesCases) {
		super(lesCases);
	}

	public void trier() {
		for (int i = 1; i < lesCases.getNbCases(); i++) {
			Case c1 = lesCases.getCase(i);
			int[] posC1 = c1.getPosActuel();

			c1.descendre(TAILLE_CASE * 2);

			Case c2, c3;

			int j = i;
			boolean verif = true;
			while (j > 0 && verif) {
				c2 = lesCases.getCase(j - 1);
				int[] posC2 = c2.getPosActuel();
				c3 = lesCases.getCase(j);
				int[] posC3 = c3.getPosActuel();

				c2.descendre(TAILLE_CASE * 2);
				if (c2.getValeurActuel() > c1.getValeurActuel()) {
					int diff = (posC1[0] - posC2[0]) / 2;
					c1.gauche(diff);
					c2.droite(diff);
					//c1.setValeur(c2.getValeurActuel());
					//c2.setValeur(valC1);
					c1.droite(diff);
					c2.monter(TAILLE_CASE * 2);
					c1.gauche(diff * 2);
					c2.droite(diff);
				} else {
					int diff = (posC1[0] - posC2[0]) / 2 - TAILLE_CASE / 5;

					c1.gauche(diff);
					c2.droite(diff);

					c1.droite(diff);
					c2.gauche(diff);
					c1.monter(TAILLE_CASE * 2);

					verif = false;
				}
				c2.monter(TAILLE_CASE * 2);

				lesCases.setCase(j, c2);
				j = j - 1;

			}
			lesCases.setCase(j, c1);
			c1.monter(TAILLE_CASE * 2);
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