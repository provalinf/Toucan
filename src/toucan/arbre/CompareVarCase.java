package toucan.arbre;

/**
 * Created by bonnal4u.
 */
public class CompareVarCase extends Comparaison {
	public CompareVarCase(int x) {
		getCodeDecore(x);
	}

	@Override
	public String getCodeDecore(int... indices) {
		return "comparaisonVarCase.executer(LesCases, " + indices[0] + ");\n";
	}
}
