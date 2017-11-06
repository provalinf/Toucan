package toucan.view.ViewMenuItem;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Valentin.
 */
public class ViewMenuAlgo extends JMenu implements Observer {
	public ViewMenuAlgo(Observable model) {
		super("Algo");
		model.addObserver(this);
		init(model);
	}

	private void init(Observable model) {
		add(new JMenuItem("First item"));
	}

	@Override
	public void update(Observable o, Object arg) {

	}
}
