package toucan.arbre;

/**
 * Created by Cyril on 14/12/2017.
 */
public class ExpressionT extends ArbreAbstrait {
    private String expression;

    public ExpressionT(String expression) {
        this.expression = expression;
    }

    public String getCodeDecore(){
        return expression;
    }
}
