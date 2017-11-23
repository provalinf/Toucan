package toucan.graphique.animation;

import toucan.modele.Case;
import toucan.modele.LesCases;

import java.awt.*;

import static toucan.modele.Modele.DEFAULT_COLOR_CASE;
import static toucan.modele.Modele.TAILLE_CASE;

/**
 * Classe qui permet d'animer une comparaison entre variable et case
 */
public class ComparaisonVarCase implements IAnimation {
	@Override
	public void executer(LesCases cases, int... indices) {
		if (indices.length != 1) throw new AssertionError("Attention uniquement 1 indice");
		Case c1 = cases.getCase(indices[0]);
		Case v1 = cases.getVariable(0);

		int posC1[] = c1.getPosActuel();
		int posv1[] = v1.getPosActuel();
		int sumTemps = 0;

		int tempsC1init = c1.getMaxTemps();
		int tempsv1init = v1.getMaxTemps();


/*		c1.setColor(Color.BLUE);
		v1.setColor(Color.BLUE);
		v1.stable(2*(posv1[1]-posC1[1])+2*(posC1[0]-posv1[0])-2*(TAILLE_CASE)+80);
		c1.descendre(posv1[1]-posC1[1]);
		c1.gauche(posC1[0]-posv1[0]-TAILLE_CASE);
		c1.stable(80);
		c1.droite(posC1[0]-posv1[0]-TAILLE_CASE);
		c1.monter(posv1[1]-posC1[1]);
		c1.setColor(DEFAULT_COLOR_CASE);
		v1.setColor(DEFAULT_COLOR_CASE);*/

		c1.setColor(Color.BLUE);
		v1.setColor(Color.BLUE);
		c1.descendre(TAILLE_CASE);
		v1.droite(TAILLE_CASE);
		v1.stable(80);
		c1.stable(80);
		c1.monter(TAILLE_CASE);
		v1.gauche(TAILLE_CASE);
		c1.setColor(DEFAULT_COLOR_CASE);
		v1.setColor(DEFAULT_COLOR_CASE);
	}
}
