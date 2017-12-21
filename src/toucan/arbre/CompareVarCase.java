package toucan.arbre;

/**
 * Created by bonnal4u.
 */
public class CompareVarCase extends Comparaison {
	public CompareVarCase(String x) {
		getCodeDecore(x);
	}

	@Override
	public void getCodeDecore(String... indices) {
		codeDecore = "comparaisonVarCase.executer(LesCases, " + indices[0] + ");\n";
	}

	@Override
	public String getCodeDecore() {
		return codeDecore;
	}
}
