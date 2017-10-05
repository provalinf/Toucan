package toucan.algorithme;

/**
 * Created by Cyril on 05/10/2017.
 */
public class AlgoTest {

    AffectationCaseCase affectationCaseCase = new AffectationCaseCase();


    public void trier() {
        affectationCaseCase.executer(lesCases, 0, 1) ;
        affectationCaseCase.executer(lesCases, 2, 6) ;
        affectationCaseCase.executer(lesCases, 7, 3) ;
    }
}
