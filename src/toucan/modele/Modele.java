package toucan.modele;

import toucan.LesCases;


/**
 * Created by Cyril on 06/09/2017.
 */
public class Modele {

    private LesCases lesCases = new LesCases();

    public void creerLesMouvements(){
        lesCases.monter(0,5);
        lesCases.droite(0,10);
    }
}
