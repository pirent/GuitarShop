package pirent.demo.guitarshop.chapter2;

public class DogDoor {

	private boolean isOpen;
	
	public DogDoor() {
		this.isOpen = false;
	}
	
	public void open() {
		System.out.println("The dog door opens");
		isOpen = true;
	}
	
	public void close() {
		System.out.println("The dog door closes");
		isOpen = false;
	}
	
	public boolean isOpen() {
		return isOpen;
	}
}
