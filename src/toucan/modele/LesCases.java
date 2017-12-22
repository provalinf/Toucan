package toucan.modele;

import java.util.ArrayList;

public class LesCases {

	private ArrayList<Case> lesCases;
	private int NbVariable;

	public LesCases(int nbCases) {
		NbVariable = 0;
		lesCases = new ArrayList<>(nbCases);
		for (int i = 0; i < nbCases; i++)
			creerCases(0, 0, 0);
	}

	public LesCases() {
		lesCases = new ArrayList<>();
	}

	public void resetMouv() {
		for (Case c : lesCases) c.resetMouv();
	}

	public void monter(int numCase, int dep) {
		lesCases.get(numCase).monter(dep);
	}

	public void droite(int numCase, int dep) {
		lesCases.get(numCase).droite(dep);
	}

	public void gauche(int numCase, int dep) {
		lesCases.get(numCase).gauche(dep);
	}

	public void descendre(int numCase, int dep) {
		lesCases.get(numCase).descendre(dep);
	}

	public void stable(int numCase, int temps) {
		lesCases.get(numCase).stable(temps);
	}

	public void affecter(int c1, int c2) {
		lesCases.set(c1, lesCases.get(c2));
	}

	public boolean comparer(int c1, int c2) {
		return lesCases.get(c1).getValeurActuel() == lesCases.get(c2).getValeurActuel();
	}

	public void modifier(int numCase, int val) {
		lesCases.get(numCase).setValeur(val);
	}

	public Case getCase(int i) {
		return lesCases.get(i);
	}

	public Case getVariable(int i) {
		if (getNbCases() + i >= getNbCases() + getNbVariables())
			throw new AssertionError("Erreur, sortie de tableau lors de la sélection de la variable n°" + i);
		return lesCases.get(getNbCases() + i);
	}

	/**
	 * Calcule le temps max pour le mouvement des cases
	 *
	 * @return : Integer, Temps max
	 */
	public int getMaxTemps() {
		int maxTemps = 0;
		for (Case c : lesCases) {
			if (c.getMaxTemps() > maxTemps)
				maxTemps = c.getMaxTemps();
		}
		return maxTemps;
	}

	public void creerCases(int xInit, int yInit, int val) {
		lesCases.add(getNbCases(), new Case(xInit, yInit, val));
	}

	public void supprCase(){
		lesCases.remove(getNbCases()-1);
	}

	public void creerVariable(int xInit, int yInit, int val) {
		lesCases.add(new Case(xInit, yInit, val));
		NbVariable++;
	}

	public int getNbCases() {
		return lesCases.size() - getNbVariables();
	}

	public int getNbVariables() {
		return NbVariable;
	}

	public void setCase(int j, Case c1) {
		lesCases.set(j, c1);
	}

	@Override
	public String toString() {
		int maxTemps = getMaxTemps();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < lesCases.size(); i++) {
			sb.append("toucan.modele.Case ").append(i).append(": ");
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

		sb.append("Mouvements des cases\n");
		for (int i = 0; i < lesCases.size(); i++) {
			sb.append("n°").append(i).append("\n").append(lesCases.get(i).toString()).append("\n");
		}

		return sb.toString();
	}
}
