package toucan.modele;

import toucan.LesCases;

public class Modele {

    public static final int NORD = 0;
    public static final int SUD = 1;
    public static final int EST = 2;
    public static final int OUEST = 3;
    public static final int STABLE = 4;

    private LesCases lesCases;

    public Modele(int nbCases) {
        lesCases = new LesCases(nbCases);
    }

    /**
     * Créer les mouvements à partir d'un tableau de int
     *
     * @param mouvs : Numéro de la case, Direction du mouvement, Distance
     */
    public void creerLesMouvements(int... mouvs) {
        for (int i = 0; i + 3 <= mouvs.length; i += 3) {
            switch (mouvs[i + 1]) {
                case NORD:
                    lesCases.monter(mouvs[i], mouvs[i + 2]);
                    break;
                case SUD:
                    lesCases.descendre(mouvs[i], mouvs[i + 2]);
                    break;
                case EST:
                    lesCases.droite(mouvs[i], mouvs[i + 2]);
                    break;
                case OUEST:
                    lesCases.gauche(mouvs[i], mouvs[i + 2]);
                    break;
                case STABLE:
                    lesCases.stable(mouvs[i], mouvs[i + 2]);
            }
        }
    }

    /**
     * Créer une case
     *
     * @param xInit : Integer, Position X Initiale
     * @param yInit : Integer, Position Y Initiale
     * @param val   : Integer, Valeur de la case
     */
    public void creerCase(int xInit, int yInit, int val) {
        lesCases.creerCases(xInit, yInit, val);
    }

    /**
     * Redéfinie la position initiale d'une case
     *
     * @param numCase : Integer, Numéro de la case
     * @param xInit   : Integer, nouvelle Position X
     * @param yInit   : Integer, nouvelle Position Y
     */
    public void setPosition(int numCase, int xInit, int yInit) {
        lesCases.getCase(numCase).setPosition(xInit, yInit);
    }

    @Override
    public String toString() {
        return lesCases.toString();
    }
}
