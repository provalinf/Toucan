package toucan.arbre;

/**
 * Created by Cyril on 06/12/2017.
 */
public class AffectVarCase extends Affectation {

	public AffectVarCase(String x) {
		getCodeDecore(x);
	}

	@Override
	public void getCodeDecore(String... indices) {
		codeDecore = "affectationVarCase.executer(lesCases, " + indices[0] + ");\n";
	}

	@Override
	public String getCodeDecore() {
		return codeDecore;
	}
}
