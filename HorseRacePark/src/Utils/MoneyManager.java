package Utils;

import java.util.HashMap;

/**
 * 
 * @author mmankala
 * 
 * MoneyManager class is the facade utils to work with any operations on the money data structure (hashmap moneyHashMap)
 */
public class MoneyManager {
	//final denomination sequence to be used
	private final Integer[] denominationSequence = {100, 20, 10, 5, 1};
	//money hashmap
	private HashMap<Integer, Integer> moneyHashMap = new HashMap<Integer, Integer>();
	//money hashmap
	private HashMap<Integer, Integer> dispenseHashMap;
	//cashLeft
	private int cashLeft;
	
	/**
	 * Constructor to initialize the data for MoneyManager object to start work with
	 */
	public MoneyManager() {
		for(int denomination: denominationSequence) {
			moneyHashMap.put(denomination, 10);
		}
		getCashLeft();
	}
	
	/**
	 * method to print the denomination list of moneyHashMap (init money object we work with)
	 */
	public void printDenominationList() {
		System.out.println("Inventory: ");
		for(int i = denominationSequence.length - 1; i >= 0; i--) {
			System.out.println("$" + denominationSequence[i] + "," + (moneyHashMap.get(denominationSequence[i]) != null ? moneyHashMap.get(denominationSequence[i]) : 0));
		}
	}

	/**
	 * method to print the denomination list of any money hash map we might pass
	 */
	public void printDenominationList(HashMap<Integer, Integer> moneyMap) {
		System.out.println("Dispensing:");
		for(int i = denominationSequence.length - 1; i >= 0; i--) {
			System.out.println("$" + denominationSequence[i] + "," + (moneyMap.get(denominationSequence[i]) != null ? moneyMap.get(denominationSequence[i]) : 0));
		}
	}
	
	/**
	 * This method is responsible for ejecting the money passed to the method
	 * The invoker should ensure amt is dispensable by the moneyMgr
	 * if invoker does decide to invoke the method using amt > cashLeft, an empty hashmap will be returned
	 */
	public HashMap<Integer, Integer> ejectMoney(Integer amt) {
		int currAmt = amt;
		dispenseHashMap = new HashMap<Integer, Integer>();
		if (cashLeft >= amt) {
			for(int i = 0; i < denominationSequence.length; i++) {
				int denomination = denominationSequence[i],
				 	quantity = moneyHashMap.get(denomination),
				 	numberOfBills = currAmt / denomination;
				
				if (numberOfBills > quantity) {
					numberOfBills = quantity;
				}
				if(numberOfBills > 0) {
					dispenseHashMap.put(denomination, numberOfBills);
					moneyHashMap.put(denomination, quantity - numberOfBills);
				}
				
				currAmt -= denomination * numberOfBills;
			}
		}
		
		return dispenseHashMap;
	}

	/**
	 * @return the cashLeft
	 */
	public int getCashLeft() {
		int cash = 0;
		for(int denomination: denominationSequence) {
			Integer leftCount = moneyHashMap.get(denomination);
			if (leftCount != null) {
				cash += (denomination * leftCount);
			}
		}
		this.cashLeft = cash;
		return cash;
	}
}
