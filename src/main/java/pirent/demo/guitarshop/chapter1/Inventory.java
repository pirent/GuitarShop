package pirent.demo.guitarshop.chapter1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import pirent.demo.guitarshop.chapter1.enhancement.Builder;
import pirent.demo.guitarshop.chapter1.enhancement.Type;
import pirent.demo.guitarshop.chapter1.enhancement.Wood;

public class Inventory {

	private List guitars;

	public Inventory() {
		guitars = new LinkedList();
	}

	public void addGuitar(String serialNumber, double price, Builder builder,
			String model, Type type, Wood backWood, Wood topWood) {
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
			if (searchGuitar.getBuilder() != guitar.getBuilder()) {
				continue;
			}

			String model = searchGuitar.getModel().toLowerCase();
			if ((model != null) && (!model.equals(""))
					&& (!model.equals(guitar.getModel().toLowerCase()))) {
				continue;
			}

			if (searchGuitar.getType() != guitar.getType()) {
				continue;
			}

			if (searchGuitar.getBackWood() != guitar.getBackWood()) {
				continue;
			}

			if (searchGuitar.getTopWood() != guitar.getTopWood()) {
				continue;
			}
		}

		return null;
	}
}
