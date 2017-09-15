package toucan.algorithme;

import toucan.Case;
import toucan.LesCases;

public class AlgoBulle extends Algo{

    public AlgoBulle(LesCases lesCases) {
        super(lesCases);
    }

    @Override
	public void trier() {
        int longueur=lesCases.getNbCases();
        boolean inversion;
        do {
            inversion=false;
            for(int i=0;i<longueur-1;i++) {
                if(lesCases.getCase(i).getValeur()>lesCases.getCase(i+1).getValeur()) {
                    swap(lesCases,i,i+1);
                    inversion=true;
                }
            }
        }
        while(inversion);
    }

    private void swap(LesCases lesCases, int c1, int c2){
        Case cTemp = lesCases.getCase(c1);
        lesCases.setCase(c1,lesCases.getCase(c2));
        lesCases.setCase(c2, cTemp);
    }
}
