package toucan.arbre;

/**
 * Created by bonnal4u.
 */
public class AffectCaseVar extends Affectation {
	public AffectCaseVar(String x) {
		getCodeDecore(x);
	}

	@Override
	public void getCodeDecore(String... indices) {
		codeDecore = "affectationCaseVar.executer(lesCases, " + indices[0] + ");\n";
	}

	@Override
	public String getCodeDecore() {
		return codeDecore;
	}
}
