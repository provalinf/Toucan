package toucan.arbre;

/**
 * Created by Cyril on 06/12/2017.
 */
public class AffectVarCase extends Affectation {

	public AffectVarCase(int x) {
		getCodeDecore(x);
	}

	@Override
	public void getCodeDecore(int... indices) {
		codeDecore = "affectationVarCase.executer(LesCases, " + indices[0] + ");\nvar = tab[" + indices[0] + "];";
	}

	@Override
	public String getCodeDecore() {
		return codeDecore;
	}
}
