package pirent.demo.guitarshop.chapter1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import pirent.demo.guitarshop.chapter1.enhancement.Builder;
import pirent.demo.guitarshop.chapter1.enhancement.GuitarSpec;
import pirent.demo.guitarshop.chapter1.enhancement.Type;
import pirent.demo.guitarshop.chapter1.enhancement.Wood;

public class Inventory {

	private List guitars;

	public Inventory() {
		guitars = new LinkedList();
	}

	public void addGuitar(String serialNumber, double price, Builder builder,
			String model, Type type, Wood backWood, Wood topWood) {
		Guitar guitar = new Guitar(serialNumber, price, new GuitarSpec(builder, model, type, backWood, topWood));
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
	 * 
	 * @param searchGuitar
	 * @return
	 */
	public List seach(GuitarSpec searchSpec) {
		List result = new ArrayList();
		for (Iterator it = guitars.iterator(); it.hasNext();) {
			Guitar guitar = (Guitar) it.next();
			GuitarSpec guitarSpec = guitar.getSpec();

			// Ignore serial number because it is unique
			// Ignore price since that's unique
			if (searchSpec.getBuilder() != guitarSpec.getBuilder()) {
				continue;
			}

			String model = searchSpec.getModel().toLowerCase();
			if ((model != null) && (!model.equals(""))
					&& (!model.equals(guitarSpec.getModel().toLowerCase()))) {
				continue;
			}

			if (searchSpec.getType() != guitarSpec.getType()) {
				continue;
			}

			if (searchSpec.getBackWood() != guitarSpec.getBackWood()) {
				continue;
			}

			if (searchSpec.getTopWood() != guitarSpec.getTopWood()) {
				continue;
			}
			result.add(guitar);
		}

		return result;
	}
}
