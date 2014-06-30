package pirent.demo.guitarshop.chapter4;

import org.junit.Before;
import org.junit.Test;

import pirent.demo.guitarshop.chapter2.DogDoor;
import pirent.demo.guitarshop.chapter2.Remote;

public class NeighboursDogSimulator {

	private static final Bark[] ALLOWED_BARKS = new Bark[] {
		new Bark("rowlf"),
		new Bark("rooowlf"),
		new Bark("rawlf"),
		new Bark("woof")
	};
	
	private DogDoor door;
	private BarkRecognizer2 recognizer;
	private Remote remote;
	
	@Before
	public void setUp() {
		door = new DogDoor();
		recognizer = new BarkRecognizer2(door);
		for (int i = 0; i < ALLOWED_BARKS.length; i++) {
			door.addAllowedBark(ALLOWED_BARKS[i]);
		}
	}
	
	@Test
	public void testBruce() throws InterruptedException {
		// Simulate the hardware hears a dog bark
		System.out.println("Bruce starts barking.");
		recognizer.recognize(new Bark("rowlf"));
		
		System.out.println("\nBruce has gone outside...");
		
		Thread.currentThread().sleep(10000);
		
		System.out.println("\nBruce's all done...");
		System.out.println("...but he's stuck outside.");
		
		// Simulate the hardware hearing a bark (not Bruce)
		Bark smallDogBark = new Bark("yip");
		System.out.println("A small dog starts barking");
		recognizer.recognize(smallDogBark);
		
		Thread.currentThread().sleep(5000);
		
		// Simulate the hardware hears a dog bark again
		System.out.println("Bruce starts barking");
		recognizer.recognize(new Bark("rooowlf"));
		
		System.out.println("\nBruce's back inside.");
	}
}
