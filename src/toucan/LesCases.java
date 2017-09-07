package toucan;

import java.util.ArrayList;

public class LesCases {
	private ArrayList<Case> lesCases = new ArrayList<>();

	public void monter(int numCase, int dep) {
		lesCases.get(numCase).monter(dep);
	}

	public void affecter(int c1, int c2) {
		lesCases.set(c1, lesCases.get(c2));
	}

	public boolean comparer(int c1, int c2) {
		return lesCases.get(c1).getValeur() == lesCases.get(c2).getValeur();
	}

	public void modifier(int numCase, int val) {
		lesCases.get(numCase).setValeur(val);
	}

	// fonction toString de la classe toucan.LesCases
	@Override
	public String toString() {
		int maxTemps = getMaxTemps();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < lesCases.size(); i++) {
			sb.append("toucan.Case ").append(i).append(": ");
			Case c = lesCases.get(i);
			for (int t = 0; t <= maxTemps; t++) {
				int x = c.getPosX(t);
				int y = c.getPosY(t);
				sb.append("\t" + t + " (" + x + "," + y + ") ");
				if (t % 5 == 0) {
					sb.append("\n\t");
				}
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	private int getMaxTemps() {
		int maxTemps = 0;
		for (Case c : lesCases) {
			if (c.getNbMouv() > maxTemps)
				maxTemps = c.getNbMouv();
		}
		return maxTemps;
	}

	public void droite(int i, int i1) {
	}
}
