package toucan.arbre;

/**
 * Created by bonnal4u.
 */
public class AffectExpressionCase extends Affectation {
	private ExpressionT variable;
	private String indice;

	public AffectExpressionCase(ExpressionT variable, String indice) {
		this.indice = indice;
		this.variable = variable;
	}

	@Override
	public String getCodeDecore() {
		return variable.getCodeDecore()+"=tab["+indice+"];\n";
	}
}
