package toucan.arbre;

/**
 * Created by Cyril on 06/12/2017.
 */
public class CompareCaseCase extends Comparaison {
	public CompareCaseCase(int x, int y) {
		getCodeDecore(x, y);
	}

	@Override
	public void getCodeDecore(int... indices) {
		codeDecore = "ComparaisonCaseCase.executer(LesCases, "+indices[0]+", "+indices[1]+");\n";
	}

	@Override
	public String getCodeDecore() {
		return codeDecore;
	}
}
