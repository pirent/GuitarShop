package pirent.demo.guitarshop.chapter1;

import java.util.Iterator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import pirent.demo.guitarshop.chapter1.enhancement.Builder;
import pirent.demo.guitarshop.chapter1.enhancement.Type;
import pirent.demo.guitarshop.chapter1.enhancement.Wood;

public class FindGuitarTester {

	private static Inventory inventory;

	@BeforeClass
	public static void setupInventory() {
		inventory = new Inventory();
		inventory.addGuitar("V95693", 1499.95, Builder.FENDER, "Stratocastor", Type.ELECTRIC,
				Wood.ALDER, Wood.ALDER);
		inventory.addGuitar("102", 102, Builder.MARTIN, "Model 2", Type.ACOUSTIC,
				Wood.ALDER, Wood.CEDAR);
		inventory.addGuitar("V9512", 1549.95, Builder.FENDER, "Stratocastor", Type.ELECTRIC,
				Wood.ALDER, Wood.ALDER);
	}

	@Test
	public void findGuitar() {
		Guitar whatErikLikes = new Guitar("", 0, Builder.FENDER, "Stratocastor", Type.ELECTRIC,
				Wood.ALDER, Wood.ALDER);

		List matchingGuitars = inventory.seach(whatErikLikes);
		if (matchingGuitars != null) {
			StringBuilder sb = new StringBuilder("Erin, you might like these guitars:");
			for (Iterator i = matchingGuitars.iterator(); i.hasNext(); ) {
				Guitar guitar = (Guitar) i.next();
				sb.append("\n We have a ").append(guitar.getBuilder()).append(" ").append(guitar.getModel()).append(" ").append(guitar.getType()).append(" guitar:\n");
				sb.append(guitar.getBackWood()).append(" back and sides,\n");
				sb.append(guitar.getTopWood()).append(" top.\n");
				sb.append("You can have it for only $").append(guitar.getPrice()).append("\n-----");
			}
			System.out.println(sb.toString());
		} else {
			System.out.println("Sorry, Erin, we have nothing for you");
		}
	}
}
