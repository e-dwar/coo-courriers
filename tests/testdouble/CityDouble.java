package testdouble;

import java.util.ArrayList;

import city.City;
import city.Inhabitant;

public class CityDouble extends City {

	public CityDouble(String name) {
		super(name);
	}

	public ArrayList<Inhabitant> getInhabitants() {
		return this.inhabitants;
	}

}
