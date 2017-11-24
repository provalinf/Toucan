package toucan.algorithme;

import toucan.modele.LesCases;
import toucan.modele.Modele;
import toucan.outils.KitJava;

/**
 * Classe qui utilise l'algorithme Facade
 */

public class AlgoFacade extends Algo {
	private Modele modele;

	public AlgoFacade(Modele modele, LesCases lesCases) {
		super(lesCases, "Tri Personnel");
		this.modele = modele;
	}

	@Override
	public void trier() {
		KitJava kit = new KitJava();
		kit.construireClasse(modele.getAlgoPersoText());
		kit.compiler();
		kit.executer(lesCases);
		System.out.println(kit.getLaClasse());
	}
}
