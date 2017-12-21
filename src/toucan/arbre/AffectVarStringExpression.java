package toucan.arbre;

/**
 * Created by bonnal4u.
 */
public class AffectVarStringExpression extends Instruction {
	private String variable;
	private String idf;

	public AffectVarStringExpression(String idf, String variable) {
		this.idf = idf;
		this.variable = variable;
	}

	@Override
	public String getCodeDecore() {
		return idf+"=tab["+variable+"];\n";
	}
}
