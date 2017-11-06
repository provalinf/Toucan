package toucan.graphique.animation;

import toucan.modele.Case;
import toucan.modele.LesCases;

import static toucan.modele.Modele.TAILLE_CASE;

/**
 * Classe qui permet d'animer une affectation case à case
 */
public class AffectationCaseCase implements IAnimation {

	private int tempsC1init;
	private int tempsC2init;

	@Override
	public void executer(LesCases cases, int... indices) {
		if (indices.length != 2) throw new AssertionError("Attention uniquement deux indices");

		Case c1 = cases.getCase(indices[0]);
		Case c2 = cases.getCase(indices[1]);
		int[] c1Pos = c1.getPosActuel();
		int[] c2Pos = c2.getPosActuel();
		int sumTemps = 0;

		tempsC1init = c1.getMaxTemps();
		tempsC2init = c2.getMaxTemps();
		int tempsC1initactuel = c1.getMaxTemps() - tempsC1init;
		int tempsC2initactuel = c2.getMaxTemps() - tempsC2init;

		if (tempsC1initactuel < tempsC2initactuel) {
			sumTemps = tempsC2initactuel;
		} else {
			sumTemps = tempsC1initactuel;
		}

		System.out.println("Le temps est : " + sumTemps);

		c2.monter(TAILLE_CASE);
		if (c2Pos[0] < c1Pos[0]) {    // C2 à gauche de C1
			c2.droite(c1Pos[0] - c2Pos[0]);
			upDown(c1, c2);
			c2.gauche(c1Pos[0] - c2Pos[0]);
		} else {
			c2.gauche(c2Pos[0] - c1Pos[0]);
			upDown(c1, c2);
			c2.droite(c2Pos[0] - c1Pos[0]);
		}
		c2.descendre(TAILLE_CASE);


		System.out.println("Le temps est : " + sumTemps);
		int maxtemps = cases.getMaxTemps();
		for (int i = 0; i < cases.getNbCases(); i++) {
			Case cTmp = cases.getCase(i);
			if (cTmp.getMaxTemps() != maxtemps) {
				cTmp.stable(maxtemps - cTmp.getMaxTemps());
			}
		}

		System.out.println("↡ -- STOP --- STOP -- ↡");
		for (int i = 0; i < cases.getNbCases(); i++) {
			System.out.println("\tcase " + i + " : " + cases.getCase(i).getMaxTemps());
		}
		System.out.println("↟ -- STOP --- STOP -- ↟");
	}

	private void upDown(Case c1, Case c2) {
		c2.descendre(TAILLE_CASE - TAILLE_CASE / 5);

		int tempsC1initactuel = c1.getMaxTemps() - tempsC1init;
		int tempsC2initactuel = c2.getMaxTemps() - tempsC2init;

		if (tempsC1initactuel < tempsC2initactuel) {
			c1.stable(tempsC2initactuel);
			tempsC1init = c1.getMaxTemps();
		} else {
			c1.stable(tempsC1initactuel);
			tempsC1init = c1.getMaxTemps();
		}
		c1.setValeur(c2.getValeurActuel());
		c2.monter(TAILLE_CASE - TAILLE_CASE / 5);
	}


}
