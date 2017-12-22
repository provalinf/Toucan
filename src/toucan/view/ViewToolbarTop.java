package toucan.view;

import toucan.graphique.PanneauAnimation;
import toucan.modele.Modele;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Valentin.
 */
public class ViewToolbarTop extends JToolBar implements Observer {

	private PanneauAnimation panAnim;
	private JButton random;
	private JSlider slideArraySize;

	public ViewToolbarTop(Observable model, PanneauAnimation panAnim) {
		model.addObserver(this);
		this.panAnim = panAnim;
		setFloatable(false);
		init((Modele) model);
	}

	private void init(Modele m) {
		random = (JButton) add(new JButton("Random"));
		random.addActionListener(e -> {
			m.stopAndReset();
			panAnim.resetAndInit();
			m.setRandomValeurs();
			m.refreshUI();
		});

		slideArraySize = (JSlider) add(new JSlider(2,7,4));
		slideArraySize.setMajorTickSpacing(1);
		slideArraySize.setMinorTickSpacing(1);
		slideArraySize.setPaintTicks(true);
		slideArraySize.setPaintLabels(true);
		slideArraySize.addChangeListener(e -> {
					m.setNbCases(slideArraySize.getValue());
					m.stopAndReset();
					panAnim.resetAndInit();
					m.refreshUI();
				}
		);

		setButtonState(m);
	}

	private void setButtonState(Modele m) {
	}

	@Override
	public void update(Observable o, Object arg) {
		Runnable run = () -> setButtonState((Modele) o);
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
