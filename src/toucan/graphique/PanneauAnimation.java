package toucan.graphique;

import toucan.modele.Modele;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PanneauAnimation extends JPanel {

	private Modele modele;
	private LesCasesAnimation lesCasesAnimation;
	private int tempsActuel;

	public PanneauAnimation(Modele modele) {
		this.modele = modele;
		lesCasesAnimation = new LesCasesAnimation(modele);
		tempsActuel = 0;
		this.setPreferredSize(new Dimension(500, 500)) ;
		repaint();	// Appel paintComponent(...)
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		int w = getWidth();
		int h = getHeight();
		GradientPaint gp = new GradientPaint(-w, -h, Color.LIGHT_GRAY, w, h, Color.WHITE);
		g2.setPaint(gp);
		g2.fillRect(0, 0, w, h);

		lesCasesAnimation.dessiner(g, tempsActuel);    // temps à incrementer
		if (tempsActuel < modele.getMaxTemps()) tempsActuel++;

		try {
			Thread.sleep(modele.getTempsDeLatence());
		} catch (InterruptedException ex) {
			Logger.getLogger(PanneauAnimation.class.getName()).log(Level.SEVERE, null, ex);
		}
		repaint();
	}
}
