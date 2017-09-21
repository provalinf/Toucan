package toucan.graphique;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * 22 juin 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class LesCasesAnimation {
    
    protected ArrayList<CaseAnimation> lesCases ;
    
    public LesCasesAnimation() {
        lesCases = new ArrayList<>(3) ;
        lesCases.add(new CaseAnimation("a", 120, 50, Color.blue)) ;
        lesCases.add(new CaseAnimation("b", 170, 105, Color.magenta)) ;
        lesCases.add(new CaseAnimation("c", 230, 70, new Color(0, 154, 0))) ;
    }
    
    public void dessiner(Graphics g, int t) {
        for (CaseAnimation ca : lesCases) {
            ca.dessiner(g, t) ;
        }
    }

}
