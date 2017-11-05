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

	public PanneauAnimation getPanAnim() {
		return panAnim;
	}

	@Override
	public void update(Observable o, Object arg) {
		Runnable run = () -> {
			if (!((Modele) o).isMouvCalc() || !panAnim.isEnd()) {
				panAnim.repaint();
			} else if (!panAnim.isPause()) {
				panAnim.setPause(true);
				((Modele) o).refreshUI();
			}
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
