package toucan.analyse;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class TestAnalyse {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("TestAnalyse : nombre incorrect d'arguments");
			System.err.println("usage : java analyse.TestAnalyse nomDeFichier");
			System.exit(-1);
		}

		try {
			AnalyseurSyntaxique analyseur = new AnalyseurSyntaxique(new AnalyseurLexical(new FileReader(args[0])));
			analyseur.parse();
		} catch (FileNotFoundException e) {
			System.out.println("Fichier non trouve");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}