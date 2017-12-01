package toucan.view;

import toucan.modele.Modele;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Valentin.
 */
public class ViewDebugPane extends JEditorPane implements Observer {

	public ViewDebugPane(Observable model) {
		model.addObserver(this);
		init((Modele) model);
	}

	private void init(Modele m) {
		/*setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Debug output"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));*/
		setMinimumSize(new Dimension(100, 50));
		/*setPreferredSize(new Dimension(getWidth(), 200));*/
		setEditable(false);
	}

	@Override
	public void update(Observable o, Object arg) {
		setEnabled(((Modele) o).isAlgoCustom());
		setVisible(((Modele) o).isAlgoCustom());
	}
}
