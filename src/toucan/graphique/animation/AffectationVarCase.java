package toucan.graphique.animation;

import toucan.modele.Case;
import toucan.modele.LesCases;

import java.awt.*;

import static toucan.modele.Modele.DEFAULT_COLOR_CASE;
import static toucan.modele.Modele.TAILLE_CASE;

/**
 * Classe qui permet d'animer une affectation Variable à Case
 */
public class AffectationVarCase implements IAnimation {
	@Override
	public void executer(LesCases cases, int... indices) {
		if (indices.length != 1) throw new AssertionError("Attention uniquement 1 indice");
		Case c1 = cases.getCase(indices[0]);
		Case v1 = cases.getVariable(0);
		c1.setColor(new Color(172, 101, 11));
		v1.setColor(new Color(172, 101, 11));

		int posC1[] = c1.getPosActuel();
		int posv1[] = v1.getPosActuel();
		int sumTemps = 0;

		int tempsC1init = c1.getMaxTemps();
		int tempsv1init = v1.getMaxTemps();

       /* for (int i = 0; i < cases.getNbCases(); i++) {
		  sumTemps = sumTemps + cases.getCase(i).getMaxTemps();
        }*/

/*
		for (int i = 0; i < cases.getNbCases(); i++) {
            if (i!=indices[0] && i!=cases.getNbCases()-1){
                cases.getCase(i).stable(1000); // trouver le temps jusqu'au prochain mouvement
            }
        }*/

		v1.stable(posv1[1] - posC1[1] + posC1[0] - posv1[0] - 2 * TAILLE_CASE); // somme de tout les temps que c1 travaille
		c1.descendre(posv1[1] - posC1[1]);
		if(posC1[0] - posv1[0] > 2 * TAILLE_CASE) {
			c1.gauche(posC1[0] - posv1[0] - 2 * TAILLE_CASE);
		}

		c1.monter(TAILLE_CASE);
		v1.monter(TAILLE_CASE);
		v1.stable(TAILLE_CASE + TAILLE_CASE / 5);
		v1.setValeur(c1.getValeurActuel());
		v1.stable(TAILLE_CASE);

		c1.gauche(TAILLE_CASE + TAILLE_CASE / 5);
		c1.droite(TAILLE_CASE + TAILLE_CASE / 5);

		v1.descendre(TAILLE_CASE);
		c1.descendre(TAILLE_CASE);

		v1.stable(posC1[0] - posv1[0] - 2 * TAILLE_CASE + posv1[1] - TAILLE_CASE);
		v1.stable(TAILLE_CASE / 5);

		if(posC1[0] - posv1[0] > 2 * TAILLE_CASE){
			c1.droite(posC1[0] - posv1[0] - 2 * TAILLE_CASE);
		}

		c1.monter(posv1[1] - posC1[1]);

		int maxtemps = cases.getMaxTemps();
		for (int i = 0; i < cases.getNbCases() + cases.getNbVariables(); i++) {
			Case cTmp = cases.getCase(i);
			if (cTmp.getMaxTemps() != maxtemps) {
				cTmp.stable(maxtemps - cTmp.getMaxTemps());
			}
		}

		c1.setColor(DEFAULT_COLOR_CASE);
		v1.setColor(DEFAULT_COLOR_CASE);
	}
}
