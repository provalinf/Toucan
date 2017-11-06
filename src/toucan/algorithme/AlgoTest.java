package toucan.algorithme;

import toucan.graphique.animation.AffectationCaseCase;
import toucan.graphique.animation.AffectationVarCase;
import toucan.modele.LesCases;

/**
 * Classe qui permet de choisir les algorithmes que l'on veut utiliser
 */
public class AlgoTest extends Algo {

	private AffectationCaseCase affectationCaseCase = new AffectationCaseCase();
	private AffectationVarCase affectationVarCase = new AffectationVarCase();

	public AlgoTest(LesCases lesCases) {
		super(lesCases);
	}

	public void trier() {
		System.out.println("Début calculs");
        //affectationCaseCase.executer(lesCases, 0, 1);
        equilibreStable();
		lesCases.getVariable(1).setVisible(false);
        //equilibreStable();
        //affectationVarCase.executer(lesCases, 0);
		new AlgoBulle(lesCases).trier();
		System.out.println("Début boucles");
		int j = 30;
		for (int i = 0; i < 1000000000; i++) {
			j = (i + j) * 10;
		}for (int i = 0; i < 1000000000; i++) {
			j = (i + j) * 10;
		}for (int i = 0; i < 1000000000; i++) {
			j = (i + j) * 10;
		}
		System.out.println("Fin boucles");

		//affectationCaseCase.executer(lesCases, 0, 1);

		System.out.println("Fin calculs");
		new AlgoSelection(lesCases).trier();
		//new AlgoInsert(lesCases).trier();
		/*affectationVarCase.executer(lesCases, 3);
		affectationVarCase.executer(lesCases, 1);*/
		/*affectationVarCase.executer(lesCases, 0);
		affectationVarCase.executer(lesCases, 2);*/
		//affectationCaseCase.executer(lesCases, 2, 3);
		//affectationCaseCase.executer(lesCases, 0, 3) ;
	}
}
