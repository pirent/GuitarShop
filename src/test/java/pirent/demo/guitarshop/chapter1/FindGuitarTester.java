package pirent.demo.guitarshop.chapter1;

import org.junit.BeforeClass;
import org.junit.Test;

public class FindGuitarTester {

	private static Inventory inventory;

	@BeforeClass
	public static void setupInventory() {
		inventory = new Inventory();
		inventory.addGuitar("101", 101, "Builder 1", "Model 1", "Acoustic",
				"Back Wood 1", "Top Wood 1");
		inventory.addGuitar("102", 102, "Builder 2", "Model 2", "Acoustic",
				"Back Wood 2", "Top Wood 2");
		inventory.addGuitar("103", 103, "Builder 3", "Model 3", "Acoustic",
				"Back Wood 3", "Top Wood 3");
	}

	@Test
	public void findGuitar() {
		Guitar whatErikLikes = new Guitar("", 0, "Builder 3", "", "Acoustic",
				"Back Wood 2", "Top Wood 2");

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
