package toucan.algorithme;

import toucan.graphique.animation.AffectationCaseCase;
import toucan.graphique.animation.AffectationCaseVar;
import toucan.graphique.animation.AffectationVarCase;
import toucan.graphique.animation.ComparaisonCaseCase;
import toucan.modele.Case;
import toucan.modele.LesCases;
import toucan.modele.Modele;
import toucan.outils.KitJava;

import static toucan.modele.Modele.TAILLE_CASE;

/**
 * Classe qui utilise l'algorithme Facade
 */

public class AlgoFacade extends Algo {
    Modele m;
    public AlgoFacade(Modele m, LesCases lesCases) {
        super(lesCases, "AlgoFacade");
        this.m = m;
    }

    @Override
    public void trier() {
        KitJava kit = new KitJava();
        kit.construireClasse(m.getAlgoPersoText());
        System.out.println(kit.getLaClasse());
    }
}
