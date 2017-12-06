package toucan.arbre;

/**
 * Created by Cyril on 06/12/2017.
 */
public class AffectCaseCase extends ArbreAbstrait {
    private int x, y;
    public AffectCaseCase(int x, int y) {
        getCodeDecore();
        this.x = x;
        this.y = y;
    }

    @Override
    public String getCodeDecore() {
        return "affectationCaseCase.executer(LesCases, "+x+", "+y+");\ntab["+x+"] = "+"tab["+y+"];\n";
    }
}
