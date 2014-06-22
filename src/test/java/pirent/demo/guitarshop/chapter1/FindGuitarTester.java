package pirent.demo.guitarshop.chapter1;

import java.util.Iterator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import pirent.demo.guitarshop.chapter1.enhancement.Builder;
import pirent.demo.guitarshop.chapter1.enhancement.GuitarSpec;
import pirent.demo.guitarshop.chapter1.enhancement.Type;
import pirent.demo.guitarshop.chapter1.enhancement.Wood;

public class FindGuitarTester {

	private static Inventory inventory;

	@BeforeClass
	public static void setupInventory() {
		inventory = new Inventory();
		inventory.addGuitar("V95693", 1499.95, new GuitarSpec(Builder.FENDER, "Stratocastor", Type.ELECTRIC,
				Wood.ALDER, Wood.ALDER, 6) );
		inventory.addGuitar("102", 102, new GuitarSpec(Builder.MARTIN, "Model 2", Type.ACOUSTIC,
				Wood.ALDER, Wood.CEDAR, 10));
		inventory.addGuitar("V9512", 1549.95, new GuitarSpec(Builder.FENDER, "Stratocastor", Type.ELECTRIC,
				Wood.ALDER, Wood.ALDER, 6));
	}

	@Test
	public void findGuitar() {
		GuitarSpec whatErikLikes = new GuitarSpec(Builder.FENDER, "Stratocastor", Type.ELECTRIC,
				Wood.ALDER, Wood.ALDER, 6);

		List matchingGuitars = inventory.seach(whatErikLikes);
		if (matchingGuitars != null) {
			StringBuilder sb = new StringBuilder("Erin, you might like these guitars:");
			for (Iterator i = matchingGuitars.iterator(); i.hasNext(); ) {
				Guitar guitar = (Guitar) i.next();
				GuitarSpec spec = guitar.getSpec();
				sb.append("\n We have a ").append(spec.getBuilder()).append(" ").append(spec.getModel()).append(" ").append(spec.getType()).append(" guitar:");
				sb.append("\n  ").append(spec.getBackWood()).append(" back and sides,");
				sb.append("\n  ").append(spec.getTopWood()).append(" top.");
				sb.append("\n You can have it for only $").append(guitar.getPrice()).append("\n ------------");
			}
			System.out.println(sb.toString());
		} else {
			System.out.println("Sorry, Erin, we have nothing for you");
		}
	}
}
