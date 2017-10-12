package toucan.graphique.animation;

import static toucan.modele.Modele.TAILLE_CASE;
import toucan.modele.Case;
import toucan.modele.LesCases;

/**
 * Created by Cyril on 05/10/2017.
 */
public class AffectationVarCase implements IAnimation {
    @Override
    public void executer(LesCases cases, int... indices) {
        if (indices.length != 1) throw new AssertionError("Attention uniquement 1 indice");
        Case c1 = cases.getCase(indices[0]);
        Case v2 = cases.getCase(cases.getNbCases()-1);

        int posC1[] = c1.getPosActuel();
        int posV2[] = v2.getPosActuel();
        int sumTemps = 0;

        int tempsC1init = c1.getMaxTemps();
        int tempsV2init = v2.getMaxTemps();

       /* for (int i = 0; i < cases.getNbCases(); i++) {
          sumTemps = sumTemps + cases.getCase(i).getMaxTemps();
        }*/

/*
        for (int i = 0; i < cases.getNbCases(); i++) {
            if (i!=indices[0] && i!=cases.getNbCases()-1){
                cases.getCase(i).stable(1000); // trouver le temps jusqu'au prochain mouvement
            }
        }*/

        v2.stable(posV2[1]-TAILLE_CASE+posC1[0]-posV2[0]-2*TAILLE_CASE); // somme de tout les temps que c1 travaille
        c1.descendre(posV2[1]-TAILLE_CASE); //rustine de 8 (a voir pourquoi)
        System.out.println(c1.getPosActuel()[1]);
        System.out.println(v2.getPosActuel()[1]);


        c1.gauche(posC1[0]-posV2[0]-2*TAILLE_CASE);

        c1.monter(TAILLE_CASE);
        v2.monter(TAILLE_CASE);
        v2.stable(TAILLE_CASE*2);
        c1.gauche(TAILLE_CASE);

        c1.droite(TAILLE_CASE);
        v2.descendre(TAILLE_CASE);
        c1.descendre(TAILLE_CASE);

        v2.stable(posC1[0]-posV2[0]-2*TAILLE_CASE+posV2[1]-TAILLE_CASE);

        c1.droite(posC1[0]-posV2[0]-2*TAILLE_CASE);
        c1.monter(posV2[1]-TAILLE_CASE); //rustine de 8 (a voir pourquoi)

        int tempsC1initactuel = c1.getMaxTemps()-tempsC1init;
        int tempsV2initactuel = v2.getMaxTemps()-tempsV2init;

        if(tempsC1initactuel < tempsV2initactuel){
            sumTemps = tempsV2initactuel;
        }else{
            sumTemps = tempsC1initactuel;
        }

        System.out.println("Le temps est : "+sumTemps);

        for (int i = 0; i < cases.getNbCases(); i++) {
            if(i != cases.getNbCases()-1 && i!= indices[0]){
                cases.getCase(i).stable(sumTemps);
            }
        }
    }
}
