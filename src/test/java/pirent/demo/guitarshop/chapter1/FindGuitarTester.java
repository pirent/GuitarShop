package pirent.demo.guitarshop.chapter1;

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
		inventory.addGuitar("101", 101, Builder.FENDER, "Model 1", Type.ACOUSTIC,
				Wood.CEDAR, Wood.COCOBOLO);
		inventory.addGuitar("102", 102, Builder.MARTIN, "Model 2", Type.ACOUSTIC,
				Wood.ALDER, Wood.CEDAR);
		inventory.addGuitar("103", 103, Builder.GIBSON, "Model 3", Type.ELECTRIC,
				Wood.ADIRONDACK, Wood.CEDAR);
	}

	@Test
	public void findGuitar() {
		Guitar whatErikLikes = new Guitar("", 0, Builder.FENDER, "Model 2", Type.ACOUSTIC,
				Wood.CEDAR, Wood.CEDAR);

		Guitar guitar = inventory.seach(whatErikLikes);
		if (guitar != null) {
			StringBuilder sb = new StringBuilder("Erik, you might like this ")
					.append(guitar.getBuilder()).append(", ")
					.append(guitar.getType())
					.append(" guitar, back and side with ")
					.append(guitar.getBackWood()).append(", with top made of ")
					.append(guitar.getTopWood());
			sb.append("\nYou can have it only for $").append(guitar.getPrice());

			System.out.println(sb.toString());
		} else {
			System.out.println("Sorry, we have nothing for you");
		}
	}
}
