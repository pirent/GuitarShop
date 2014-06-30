package pirent.demo.guitarshop.chapter4;

import java.util.Collection;

import pirent.demo.guitarshop.chapter2.DogDoor;

public class BarkRecognizer2 {

	private final DogDoor door;
	
	public BarkRecognizer2(DogDoor door) {
		this.door = door;
	}
	
	public void recognize(Bark bark) {
		System.out.println("  BarkRecognizer: Heard a '" + bark + "'");
		Collection<Bark> allowedBarks = door.getAllowedBark();
		for (Bark b: allowedBarks) {
			if (b.equals(bark)) {
				door.open();
				return;
			}
		}
		System.out.println("This dog is not allowed.");
	}
}
