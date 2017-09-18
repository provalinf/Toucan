package toucan.algorithme;

import toucan.Case;
import toucan.LesCases;

/**
 * Created by Cyril on 07/09/2017.
 */
public class AlgoSelection extends Algo {
    public AlgoSelection(LesCases lesCases) {
        super(lesCases);
    }

    @Override
    public void trier() {
        for (int i = 0; i < lesCases.getNbCases() - 1; i++) {
            int mini = i;
            for (int j = i + 1; j < lesCases.getNbCases(); j++) {
                if (lesCases.getCase(j).getValeur() < lesCases.getCase(mini).getValeur()) {
                    mini = j;
                }
            }
            Case temp = lesCases.getCase(mini);
            lesCases.setCase(mini, lesCases.getCase(i));
            lesCases.setCase(i, temp);
        }
    }
}
