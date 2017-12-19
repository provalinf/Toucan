package toucan.arbre;

import java.beans.Expression;

/**
 * Created by bonnal4u.
 */
public class AffectCaseExpression extends Affectation {
	private ExpressionT variable;
	private int indice;

	public AffectCaseExpression(int indice, ExpressionT variable) {
		this.indice = indice;
		this.variable = variable;
	}

	@Override
	public String getCodeDecore() {
		return "tab["+indice+"]="+variable.getCodeDecore()+";\n";
	}
}
