package toucan.arbre;

import java.util.ArrayList;

/**
 * Created by Cyril on 24/11/2017.
 */
public class BlocDinstruction extends ArbreAbstrait {
	private ArrayList<ArbreAbstrait> bloc;

	public BlocDinstruction() {
		bloc = new ArrayList<>();
	}

	public BlocDinstruction ajouter(ArbreAbstrait a) {
		bloc.add(a);
		return this;
	}

	public String getCodeDecore() {
		StringBuilder res = new StringBuilder();
		for (ArbreAbstrait a : bloc) {
			res.append(a.getCodeDecore()).append("\n");
		}
		return res.toString();
	}
}
