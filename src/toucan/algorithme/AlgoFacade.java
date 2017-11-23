package toucan.algorithme;

import toucan.modele.LesCases;
import toucan.modele.Modele;
import toucan.outils.KitJava;

/**
 * Classe qui utilise l'algorithme Facade
 */

public class AlgoFacade extends Algo {
	Modele m;

	public AlgoFacade(Modele m, LesCases lesCases) {
		super(lesCases, "Algo Personnel");
		this.m = m;
	}

	@Override
	public void trier() {
		KitJava kit = new KitJava();
		kit.construireClasse(m.getAlgoPersoText());
		kit.compiler();
		kit.executer();
		System.out.println(kit.getLaClasse());
	}
}
