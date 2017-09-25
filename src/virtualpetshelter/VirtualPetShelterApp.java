package virtualpetshelter;

import java.util.Random;
import java.util.Scanner;

public class VirtualPetShelterApp {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		VirtualPetShelter shelter = new VirtualPetShelter();

		// random starting pet names | description | stats
		String rndPNames [] = {"Penny", "Beezle", "Jaeger", "Billy", "Scotty", "Selene", "Mitth", "Buddy", "Tiber","Jim", "Kelly", "Jade", "Amber", "Mordecai", "Gordon"}; 
		String rndPDesc [] = {"is distracted by a bee.", "looks like they're having a great time!", "is feeling lazy today.", "is excited today.", "wants a new toy.", "looks a little down.", "looks happy to see you.", "is rolling around in the dirt.", "is chewing on toy.", "is giving you a puzzled look.", "is licking themself.", "looks agitated and scared.", "is fighting with another pet."}; 
		int rndStat [] = {21,45,25,73,67,88,71,49,42,37,10,100,1,20,57,94,60,50,40,30,17,9};
		
		
		// Initial pets 1-6
		VirtualPet pet1 = new VirtualPet(rndPNames[new Random().nextInt(rndPNames.length)], rndPDesc[new Random().nextInt(rndPDesc.length)], rndStat[new Random().nextInt(rndStat.length)], rndStat[new Random().nextInt(rndStat.length)], rndStat[new Random().nextInt(rndStat.length)]);
		shelter.newPet(pet1);
		VirtualPet pet2 = new VirtualPet(rndPNames[new Random().nextInt(rndPNames.length)],rndPDesc[new Random().nextInt(rndPDesc.length)], rndStat[new Random().nextInt(rndStat.length)], rndStat[new Random().nextInt(rndStat.length)], rndStat[new Random().nextInt(rndStat.length)]);
		shelter.newPet(pet2);
		VirtualPet pet3 = new VirtualPet(rndPNames[new Random().nextInt(rndPNames.length)], rndPDesc[new Random().nextInt(rndPDesc.length)], rndStat[new Random().nextInt(rndStat.length)], rndStat[new Random().nextInt(rndStat.length)], rndStat[new Random().nextInt(rndStat.length)]);
		shelter.newPet(pet3);
		VirtualPet pet4 = new VirtualPet(rndPNames[new Random().nextInt(rndPNames.length)], rndPDesc[new Random().nextInt(rndPDesc.length)], rndStat[new Random().nextInt(rndStat.length)], rndStat[new Random().nextInt(rndStat.length)], rndStat[new Random().nextInt(rndStat.length)]);
		shelter.newPet(pet4);
		VirtualPet pet5 = new VirtualPet(rndPNames[new Random().nextInt(rndPNames.length)], rndPDesc[new Random().nextInt(rndPDesc.length)], rndStat[new Random().nextInt(rndStat.length)], rndStat[new Random().nextInt(rndStat.length)], rndStat[new Random().nextInt(rndStat.length)]);
		shelter.newPet(pet5);
		VirtualPet pet6 = new VirtualPet(rndPNames[new Random().nextInt(rndPNames.length)], rndPDesc[new Random().nextInt(rndPDesc.length)], rndStat[new Random().nextInt(rndStat.length)], rndStat[new Random().nextInt(rndStat.length)], rndStat[new Random().nextInt(rndStat.length)]);
		shelter.newPet(pet6);
		
		boolean end = false;
		
		System.out.println("\nWelcome to the Pet Emporium: Shelter and Care Centre! Thank you helping out today!");
		
		do {
			System.out.println("\nCurrent status of all pets are: ");
			System.out.println("\nName\t|Hunger\t|Thirst\t|Mood");
			System.out.println("-------------------------------");

			for (VirtualPet currentPet : shelter.pets()) {
				System.out.println(currentPet.name + "\t|" + currentPet.hunger + "\t|" + currentPet.thirst + "\t|"
						+ currentPet.mood + "\t");
			}
			
			System.out.println("\nWhat would you like to do next?");
			System.out.println("\n1. Feed all pets \n2. Water all pets \n3. Feed a single pet \n4. Feed a single pet \n5. Play with a pet \n6. Adopt a pet \n7. Admit a pet \n8. Do nothing \n9. Quit :(");
			String response = input.nextLine();
			switch (response) {
			
			// feed all
			case "1": 
	 			shelter.feedPets();
				System.out.println("You have fed all of the pets.");
				break;
				
			// water all
			case "2": 
				shelter.waterPets();
				System.out.println("You have given water to all pets.");
				break;
				
			// play all
			case "3": 
				shelter.playAll();
				System.out.println("You have a grand ole time with all the pets.");
				break;
				
			// feed individual pet
			case "4":
				System.out.println("Please enter the name of the pet you would like to feed:");
				System.out.println();
				showPets(shelter);
				String petfeed = input.nextLine();
				shelter.feedPet(petfeed);
				System.out.println("You give " + petfeed + " a tastey treat.");
				break;
				
			// play
			case "5": 
				System.out.println("Please enter the name of the pet you want to play with:");
				System.out.println();
				showPets(shelter);
				String petName = input.nextLine();
				shelter.playWith(petName);
				System.out.println("You play with " + petName + " for a time. They seem more happy.");
				break;
				
			// adopt	
			case "6": 
				System.out.println("Which pet are you interested in adopting?");
				showPets(shelter);
				String petAdopt = input.nextLine();
				VirtualPet x = shelter.getPet(petAdopt);
				shelter.adoptPet(x);
				System.out.println("You've adopted " + petAdopt + ". Please take good care of them!");
				break;
				
			// bring in new pet
			case "7": 
				System.out.println("Please enter the name of the new pet: ");
				String name = input.nextLine();
				System.out.println("Please enter the descritpion of the new pet: ");
				String description = input.nextLine();
				VirtualPet nP = new VirtualPet(name, description);
				shelter.newPet(nP);
				System.out.println(nP.getName() + "has been succesfully admitted! We will be sure to take good care of them.");
				break;
				
			// do nothing
			case "8": 
				break;
				
			// quit
			case "9": 
				System.out.println("Be sure to stop by and volunteer again!");
				System.exit(0);
			
			default:
				System.out.println("Error: does not compute! Please try again!");
				break;
			}
			shelter.tick();

		} while (!end);
		input.close();
	}

	private static void showPets(VirtualPetShelter s) {
		for (VirtualPet currentPet : s.pets()) {
			System.out.println(currentPet);
		}
	}
}
