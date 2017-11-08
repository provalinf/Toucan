package toucan.view;

import toucan.graphique.PanneauAnimation;
import toucan.view.viewMenuItem.ViewMenuAlgo;
import toucan.view.viewMenuItem.ViewMenuFichier;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Valentin.
 */
public class ViewMenubar extends JMenuBar implements Observer {

	private PanneauAnimation panAnim;

	public ViewMenubar(Observable model, PanneauAnimation panAnim) {
		model.addObserver(this);
		this.panAnim = panAnim;
		init(model);
	}

	private void init(Observable m) {
		add(new ViewMenuFichier(m));
		add(new ViewMenuAlgo(m, panAnim));
	}

	@Override
	public void update(Observable o, Object arg) {
		/*Runnable run = () -> {};
		if (SwingUtilities.isEventDispatchThread()) {
			run.run();
		} else {
			try {
				SwingUtilities.invokeAndWait(run);
			} catch (InterruptedException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}*/
	}
}