package toucan.outils;

import toucan.algorithme.Algo;
import toucan.modele.LesCases;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.ToolProvider;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Cyril on 08/11/2017.
 */
public class KitJava {
	private  static KitJava instance = new KitJava();
	private JavaCompiler compiler;
	private ClassFileManager fileManager;
	private static String nomClasse = "AlgoPerso";
	private static String nomPackage = "toucan.algorithme";

	private KitJava() {
		compiler = ToolProvider.getSystemJavaCompiler();
		fileManager = new ClassFileManager(compiler.getStandardFileManager(null, null, null));
	}

	private String laClasse;

	public static KitJava getInstance() {
		return instance;
	}

	public void construireClasse(String code) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("package toucan.algorithme;\n" +
				"import toucan.graphique.animation.*;\n" +
				"import toucan.modele.Case;\n" +
				"import toucan.modele.LesCases;\n" +
				"/**\n" +
				"* Classe qui utilise l'algorithme personnalisé\n" +
				"*/\n" +
				"public class AlgoPerso extends Algo {\n" +
				"int nbCases;\n" +
				"int tab[] = new int[nbCases];\n" +
				"\n" +
				"public AlgoPerso(LesCases lesCases) {\n" +
				"super(lesCases, \"\");\n" +
				"}\n" +
				"@Override\n" +
				"public void trier() {\n" +
				((code == null) ? "" : code) + "\n" +
				"}\n" +
				"}\n"
		);
		laClasse = stringBuilder.toString();

	}


	public void compiler() {
		// writer pour écrire les erreurs de compilation
		StringWriter sortieErreur = new StringWriter();

		Iterable<? extends JavaFileObject> fileObjects = getJavaSourceFromString(nomClasse, laClasse);

		compiler.getTask(sortieErreur, fileManager, null, null, null, fileObjects).call();
		try {
			sortieErreur.close();
		} catch (IOException ex) {
			Logger.getLogger(KitJava.class.getName()).log(Level.SEVERE, null, ex);
		}

		System.out.println("compilation du code : ");
		System.out.println(laClasse);
		System.out.println("-------------------------------------");
		System.out.println("sortie d'erreur de la compilation : ");
		System.out.println(sortieErreur);
		System.out.println("-------------------------------------");
	}

	private Iterable<JavaSource> getJavaSourceFromString(String fileName, String code) {
		return Collections.singletonList(new JavaSource(fileName, code));
	}

	public void executer(LesCases lesCases) {
		try {
			String nomExecutable = nomPackage + "." + nomClasse;
			System.out.println("nomexécutable : " + nomExecutable);
			//Object instance = fileManager.getClassLoader(javax.tools.StandardLocation.CLASS_PATH).loadClass("toucan.algorithme.AlgoPerso");
			ClassLoader cl = fileManager.getClassLoader(javax.tools.StandardLocation.CLASS_PATH);
			Class<?> classe = Class.forName("toucan.algorithme.AlgoPerso", true, cl);
			Constructor<?> constructeur = classe.getConstructor(Class.forName("toucan.modele.LesCases"));
			Algo instance = (Algo) constructeur.newInstance(lesCases);

			((Algo) instance).trier();

			System.out.println("Résultat de l'exécution : ");
			//System.out.println(res);
			System.out.println("-------------------------------------");

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
			Logger.getLogger(KitJava.class.getName()).log(Level.SEVERE, null, ex);
		} catch (NoSuchMethodException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public String getLaClasse() {
		return laClasse;
	}

	public static void main(String[] args) {
		KitJava kit = KitJava.getInstance();
		kit.construireClasse("int i = 0; System.out.println(\"toto\");");
		System.out.println(kit.getLaClasse());
		kit.compiler();
		kit.executer(null);
	}
}
