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
        Case c2 = cases.getCase(cases.getNbCases()-1);

        int posC1[] = c1.getPosActuel();
        int posC2[] = c2.getPosActuel();

        for (int i = 0; i < cases.getNbCases(); i++) {
            if (i!=indices[0] && i!=cases.getNbCases()-1){
                cases.getCase(i).stable(1000); // trouver le temps jusqu'au prochain mouvement
            }
        }
        c2.stable(posC2[1]-TAILLE_CASE-8+posC1[0]-posC2[0]-2*TAILLE_CASE); // somme de tout les temps que c1 travaille
        c1.descendre(posC2[1]-TAILLE_CASE-8); //rustine de 8 (a voir pourquoi)
        c1.gauche(posC1[0]-posC2[0]-2*TAILLE_CASE);

        c1.monter(TAILLE_CASE);
        c2.monter(TAILLE_CASE);
        c2.stable(TAILLE_CASE*2);
        c1.gauche(TAILLE_CASE);

        c1.droite(TAILLE_CASE);
        c2.descendre(TAILLE_CASE);
        c1.descendre(TAILLE_CASE);


        c1.droite(posC1[0]-posC2[0]-2*TAILLE_CASE);
        c1.monter(posC2[1]-TAILLE_CASE-8); //rustine de 8 (a voir pourquoi)

    }
}
