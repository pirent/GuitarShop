package pirent.demo.guitarshop.chapter1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Inventory {

	private List guitars;

	public Inventory() {
		guitars = new LinkedList();
	}

	public void addGuitar(String serialNumber, double price, String builder,
			String model, String type, String backWood, String topWood) {
		Guitar guitar = new Guitar(serialNumber, price, builder, model, type,
				backWood, topWood);
		guitars.add(guitar);
	}

	public Guitar getGuitar(String serialNumber) {
		for (Iterator it = guitars.iterator(); it.hasNext();) {
			Guitar guitar = (Guitar) it.next();
			if (guitar.getSerialNumber().equals(serialNumber)) {
				return guitar;
			}
		}
		return null;
	}

	/**
	 * This method is a bit of mess...it compares each property of Guitar object
	 * it's passed in to each Guitar object in Rick's inventory.
	 * 
	 * @param searchGuitar
	 * @return
	 */
	public Guitar seach(Guitar searchGuitar) {
		for (Iterator it = guitars.iterator(); it.hasNext();) {
			Guitar guitar = (Guitar) it.next();

			// Ignore serial number because it is unique
			// Ignore price since that's unique
			String builder = searchGuitar.getBuilder();
			if ((builder != null) && (!builder.equals(""))
					&& (!builder.equals(guitar.getBuilder()))) {
				continue;
			}

			String model = searchGuitar.getModel();
			if ((model != null) && (!model.equals(""))
					&& (!model.equals(guitar.getModel()))) {
				continue;
			}

			String type = searchGuitar.getType();
			if ((type != null) && (!type.equals(""))
					&& (!type.equals(guitar.getType()))) {
				continue;
			}

			String topWood = searchGuitar.getTopWood();
			if ((topWood != null) && (!topWood.equals(""))
					&& (!topWood.equals(guitar.getTopWood()))) {
				continue;
			}

			String backWood = searchGuitar.getBackWood();
			if ((backWood != null) && (!backWood.equals(""))
					&& (!backWood.equals(guitar.getBackWood()))) {
				continue;
			}
		}

		return null;
	}
}
