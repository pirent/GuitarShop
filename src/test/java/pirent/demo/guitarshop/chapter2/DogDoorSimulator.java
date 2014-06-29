package pirent.demo.guitarshop.chapter2;

import org.junit.Before;
import org.junit.Test;

import pirent.demo.guitarshop.chapter3.BarkRecognizer;

public class DogDoorSimulator {

	private Remote remote;
	private DogDoor door;
	private BarkRecognizer recognizer;
	
	@Before
	public void setUp() {
		door = new DogDoor();
		remote = new Remote(door);
		recognizer = new BarkRecognizer(door);
	}
	
//	@Test
	public void test() {
		System.out.println("----- Test case 1 ------");
		
		System.out.println("Fido barks to go outside...");
		remote.pressButton();
		
		System.out.println("\nFido has gone outside...");
		
		System.out.println("\nFido's all done...");
		
		System.out.println("\nFido's back inside...");
		
		System.out.println("------------------------");
	}
	
//	@Test
	public void test2() {
		System.out.println("----- Test case 2 ------");
		
		System.out.println("Fido barks to go outside...");
		remote.pressButton();
		System.out.println("\nFido has gone outside...");
		System.out.println("\nFido's all done...");
		
		try {
			Thread.currentThread().sleep(10000);
		} catch (InterruptedException e) {
			// Pretend that Fido stay outside as long as this
		}
		
		System.out.println("... but he's stuck outside");
		System.out.println("\nFido starts barking again...");
		System.out.println("...so Giana grabs the remote control.");
		remote.pressButton();
		System.out.println("\nFido's back inside...");
		
		System.out.println("------------------------");
	}

	@Test
	public void test3() {
		System.out.println("----- Test case 3 ------");
		
		System.out.println("Fido barks to go outside...");
		recognizer.recognize("Woof");
		
		System.out.println("\nFido has gone outside...");
		System.out.println("\nFido's all done...");
		
		try {
			Thread.currentThread().sleep(10000);
		} catch (InterruptedException e) {
			// Pretend that Fido stay outside as long as this
		}
		
		System.out.println("... but he's stuck outside");
		System.out.println("\nFido starts barking again...");
		recognizer.recognize("Woof");
		System.out.println("\nFido's back inside...");
		
		System.out.println("------------------------");
	}
}
