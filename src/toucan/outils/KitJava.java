package toucan.outils;

import toucan.algorithme.Algo;

/**
 * Created by Cyril on 08/11/2017.
 */
public class KitJava {

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

    public void compiler(){

    }

    public void executer(){

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
