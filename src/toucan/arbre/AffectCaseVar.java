package toucan.arbre;

/**
 * Created by bonnal4u.
 */
public class AffectCaseVar extends Affectation {
	public AffectCaseVar(int x) {
		getCodeDecore(x);
	}

	@Override
	public String getCodeDecore(int... indices) {
		return "affectationCaseVar.executer(LesCases, " + indices[0] + ");\nvar = tab[" + indices[0] + "]\n";
	}
}
