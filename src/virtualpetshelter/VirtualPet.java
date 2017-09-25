package virtualpetshelter;


public class VirtualPet {

	  String name;
	  String description;
	  int hunger;
	  int thirst;
	  int mood;
	
	public VirtualPet(String petName, String petDescription) {
		name = petName;
		description = petDescription;
		hunger = 50;
		thirst = 50;
		mood = 50;
		
	}
	
	public VirtualPet(String petName, String petDescription, int petHunger, int petThirst, int petMood) {
		name = petName;
		description = petDescription;
		hunger = petHunger;
		thirst = petThirst;
		mood = petMood;
	}
	
	public void petUpdate() {
		hunger -= 10;
		thirst -= 10;
		mood -= 5;
	}
	
	//pet name
	public String getName() {
		return name;
	}
	
	//pet hunger | feed
	public int getHunger() {
		return hunger;
	}
	
	public void feed() {
		hunger += 45;
		thirst -= 10;
	}
	
	// thirst | drink
	public int getThirst() {
		return thirst;
	}
	public void drink() {
		thirst += 45;
		hunger -= 5;
	}

	// pet mood | play
	public int getMood() {
		return mood;
	}
	public void play() {
		mood += 50;
		hunger -= 5;
		thirst -= 5;
	}
	
	@Override
	public String toString() {
		return (name + " " + description); 
	}


}
