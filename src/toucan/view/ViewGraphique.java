package toucan.view;

import toucan.graphique.PanneauAnimation;
import toucan.modele.Modele;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Observable;
import java.util.Observer;

public class ViewGraphique extends JPanel implements Observer {

	private PanneauAnimation panAnim;

	public ViewGraphique(Observable model) {
		model.addObserver(this);
		panAnim = new PanneauAnimation((Modele) model);
		init((Modele) model);
	}

	private void init(Modele m) {
		add(panAnim);
	}

	@Override
	public void update(Observable o, Object arg) {
		Runnable run = () -> {
			panAnim.repaint();
			if (!((Modele) (o)).isThreadLaunch()) panAnim.resetTempsActuel();	// Permet de réinitialiser le temps d'affichage après un appuie sur stop par ex
		};
		if (SwingUtilities.isEventDispatchThread()) {
			run.run();
		} else {
			try {
				SwingUtilities.invokeAndWait(run);
			} catch (InterruptedException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	}
}
