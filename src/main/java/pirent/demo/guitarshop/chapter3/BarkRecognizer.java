package pirent.demo.guitarshop.chapter3;

import pirent.demo.guitarshop.chapter2.DogDoor;

public class BarkRecognizer {
	
	// This is the dog door to which this bark recognizer attached.
	private DogDoor door;
	
	public BarkRecognizer(DogDoor door) {
		this.door = door;
	}

	public void recognize(String bark) {
		System.out.println("  BarkRecognizer: Heard a '" + bark + "'");
		door.open();
	}
}
