import Utils.HorseRacePark;

/**
 * 
 * @author mmankala
 * Application Startup
 */
public class Application {
	
	public static void main(String[] args) {
		//Instantiate HorseRacePark application 
		HorseRacePark hrpStarter = new HorseRacePark(System.in);
		//invoke init() on HorseRacePark object to initialize app
		hrpStarter.init();
	}
}
