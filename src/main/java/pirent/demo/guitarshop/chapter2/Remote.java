package pirent.demo.guitarshop.chapter2;

import java.util.Timer;
import java.util.TimerTask;

public class Remote {

	private static final int DEFAULT_DOOR_CLOSE_AUTOMATICALLY_PERIOD = 5000;
	private DogDoor door;
	
	public Remote(DogDoor door) {
		this.door = door;
	}
	
	public void pressButton() {
		System.out.println("Pressing the remote control button...");
		if (door.isOpen()) {
			door.close();
		} else {
			door.open();
			
			final Timer timer = new Timer();
			timer.schedule(new TimerTask() {
				
				@Override
				public void run() {
					door.close();
					timer.cancel();
				}
			}, DEFAULT_DOOR_CLOSE_AUTOMATICALLY_PERIOD);
		}
	}
}
