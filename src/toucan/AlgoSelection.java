package toucan;

/**
 * Created by Cyril on 07/09/2017.
 */
public class AlgoSelection extends Algo {
    public AlgoSelection(LesCases lesCases) {
        super(lesCases);
    }

    @Override
    public void trier() {
        for (int i = 1; i < lesCases.getNbCases(); i++) {
            Case min = lesCases.getCase(i);
            int mini = i;
            for (int j = i+1; j < lesCases.getNbCases(); j++) {
                if(lesCases.getCase(j).getValeur()<lesCases.getCase(mini).getValeur()){
                    lesCases.setCase(i, lesCases.getCase(j));
                }
            }
            if(lesCases.getCase(i).getValeur()!=min.getValeur()){
                Case temp = lesCases.getCase(i);
                lesCases.setCase(i, lesCases.getCase(mini));
                lesCases.setCase(mini, temp);
            }
        }
    }
}
