package toucan;

/**
 * Created by Cyril on 05/09/2017.
 */
public class Mouvement {
    protected int xDep;
    protected int yDep;
    protected int xInit;
    protected int yInit;

    public Mouvement(int xDep, int yDep, int xInit, int yInit) {
        this.xDep = xDep;
        this.yDep = yDep;
        this.xInit = xInit;
        this.yInit = yInit;
    }

    @Override
    public String toString() {
        return "Mouvement{}";
    }
}
