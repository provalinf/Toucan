package toucan;

import java.util.ArrayList;

/**
 * Created by Cyril on 06/09/2017.
 */
public class LesMouvements {
    private ArrayList<Mouvement> lesMouvs;
    private int xInit;
    private int yInit;

    public LesMouvements(int xInit, int yInit) {
        lesMouvs = new ArrayList<>();
        this.xInit = xInit;
        this.yInit = yInit;
    }

    public void monter(int dep) {
        lesMouvs.add(new Mouvement(0, dep, posX(), posY()));
    }

    public int posX() {
        int horizontal = 0;
        for (Mouvement mouv : lesMouvs) {
            if (mouv instanceof MouvementGauche) {
                horizontal--;
            } else if (mouv instanceof MouvementDroit) {
                horizontal++;
            }
        }
        return xInit + horizontal;
    }
    public int posY() {
        int vertical = 0;
        for (Mouvement mouv : lesMouvs) {
            if (mouv instanceof MouvementMonter) {
                vertical++;
            } else if (mouv instanceof MouvementDescendre) {
                vertical--;
            }
        }
        return yInit + vertical;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Position actuelle/n");
        sb.append("x").append(posX()).append("/n");
        sb.append("y").append(posY()).append("/n");
        return sb.toString();
    }
}
