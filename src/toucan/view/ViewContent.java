package toucan.view;

import toucan.modele.Modele;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Valentin.
 */
public class ViewContent extends JPanel implements Observer {

	private ViewGraphique vueGraph;
	private JSplitPane JSPVertic, JSPHoriz;

	public ViewContent(Observable model, ViewGraphique vueGraph) {
		model.addObserver(this);
		this.vueGraph = vueGraph;
		setLayout(new BorderLayout());
		init((Modele) model);
	}

	private void init(Modele m) {
		JSPVertic = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new ViewEditorPane(m, vueGraph.getPanAnim()), vueGraph);
		JScrollPane sp = new JScrollPane(new ViewDebugPane(m));
		sp.setMinimumSize(new Dimension(0,0));
		sp.setPreferredSize(new Dimension(0,0));
		JSPHoriz = new JSplitPane(JSplitPane.VERTICAL_SPLIT, JSPVertic, sp);
		add(JSPHoriz);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (!((Modele) o).isAlgoCustom()) {
			if (JSPVertic.isEnabled()) {
				JSPVertic.setEnabled(false);
				JSPVertic.setDividerSize(0);
			}

			if (JSPHoriz.isEnabled()) {
				JSPHoriz.setEnabled(false);
				JSPHoriz.setDividerSize(0);
			}
		} else {
			if (!JSPVertic.isEnabled()) {
				JSPVertic.setEnabled(true);
				JSPVertic.setDividerSize(5);
				JSPVertic.setDividerLocation(0.2);
			}

			if (!JSPHoriz.isEnabled()) {
				JSPHoriz.setEnabled(true);
				JSPHoriz.setDividerSize(5);
				JSPHoriz.setDividerLocation(0.8);
			}
		}
	}
}
