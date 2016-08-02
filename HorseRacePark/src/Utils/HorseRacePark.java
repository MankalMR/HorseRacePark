package Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Model.Horse;


public class HorseRacePark {
	//regex for identifying valid setting horse winning format
	private final String SET_WINNER_REGEX = "(?i)^[w]\\s\\d+$";
	//regex for identifying valid bet on a horse
	private final String SET_BID_REGEX = "^\\d+\\s\\d+";
	//regex for identifying invalid bet amount on a horse
	private final String INVALID_BID_REGEX = "^\\d+\\s\\d+.\\d+$";
	//reset 
	private final String RESET = "r";
	//quit
	private final String QUIT = "q";
	//input stream buffer
	private BufferedReader br;
	//user's input line
	private String input;
	
	/**
	 * empty constructor to help with instansiation in test classes
	 */
	public HorseRacePark() {
		
	}
	
	/**
	 * contructor to set input stream on the object
	 * @param inStream
	 */
	public HorseRacePark(InputStream inStream) {
		this.br = new BufferedReader(new InputStreamReader(inStream));
	}
	
	/**
	 * fetch the line of input stream
	 */
	public void fetchInput() {
		try {
			this.input =  br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @return the input
	 */
	public String getInput() {
		return input;
	}
	
	
	/**
	 * @return the input
	 */
	public void setInput(String input) {
		this.input = input;
	}
	
	/**
	 * isValidInput method is responsible for reporting back with a code 
	 * based on which consumer of this method would know if its valid input
	 * 
	 * 1: user quits 'q'/'Q'
	 * 2: user resets/reinitializes application data 'r'/'R'
	 * 3: valid pattern for setting winning horse
	 * 4: valid pattern for placing bid, but invalid bet placed
	 * 5: valid pattern for placing bid, and valid bet placed
	 * 0: invalid entry
	 */
	public int getInputType () {
		Matcher winMatcher = Pattern.compile(SET_WINNER_REGEX).matcher(input);
		Matcher bidMatcher = Pattern.compile(SET_BID_REGEX).matcher(input);
		Matcher invalidBidMatcher = Pattern.compile(INVALID_BID_REGEX).matcher(input); 
		int inputType;
		if (QUIT.equalsIgnoreCase(input)) { //user input to quit application
			inputType = 1;
		} else if (RESET.equalsIgnoreCase(input)) { //user input to reset application data
			inputType = 2;
		} else if (winMatcher.matches()){ //pattern match for setting winning horse
			inputType = 3;
		} else if (bidMatcher.matches()) { //pattern match for setting bid
			inputType = 4;
		} else if (invalidBidMatcher.matches()) { //pattern match for invalid decimal input as bet
			inputType = 5;
		} else if ("".equals(input.trim())) { //check for empty string
			inputType = 6;
		} else {
			inputType = 0;
		}
		return inputType;
	}
	
	/**
	 * init() initiate the HorseRacePark application and utilize 
	 * various Util managers to handle input variations
	 */
	public void init() {
		HorseManager horseMgr = new HorseManager();
		MoneyManager moneyMgr = new MoneyManager();
		int inputType;
		while (true) { //always true loop
			//print inventory
			moneyMgr.printDenominationList();
			//print horse list to bet on
			horseMgr.printHorsesList();
			
			//fetch user's inout from the stream
			fetchInput();
			inputType = getInputType();
			int betHorse, betAmt;
			
			switch (inputType) {
				case 0: //just an invalid command
						System.out.println("Invalid Command: " + getInput()); 
						break;
				case 1: //user asked for exit
						System.out.println("Exiting Horse Race Park Application!!!"); 
						System.exit(0);
						break;
				case 2: //user asked for the reset to happen
						horseMgr = new HorseManager();
						moneyMgr = new MoneyManager();
						break;
				case 3: //try setting the winning horse number
						betHorse = Integer.parseInt(getInput().split(" ")[1]);
						if (horseMgr.isValidHorseNumber(betHorse)) {
							horseMgr.setWinningHorse(Integer.parseInt(getInput().split(" ")[1]));
						} else {
							System.out.println("Invalid Horse Number: " + betHorse);
						}	
						break;
				case 4: //try setting the bet on a horse and get payout if you win
						betAmt = Integer.parseInt(getInput().split(" ")[1]);	
						betHorse = Integer.parseInt(getInput().split(" ")[0]);
						Horse winningHorse = horseMgr.getWinningHorse();
						if (horseMgr.isValidHorseNumber(betHorse)) {
							if (horseMgr.getWinningHorseNumber() != betHorse) {
								System.out.println("No Payout: " + horseMgr.getHorse(betHorse).getName());
							} else {
								int amtToDispense = winningHorse.getOdds() * betAmt;
								if (moneyMgr.getCashLeft() >= amtToDispense) {
									System.out.println("Payout: " + winningHorse.getName() + ", $" + amtToDispense);
									moneyMgr.printDenominationList(moneyMgr.ejectMoney(amtToDispense));						
								} else {
									System.out.println("Insufficient Funds: $" + amtToDispense);
								}
							}
						} else {
							System.out.println("Invalid Horse Number: " + betHorse);
						}
						break;
				case 5: //invalid bid placed
						System.out.println("Invalid Bet: " + getInput().split(" ")[1]);
						break;
				case 6: //do nothing
						break;
			}
		}
	}
}
