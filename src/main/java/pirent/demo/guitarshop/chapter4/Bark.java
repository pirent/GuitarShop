package pirent.demo.guitarshop.chapter4;

public class Bark {

	private final String sound;
	
	public Bark(String sound) {
		this.sound = sound;
	}
	
	public String getSound() {
		return sound;
	}
	
	@Override
	public boolean equals(Object object) {
		if (object instanceof Bark) {
			Bark bark = (Bark) object;
			if (this.sound.equalsIgnoreCase(bark.sound)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return sound;
	}
}
