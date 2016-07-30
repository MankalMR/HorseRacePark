package Utils;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

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
	public void UserInputToSetWinningInvalidHorseNumber() {
		hrpStarter.setInput("W 10");
		if (3 == hrpStarter.getInputType()) {
			HorseManager horseMgr = new HorseManager();
			assertFalse(horseMgr.isValidHorseNumber(10));
		} else {
			fail();
		}
	}
	
	@Test
	public void UserInputToSetBidOnHorse() {
		hrpStarter.setInput("1 125");
		assertEquals(4, hrpStarter.getInputType());
	}
	
	@Test
	public void UserInputToSetBidOnInvalidHorse() {
		hrpStarter.setInput("10 125");
		if (4 == hrpStarter.getInputType()) {
			HorseManager horseMgr = new HorseManager();
			assertFalse(horseMgr.isValidHorseNumber(10));
		} else {
			fail();
		}
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
	
	@Test
	public void UserInputEmpty() {
		hrpStarter.setInput("");
		assertEquals(6, hrpStarter.getInputType());
	}

}
