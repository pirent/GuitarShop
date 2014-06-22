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

	public void addGuitar(String serialNumber, double price, GuitarSpec spec) {
		Guitar guitar = new Guitar(serialNumber, price, spec);
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
			if (guitarSpec.equals(searchSpec)) {
				result.add(guitar);
			}
		}

		return result;
	}
}
