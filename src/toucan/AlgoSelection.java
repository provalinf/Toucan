package toucan;

/**
 * Created by Cyril on 07/09/2017.
 */
public class AlgoSelection extends Algo {
    public AlgoSelection(LesCases lesCases) {
        super(lesCases);
    }

    @Override
    protected void trier() {
        int indice_max;
        int taille = lesCases.getNbCases();

        for(; taille > 1 ; taille--) // tant qu'il reste des éléments non triés
        {
            indice_max = max(lesCases, taille);
            swap(lesCases, taille-1, indice_max); // on échange le dernier élément avec le plus grand
        }
    }

    private void swap(LesCases lesCases, int c1, int c2){
        Case cTemp = lesCases.getCase(c1);
        lesCases.setCase(c1,lesCases.getCase(c2));
        lesCases.setCase(c2, cTemp);
    }

    private int max(LesCases tab, int taille)
    {
        int i=0, indice_max=0;
        while(i < taille)
        {
            if(lesCases.getCase(i).getValeur() > lesCases.getCase(indice_max).getValeur())
                indice_max = i;
            i++;
        }
        return indice_max;
    }
}
