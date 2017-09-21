package toucan.graphique;

import toucan.modele.Modele;
import toucan.view.AnimationView;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 * @author brigitte wrobel-dautcourt
 */

public class ToucanTp3 extends JFrame {
    
    public ToucanTp3() {
        super("Projet Toucan - animation des algorithmes de tris");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
        // instanciation du panneau des cases
        AnimationView panneau = new AnimationView(new Modele(5)) ;
        add(panneau, BorderLayout.CENTER) ;
        
        pack() ;
        setVisible(true);
    }
    public static void main(String[] args) {
        new ToucanTp3() ;
    }
}
