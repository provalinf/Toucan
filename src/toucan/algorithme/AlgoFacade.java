package toucan.algorithme;

import toucan.analyse.AnalyseurLexical;
import toucan.analyse.AnalyseurSyntaxique;
import toucan.arbre.ArbreAbstrait;
import toucan.modele.LesCases;
import toucan.modele.Modele;
import toucan.outils.KitJava;

import java.io.StringReader;

/**
 * Classe qui utilise l'algorithme Facade
 */

public class AlgoFacade extends Algo {
	private Modele modele;

	public AlgoFacade(Modele modele, LesCases lesCases) {
		super(lesCases, "Tri personnel");
		this.modele = modele;
		algoCustom = true;    // Donc EditorPan & DebugPan requis
	}

	@Override
	public void trier() throws Exception {
		KitJava kit = KitJava.getInstance();

		ArbreAbstrait algoUtil = null;
		AnalyseurSyntaxique analyseur = new AnalyseurSyntaxique(new AnalyseurLexical(new StringReader(modele.getAlgoPersoText())));
		//analyseur.parse();
		//System.out.println(((ArbreAbstrait) analyseur.parse().value).getCodeDecore());
		algoUtil = (ArbreAbstrait) analyseur.parse().value;


		kit.construireClasse(algoUtil.getCodeDecore());
		kit.compiler();
		kit.executer(lesCases);
		//System.out.println(kit.getLaClasse());

	}
}
