package Utils;

import java.util.ArrayList;
import java.util.List;

import Model.Horse;

/**
 * 
 * @author mmankala
 * 
 * HorseManager class is the facade utils to work with any operations on the Horse data structure (Horse model)
 */
public class HorseManager {
	private List<Horse> listOfHorses = new ArrayList<Horse>();
	
	/**
	 * constructor to init a list of horses
	 */
	public HorseManager() {
		listOfHorses.add(new Horse("That Darn Gray Cat", 5, true));
		listOfHorses.add(new Horse("Fort Utopia", 10));
		listOfHorses.add(new Horse("Count Sheep", 9));
		listOfHorses.add(new Horse("Ms Traitour", 4));
		listOfHorses.add(new Horse("Real Princess", 3));
		listOfHorses.add(new Horse("Pa Kettle", 5));
		listOfHorses.add(new Horse("Gin Stinger", 6));
	}

	/**
	 * method to print the horse list
	 */
	public void printHorsesList() {
		int i = 1;
		System.out.println("Horses:");
		for(Horse horse: listOfHorses) {
			System.out.println((i++) + "," + horse.getName() + "," + horse.getOdds() + "," + (horse.isWinning() ? "won": "lost"));
		}
	}
	
	/**
	 * method to set the winning horse from the list
	 */
	public void setWinningHorse(int horseNum) {
		//iterate through the list of horses and set all the horses to lost
		for(Horse horse: listOfHorses) {
			horse.setWinning(false);
		}
		//set the winning horse based on user's input
		((Horse) listOfHorses.get(horseNum - 1)).setWinning(true);
	}
	
	/**
	 * method to fetch the winning horse's number
	 */
	public int getWinningHorseNumber() {
		int wonHorse = 0;
		for(Horse horse: listOfHorses) {
			wonHorse++;
			if (horse.isWinning()) {
				break;
			}
		}
		return wonHorse;
	}
	
	/**
	 * method to fetch the winning horse object
	 */
	public Horse getWinningHorse() {
		Horse wonHorse = listOfHorses.get(0);
		for(Horse horse: listOfHorses) {
			if (horse.isWinning()) {
				return horse;
			}
		}
		return wonHorse;
	}
	
	/**
	 * method to fetch requested horse object based on the horseNumber
	 */
	public Horse getHorse(int horseNum) {
		return listOfHorses.get(horseNum - 1);
	}
	
	/**
	 * method to check if horseNumber specified is a valid horse from the horseList or not
	 */
	public boolean isValidHorseNumber(int horseNum) {
		try{
			if (listOfHorses.get(horseNum - 1) != null) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}
}
