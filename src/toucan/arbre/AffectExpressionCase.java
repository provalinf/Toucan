package toucan.arbre;

/**
 * Created by bonnal4u.
 */
public class AffectExpressionCase extends Affectation {
	private ExpressionT variable;
	private int indice;

	public AffectExpressionCase(ExpressionT variable, int indice) {
		this.indice = indice;
		this.variable = variable;
	}

	@Override
	public String getCodeDecore() {
		return variable.getCodeDecore()+"=tab["+indice+"];\n";
	}
}
