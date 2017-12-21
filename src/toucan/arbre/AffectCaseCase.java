package toucan.arbre;

/**
 * Created by Cyril on 06/12/2017.
 */
public class AffectCaseCase extends Affectation {

	public AffectCaseCase(String x, String y) {
		getCodeDecore(x, y);
	}

	@Override
	public void getCodeDecore(String... indices) {
		codeDecore = "affectationCaseCase.executer(LesCases, " + indices[0] + ", " + indices[1] + ");\ntab[" + indices[0] + "] = " + "tab[" + indices[1] + "];\n";
	}

	@Override
	public String getCodeDecore() {
		return codeDecore;
	}
}
