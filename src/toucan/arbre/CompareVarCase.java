package toucan.arbre;

/**
 * Created by bonnal4u.
 */
public class CompareVarCase extends Comparaison {
	public CompareVarCase(int x) {
		getCodeDecore(x);
	}

	@Override
	public void getCodeDecore(int... indices) {
		codeDecore = "comparaisonVarCase.executer(LesCases, " + indices[0] + ");\n";
	}

	@Override
	public String getCodeDecore() {
		return codeDecore;
	}
}
