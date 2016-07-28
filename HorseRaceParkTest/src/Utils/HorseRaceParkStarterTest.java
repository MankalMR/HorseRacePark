package Utils;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class HorseRaceParkStarterTest {
	
	HorseRacePark hrpStarter;
	
	@BeforeClass
	public static void before() {
	}
	
	@AfterClass
	public static void after() {
		
	}
	
	@Before
	public void setup() {
		hrpStarter = new HorseRacePark();
	}
	
	@After
	public void tearDown() {
		
	}
	
	@Test
	public void UserInputToQuitApplication() {
		hrpStarter.setInput("q");
		assertEquals(1, hrpStarter.getInputType());
	}
	
	@Test
	public void UserInputToResetApplicationData() {
		hrpStarter.setInput("R");
		assertEquals(2, hrpStarter.getInputType());
	}
	
	@Test
	public void UserInputToSetWinningHorse() {
		hrpStarter.setInput("W 5");
		assertEquals(3, hrpStarter.getInputType());
	}
	
	@Test
	public void UserInputToSetBidOnHorse() {
		hrpStarter.setInput("1 125");
		assertEquals(4, hrpStarter.getInputType());
	}
	
	@Test
	public void UserInputToSetInvalidBidOnHorse() {
		hrpStarter.setInput("4 10.25");
		assertEquals(5, hrpStarter.getInputType());
	}
	
	@Test
	public void UserInputInvalidCommand() {
		hrpStarter.setInput("f 10.25");
		assertEquals(0, hrpStarter.getInputType());
	}

}
