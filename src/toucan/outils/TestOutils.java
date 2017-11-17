package toucan.outils;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.ToolProvider;

/**
 * 13 juin 2014
 *
 * @author brigitte wrobel-dautcourt
 */

public class TestOutils{
    
    protected static String maClasse = "package toucan.outils ;\n" +
            "public class Essai implements IEssai {\n" +
            "   protected int x ;\n" +
            "   public Essai () {\n" +
            "   }\n" +
            "   public void setX(int i) {\n" +
            "         x = i ;\n" +
            "   }\n" +
            "   public int getX() {\n" +
            "          return x ;\n" +
            "   }\n" +
            "}\n" ;
                 
    protected static String nomClasse = "Essai" ;
    protected static String nomPackage = "toucan.outils" ;
    
    protected JavaCompiler compiler ;
    protected ClassFileManager fileManager ;
    
    public TestOutils() {    
        compiler = ToolProvider.getSystemJavaCompiler();
        fileManager = new ClassFileManager(compiler.getStandardFileManager(null, null, null));
    }
    
    public void compiler() {
        // writer pour écrire les erreurs de compilation
        StringWriter sortieErreur = new StringWriter();

        Iterable<? extends JavaFileObject> fileObjects = getJavaSourceFromString(nomClasse, maClasse);

        compiler.getTask(sortieErreur, fileManager, null, null, null, fileObjects).call();
        try {
            sortieErreur.close() ;
        } catch (IOException ex) {
            Logger.getLogger(TestOutils.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("compilation du code : ");
        System.out.println(maClasse);
        System.out.println("-------------------------------------");
        System.out.println("sortie d'erreur de la compilation : ") ;
        System.out.println(sortieErreur);
        System.out.println("-------------------------------------");
    }

    private Iterable<JavaSource> getJavaSourceFromString(String fileName, String code) {
	return Collections.singletonList(new JavaSource(fileName, code));
    }
    
    public void executer() {
        try {
            String nomExecutable = nomPackage + "." + nomClasse ;
            System.out.println("nomexécutable : " + nomExecutable);
            
            Object instance = fileManager.getClassLoader(javax.tools.StandardLocation.CLASS_PATH).loadClass("toucan.outils.Essai").newInstance();
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
    
    public static void main(String [] args) {
        TestOutils test = new TestOutils() ;
        test.compiler() ;
        test.executer() ;
    }

}
