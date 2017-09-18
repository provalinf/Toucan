package toucan;

import toucan.modele.Modele;

public class Toucan {

    public static void main(String[] args) {
        Modele mod = new Modele(3);
        mod.creerCase(2, 2, 1);
        mod.creerCase(2, 2, 2);
        mod.creerCase(3, 3, 3);
        mod.creerCase(4, 4, 4);

        mod.creerLesMouvements(0, Modele.NORD, 5, 0, Modele.SUD, 10, 0, Modele.EST, 10, 1, Modele.STABLE, 10, 1, Modele.SUD, 10);
        System.out.println(mod);
    }
}
