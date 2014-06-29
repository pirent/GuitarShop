package pirent.demo.guitarshop.chapter2;

import java.util.Timer;
import java.util.TimerTask;

public class DogDoor {

	private static final int DEFAULT_DOOR_CLOSE_AUTOMATICALLY_PERIOD = 5000;
	private boolean isOpen;
	
	public DogDoor() {
		this.isOpen = false;
	}
	
	public void open() {
		System.out.println("The dog door opens");
		isOpen = true;

		final Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				close();
				timer.cancel();
			}
		}, DEFAULT_DOOR_CLOSE_AUTOMATICALLY_PERIOD);
	}
	
	public void close() {
		System.out.println("The dog door closes");
		isOpen = false;
	}
	
	public boolean isOpen() {
		return isOpen;
	}
}
