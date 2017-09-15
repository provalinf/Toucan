import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import toucan.*;
import toucan.algorithme.Algo;
import toucan.algorithme.AlgoBulle;
import toucan.algorithme.AlgoInsert;
import toucan.algorithme.AlgoSelection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * jUnit5
 */
public class AlgoUnitTest {

	private LesCases tabCases;

	@BeforeEach
	public void initTab() {
		tabCases = new LesCases(4);
		tabCases.creerCases(1, 1, 1);
		tabCases.creerCases(0, 0, 0);
		tabCases.creerCases(3, 3, 3);
		tabCases.creerCases(2, 2, 2);
	}

	@Test
	public void AlgoBulleTest() {
		Algo bulle = new AlgoBulle(tabCases);

		for (int i = 0; i < 4; i++)
			assertNotEquals(i, tabCases.getCase(i).getValeur());

		bulle.trier();

		for (int i = 0; i < 4; i++)
			assertEquals(i, tabCases.getCase(i).getValeur());
	}

	@Test
	public void AlgoSelectionTest() {
		Algo select = new AlgoSelection(tabCases);

		for (int i = 0; i < 4; i++)
			assertNotEquals(i, tabCases.getCase(i).getValeur());

		select.trier();

		for (int i = 0; i < 4; i++)
			assertEquals(i, tabCases.getCase(i).getValeur());
	}

	@Test
	public void AlgoInsertTest() {
		Algo insert = new AlgoInsert(tabCases);

		for (int i = 0; i < 4; i++)
			assertNotEquals(i, tabCases.getCase(i).getValeur());

		insert.trier();

		for (int i = 0; i < 4; i++)
			assertEquals(i, tabCases.getCase(i).getValeur());
	}
}
