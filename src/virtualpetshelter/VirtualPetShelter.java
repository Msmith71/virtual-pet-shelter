package virtualpetshelter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {

	Map<String, VirtualPet> petShelter = new HashMap<String, VirtualPet>(); //instance variable

	public Collection<VirtualPet> pets(){
		return petShelter.values();
	}
	
	public VirtualPet getPet(String name){
		return petShelter.get(name);
	}
	
	// Add new pet
	public void newPet(VirtualPet pet){
		petShelter.put(pet.name, pet);
	}
	
	// pet Adoption
	public void adoptPet(VirtualPet pet){
		petShelter.remove(pet.name);
	}
	
	
	// Basic needs
	public void feedPets(){
		for(VirtualPet currentPet: pets()){
			currentPet.feed();
		}
	}
	
	public void feedPet(String name){
		getPet(name).feed();
	}
	
	public void waterPets(){
		for(VirtualPet currentPet: pets()){
			currentPet.drink();
		}
	}
	public void playWith(String name){
		getPet(name).play();
	}
	
	
	// Update stats
	public void tick() {
		for(VirtualPet currentPet: pets()){
			currentPet.petUpdate();
		}
	}
	
	
	public String toString() {
		return ("" + petShelter.keySet() + petShelter.values()); 
	}
}
