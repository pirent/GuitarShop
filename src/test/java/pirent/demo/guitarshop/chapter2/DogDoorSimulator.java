package pirent.demo.guitarshop.chapter2;

import org.junit.Before;
import org.junit.Test;

public class DogDoorSimulator {

	private Remote remote;
	private DogDoor door;
	
	@Before
	public void setUp() {
		door = new DogDoor();
		remote = new Remote(door);
	}
	
	@Test
	public void test() {
		System.out.println("Fido barks to go outside...");
		remote.pressButton();
		System.out.println("\nFido has gone outside...");
		remote.pressButton();
		System.out.println("\nFido's all done...");
		remote.pressButton();
		System.out.println("\nFido's back inside...");
		remote.pressButton();
	}
}
