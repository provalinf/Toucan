package toucan.graphique.animation;

import toucan.modele.Case;
import toucan.modele.LesCases;

import static toucan.modele.Modele.TAILLE_CASE;

/**
 * Created by bonnal4u.
 */
public class AffectationCaseCase implements IAnimation {


	@Override
	public void executer(LesCases cases, int... indices) {
        if (indices.length != 2) throw new AssertionError("Attention uniquement deux indices");

        Case c1 = cases.getCase(indices[0]);
        Case c2 = cases.getCase(indices[1]);
        int[] c1Pos = c1.getPosActuel();
        int[] c2Pos = c2.getPosActuel();

        for (int i = 0; i < cases.getNbCases(); i++) {
            if(i != indices[0] && i !=indices[1]){
                System.out.println(cases.getMaxTemps());
                cases.getCase(i).stable(10); /// mieux régler le temps
            }
        }
        c2.monter(TAILLE_CASE);
        if (c2Pos[0] < c1Pos[0]) {    // C2 à gauche de C1
            c2.droite(c1Pos[0] - c2Pos[0]);
            upDown(c1,c2);
            c2.gauche(c1Pos[0] - c2Pos[0]);
        } else {
            c2.gauche(c2Pos[0] - c1Pos[0]);
            upDown(c1,c2);
            c2.droite(c2Pos[0] - c1Pos[0]);
        }
        c2.descendre(TAILLE_CASE);
    }

		private void upDown(Case c1,Case c2){
        c2.descendre(TAILLE_CASE-10);
        c1.stable(0, c2.getValeurActuel());
        c2.monter(TAILLE_CASE-10);
    }


}
