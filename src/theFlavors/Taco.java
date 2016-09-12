package theFlavors;
public class Taco {

	String type;
	int size;
	float spicyness;
	
	Taco(String tacoType) {
		size = 1;
		type = tacoType;
		spicyness = 0.1f;
	}
	
	void eat() {
		size = 0;
	}
	
	void add() {
		size += 1;
	}
	
	void addHotSauce() {
		spicyness += 0.5;
	}
	
}
