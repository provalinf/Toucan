package toucan.view.viewMenuItem;

import toucan.graphique.PanneauAnimation;
import toucan.modele.Modele;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Valentin.
 */
public class ViewMenuAlgo extends JMenu implements Observer {

	private JCheckBoxMenuItem[] algo;

	public ViewMenuAlgo(Observable model, PanneauAnimation panAnim) {
		super("Algo");
		model.addObserver(this);
		init((Modele) model, panAnim);
	}

	/**
	 * À modifier pour génération automatique en fonction des classes trouvées
	 * Modifier également le "Stop" avant le changement d'algo (éqv du code bouton stop pas terrible)
	 *
	 * @param m
	 * @param panAnim
	 */
	private void init(Modele m, PanneauAnimation panAnim) {
		algo = new JCheckBoxMenuItem[m.getNbAlgo()];
		algo[0] = (JCheckBoxMenuItem) add(new JCheckBoxMenuItem("Algo Bulle"));
		algo[1] = (JCheckBoxMenuItem) add(new JCheckBoxMenuItem("Algo Insertion"));
		algo[2] = (JCheckBoxMenuItem) add(new JCheckBoxMenuItem("Algo Sélection"));

		for (int i = 0; i < m.getNbAlgo(); i++) {
			int finalI = i;
			algo[i].addActionListener(e -> {
				m.stopAndReset();
				panAnim.resetAndInit();
				m.refreshUI();

				m.setSelectionAlgo(finalI);
				m.refreshUI();
			});
		}

		//algo[1].setEnabled(false);		// Tempo algo non terminé

		setButtonsStates(m);
	}

	private void setButtonsStates(Modele m) {
		for (int i = 0; i < m.getNbAlgo(); i++) {
			algo[i].setState(m.getSelectionAlgo() == i);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		Runnable run = () -> setButtonsStates((Modele) o);
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
