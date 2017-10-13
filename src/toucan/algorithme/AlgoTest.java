package toucan.algorithme;

import toucan.graphique.animation.AffectationCaseCase;
import toucan.graphique.animation.AffectationVarCase;
import toucan.modele.LesCases;

/**
 * Created by Cyril on 05/10/2017.
 */
public class AlgoTest extends Algo {

	private AffectationCaseCase affectationCaseCase = new AffectationCaseCase();
	private AffectationVarCase affectationVarCase = new AffectationVarCase();

	public AlgoTest(LesCases lesCases) {
		super(lesCases);
	}

	public void trier() {
		//affectationCaseCase.executer(lesCases, 0, 1);
		new AlgoBulle(lesCases).trier();
		/*affectationVarCase.executer(lesCases, 3);
		affectationVarCase.executer(lesCases, 1);*/
		/*affectationVarCase.executer(lesCases, 0);
		affectationVarCase.executer(lesCases, 2);*/
		//affectationCaseCase.executer(lesCases, 2, 3) ;
		//affectationCaseCase.executer(lesCases, 0, 3) ;
	}
}
