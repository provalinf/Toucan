package toucan;

/**
 * Created by Cyril on 05/09/2017.
 */
public class Case {
    private int valeur;
    private LesMouvements pos;
    public Case(int xInit, int yInit, int val) {
        valeur = val;
        pos = new LesMouvements(xInit, yInit);
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public void monter(int d){
        pos.monter(d);
    }
}
