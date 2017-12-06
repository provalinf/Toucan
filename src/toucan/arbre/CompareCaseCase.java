package toucan.arbre;

/**
 * Created by Cyril on 06/12/2017.
 */
public class CompareCaseCase extends Comparaison {
    int x, y;
    public CompareCaseCase(int x, int y) {
        this.x = x;
        this.y = y;
        getCodeDecore(x, y);
    }

    @Override
    public String getCodeDecore(int... indices) {
        return "ComparaisonCaseCase.executer(LesCases, "+x+", "+y+");\n";
    }
}
