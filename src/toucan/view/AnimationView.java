package toucan.view;

import toucan.graphique.LesCasesAnimation;
import toucan.modele.Modele;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 * 24 juin 2014 - maj 29 août 2017
 *
 * @author brigitte wrobel-dautcourt
 */

public class AnimationView extends JPanel implements Observer {
    
    protected LesCasesAnimation lesCasesAnimation ;
    
    protected int temps;
    protected static int temporisation = 100 ;
    
    public AnimationView(Modele m) {
        super() ;
        m.addObserver(this);
        temps = m.getTempsDeLatence();
        this.setPreferredSize(new Dimension(500, 500)) ;
        lesCasesAnimation = new LesCasesAnimation() ;
        temps = 0 ;
        repaint() ;
    }
    
    @Override
    public void paintComponent(Graphics g) { 
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        int w = getWidth() ;
        int h = getHeight() ;

        GradientPaint gp = new GradientPaint(-w, -h, Color.LIGHT_GRAY, w, h, Color.WHITE);
        g2.setPaint(gp);
        g2.fillRect(0, 0, w, h);
        lesCasesAnimation.dessiner(g, temps) ;
        temps ++ ;
        
        // à décommenter pour l'exercice 2...
        try {
             Thread.sleep(temporisation) ;
         } catch (InterruptedException ex) {
             Logger.getLogger(AnimationView.class.getName()).log(Level.SEVERE, null, ex);
         }
         repaint() ;
    }

    @Override
    public void update(Observable observable, Object o) {

    }
}
