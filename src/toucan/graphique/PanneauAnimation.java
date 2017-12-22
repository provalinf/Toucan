package toucan.graphique;

import toucan.modele.Modele;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PanneauAnimation extends JPanel {

	private Modele modele;
	private LesCasesAnimation lesCasesAnimation;
	private int tempsActuel;

	private boolean pause;
	private Image img;

	public PanneauAnimation(Modele modele) {
		this.modele = modele;
		lesCasesAnimation = new LesCasesAnimation(modele);
		resetAndInit();
		setMinimumSize(new Dimension(600, 400));
		setPreferredSize(new Dimension(600, 400));
		try {
			img = ImageIO.read(new File("C:/Users/Cyril/Desktop/toucan.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		repaint();    // Appel paintComponent(...)
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Visualisation "+modele.getNomAlgo(modele.getSelectionAlgo())),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		Graphics2D g2 = (Graphics2D) g;
		int w = getWidth();
		int h = getHeight();
		//GradientPaint gp = new GradientPaint(-w, -h, Color.LIGHT_GRAY, w, h, Color.WHITE);
		//g2.setPaint(gp);
		g2.drawImage(img, 118, 116, 960/2, 562/2, null);
		//g2.fillRect(0, 0, w, h);
		//System.out.println(". " + modele.getMaxTemps() + " " + tempsActuel);
		lesCasesAnimation.dessiner(g, tempsActuel);    // temps à incrementer

		try {
			Thread.sleep(modele.getVitesseAnimation());
		} catch (InterruptedException ex) {
			Logger.getLogger(PanneauAnimation.class.getName()).log(Level.SEVERE, null, ex);
		}
		if (modele.isThreadLaunch() || tempsActuel < modele.getMaxTemps()) {    // Permet à l'animation de fonctionner AVANT la fin du calcul des mouvements
			//System.out.println("làààààààààààààà " + !isPause());
			if (!isPause()) {
				tempsActuel++;
				//System.out.println("ça dessine un temps sup");
				repaint();
			}
		} else if (modele.isMouvCalc() && !isPause()) {
			//System.out.println("hooopppp");
			setPause(true);
			modele.refreshUI();    // Pour update l'état des boutons (/!\ à ne pas faire de loop)
		}
	}

	public boolean isPause() {
		return pause;
	}

	public void setPause(boolean pause) {
		this.pause = pause;
	}

	public void inversPause() {
		pause = !pause;
	}

	public void resetAndInit() {
		tempsActuel = 0;
		setPause(true);
	}

	public void defineDebTemps() {
		tempsActuel = 0;
		setPause(true);
		repaint();
	}

	public void defineFinTemps() {
		tempsActuel = modele.getMaxTemps();
		setPause(true);    // Facultatif
		repaint();
	}

	public int getTempsActuel() {
		return tempsActuel;
	}

	public boolean isStart() {
		return tempsActuel == 0;
	}

	public boolean isEnd() {
		return tempsActuel == modele.getMaxTemps();
	}

	public void defineCustomTemps(int temps) {
		if (temps < 0) temps = 0;
		else if (temps > modele.getMaxTemps()) temps = modele.getMaxTemps();
		else tempsActuel = temps;
	}
}
