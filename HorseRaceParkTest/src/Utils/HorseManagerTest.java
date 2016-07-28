package Utils;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Model.Horse;

public class HorseManagerTest {
	HorseManager horseMgr;
	
	@Before
	public void setUp() {
		horseMgr = new HorseManager();
	}
	
	@After
	public void tearDown() {
		horseMgr.printHorsesList();
	}
	
	@Test
	public void TestForReturningTheCorrectWinningHorseNumber() {
		horseMgr.setWinningHorse(3);
		assertEquals(3, horseMgr.getWinningHorseNumber());
	}
	
	@Test
	public void TestForReturningTheCorrectWinningHorse() {
		horseMgr.setWinningHorse(5);
		Horse fifthHorse = new Horse("Real Princess", 3, true);
		assertEquals(fifthHorse.getName(), horseMgr.getWinningHorse().getName());
	}
	
	@Test
	public void TestForInValidHorseNumberInput() {		
		assertFalse(horseMgr.isValidHorseNumber(10));
	}
	
	@Test
	public void TestForValidHorseNumberInput() {		
		assertTrue(horseMgr.isValidHorseNumber(5));
	}

}
