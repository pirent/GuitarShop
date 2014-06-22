package pirent.demo.guitarshop.chapter1.enhancement;

public class GuitarSpec {

	private Builder builder;
	private String model;
	private Type type;
	private Wood backWood;
	private Wood topWood;
	private int numStrings;

	public GuitarSpec(Builder builder, String model, Type type, Wood backWood,
			Wood topWood, int numStrings) {
		super();
		this.builder = builder;
		this.model = model;
		this.type = type;
		this.backWood = backWood;
		this.topWood = topWood;
		this.numStrings = numStrings;
	}

	public Builder getBuilder() {
		return builder;
	}

	public String getModel() {
		return model;
	}

	public Type getType() {
		return type;
	}

	public Wood getBackWood() {
		return backWood;
	}

	public Wood getTopWood() {
		return topWood;
	}

	public int getNumStrings() {
		return numStrings;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null || !(o instanceof GuitarSpec)) {
			return false;
		}
		GuitarSpec spec = (GuitarSpec) o;
		
		if (spec.getBuilder() != this.builder) {
			return false;
		}

		String model = spec.getModel().toLowerCase();
		if ((model != null) && (!model.equals(""))
				&& (!model.equals(this.model.toLowerCase()))) {
			return false;
		}

		if (spec.type != this.type) {
			return false;
		}

		if (spec.backWood != this.backWood) {
			return false;
		}

		if (spec.topWood != this.topWood) {
			return false;
		}
		return true;
	}
}
