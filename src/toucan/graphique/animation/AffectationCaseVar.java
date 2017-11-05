package toucan.graphique.animation;

import toucan.modele.Case;
import toucan.modele.LesCases;

import static toucan.modele.Modele.TAILLE_CASE;


public class AffectationCaseVar implements IAnimation {
    @Override
    public void executer(LesCases cases, int... indices) {
        if (indices.length != 1) throw new AssertionError("Attention uniquement 1 indice");
        Case c1 = cases.getCase(indices[0]);
        Case v1 = cases.getCase(cases.getNbCases()+cases.getNbVariables()-2);

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

        c1.stable(posC1[0]-posv1[0]+posv1[1]-posC1[1]);
        v1.droite(posC1[0]-posv1[0]);
        v1.monter(posv1[1]-posC1[1]);
        c1.setValeur(v1.getValeurActuel());
        v1.descendre(posv1[1]-posC1[1]);
        v1.gauche(posC1[0]-posv1[0]);
		/*v1.stable(posv1[1] - posC1[1] + posC1[0] - posv1[0] - 2 * TAILLE_CASE); // somme de tout les temps que c1 travaille
		c1.descendre(posv1[1] - posC1[1]);
		c1.gauche(posC1[0] - posv1[0] - 2 * TAILLE_CASE);

		c1.monter(TAILLE_CASE);
		v1.monter(TAILLE_CASE);
        v1.stable(TAILLE_CASE+TAILLE_CASE/5);
		v1.setValeur(c1.getValeurActuel());
		v1.stable(TAILLE_CASE);
        c1.gauche(TAILLE_CASE+TAILLE_CASE/5);

        c1.droite(TAILLE_CASE+TAILLE_CASE/5);
        v1.descendre(TAILLE_CASE);
		c1.descendre(TAILLE_CASE);

		v1.stable(posC1[0] - posv1[0] - 2 * TAILLE_CASE + posv1[1] - TAILLE_CASE);
		v1.stable(TAILLE_CASE/5);

		c1.droite(posC1[0] - posv1[0] - 2 * TAILLE_CASE);
		c1.monter(posv1[1] - posC1[1]);*/

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
        }
    }
}
