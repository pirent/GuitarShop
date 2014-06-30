package pirent.demo.guitarshop.chapter2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Timer;
import java.util.TimerTask;

import pirent.demo.guitarshop.chapter4.Bark;

public class DogDoor {

	private static final int DEFAULT_DOOR_CLOSE_AUTOMATICALLY_PERIOD = 5000;
	private boolean isOpen;
	private Collection<Bark> allowedBarks;
	
	public DogDoor() {
		this.isOpen = false;
		allowedBarks = new ArrayList<Bark>();
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
	
	public void addAllowedBark(Bark bark) {
		this.allowedBarks.add(bark);
	}
	
	public Collection<Bark> getAllowedBark() {
		return allowedBarks;
	}
}
