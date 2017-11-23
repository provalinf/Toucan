package toucan.graphique.animation;

import toucan.modele.Case;
import toucan.modele.LesCases;

import java.awt.*;

import static toucan.modele.Modele.DEFAULT_COLOR_CASE;
import static toucan.modele.Modele.TAILLE_CASE;

/**
 * Classe qui permet d'animer une comparaison de cases
 */
public class ComparaisonCaseCase implements IAnimation {
	@Override
	public void executer(LesCases cases, int... indices) {
		if (indices.length != 2) throw new AssertionError("Attention uniquement 2 indices");
		Case c1 = cases.getCase(indices[0]);
		Case v1 = cases.getCase(indices[1]);

		/*int posC1[] = c1.getPosActuel();
		int posv1[] = v1.getPosActuel();
		int sumTemps = 0;

		int tempsC1init = c1.getMaxTemps();
		int tempsv1init = v1.getMaxTemps();*/

		c1.setColor(Color.BLUE);
		v1.setColor(Color.BLUE);
		c1.descendre(TAILLE_CASE);
		v1.descendre(TAILLE_CASE);
		c1.stable(80);
		v1.stable(80);
		c1.monter(TAILLE_CASE);
		v1.monter(TAILLE_CASE);
		c1.setColor(DEFAULT_COLOR_CASE);
		v1.setColor(DEFAULT_COLOR_CASE);
/*
		int tempsC1initactuel = c1.getMaxTemps() - tempsC1init;
		int tempsv1initactuel = v1.getMaxTemps() - tempsv1init;

		if (tempsC1initactuel < tempsv1initactuel) {
			sumTemps = tempsv1initactuel;
		} else {
			sumTemps = tempsC1initactuel;
		}

		for (int i = 0; i < cases.getNbCases(); i++) {
			if (i != cases.getNbCases() - 1 && i != indices[0]) {
				cases.getCase(i).stable(sumTemps);
			}
		}*/

	}
}
