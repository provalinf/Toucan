package toucan.arbre;

/**
 * Created by Cyril on 06/12/2017.
 */
public class CompareCaseCase extends Comparaison {
	public CompareCaseCase(String x, String y) {
		getCodeDecore(x, y);
	}

	@Override
	public void getCodeDecore(String... indices) {
		codeDecore = "ComparaisonCaseCase.executer(LesCases, "+indices[0]+", "+indices[1]+");\n";
	}

	@Override
	public String getCodeDecore() {
		return codeDecore;
	}
}
