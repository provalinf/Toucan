package toucan.outils;

import toucan.algorithme.Algo;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.ToolProvider;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

import static toucan.outils.TestOutils.maClasse;
import static toucan.outils.TestOutils.nomClasse;

/**
 * Created by Cyril on 08/11/2017.
 */
public class KitJava {
    protected JavaCompiler compiler;
    protected ClassFileManager fileManager;
    protected static String nomClasse = "AlgoPerso" ;
    protected static String nomPackage = "toucan.outils";
    public KitJava() {
        compiler = ToolProvider.getSystemJavaCompiler();
        fileManager = new ClassFileManager(compiler.getStandardFileManager(null, null, null));
    }

    private String laClasse;

    public void construireClasse(String code){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("package toucan.algorithme;\n"+
                            "import toucan.graphique.animation.AffectationCaseCase;\n"+
                            "import toucan.graphique.animation.AffectationCaseVar;\n"+
                            "import toucan.graphique.animation.AffectationVarCase;\n"+
                            "import toucan.graphique.animation.ComparaisonCaseCase;\n"+
                            "import toucan.modele.Case;\n"+
                            "import toucan.modele.LesCases;\n"+
                            "/**\n"+
                            "* Classe qui utilise l'algorithme personnalisé\n"+
                            "*/\n"+
                            "public class AlgoPerso extends Algo {\n"+
                            "public AlgoPerso(LesCases lesCases) {\n" +
                            "super(lesCases);\n" +
                            "}\n"+
                            "@Override\n" +
                            "public void trier() {\n"+
                            code+"\n"+
                            "}\n"+
                            "}\n"
        );
        laClasse = stringBuilder.toString();

    }

    private Iterable<JavaSource> getJavaSourceFromString(String fileName, String code) {
        return Collections.singletonList(new JavaSource(fileName, code));
    }

    public void compiler(){
        StringWriter sortieErreur = new StringWriter();

        Iterable<? extends JavaFileObject> fileObjects = getJavaSourceFromString(nomClasse, maClasse);

        compiler.getTask(sortieErreur, fileManager, null, null, null, fileObjects).call();
        try {
            sortieErreur.close() ;
        } catch (IOException ex) {
            Logger.getLogger(KitJava.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("compilation du code : ");
        System.out.println(maClasse);
        System.out.println("-------------------------------------");
        System.out.println("sortie d'erreur de la compilation : ") ;
        System.out.println(sortieErreur);
        System.out.println("-------------------------------------");
    }

    public void executer(){
        try {
            String nomExecutable = nomPackage + "." + nomClasse ;
            System.out.println("nomexécutable : " + nomExecutable);

            Object instance = fileManager.getClassLoader(javax.tools.StandardLocation.CLASS_PATH).loadClass("toucan.algorithme.AlgoPerso").newInstance();
            ((IEssai)instance).setX(23) ;
            int res = ((IEssai)instance).getX() ;

            System.out.println("Résultat de l'exécution : ");
            System.out.println(res);
            System.out.println("-------------------------------------");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestOutils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(TestOutils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TestOutils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getLaClasse() {
        return laClasse;
    }

    public static void main(String[] args) {
        KitJava kit = new KitJava();
        kit.construireClasse("int i = 0;");
        System.out.println(kit.getLaClasse());
    }
}
