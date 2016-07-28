package Utils;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MoneyManagerTest {
	
	MoneyManager moneyMgr;
	
	@Before
	public void setUp() {
		moneyMgr = new MoneyManager();
	}
	
	@After
	public void tearDown() {
		moneyMgr.printDenominationList();
	}
	
	@Test
	public void TestForFindingTotalAmount() {
		assertEquals(1360, moneyMgr.getCashLeft());
	}
	
	@Test
	public void TestForFindingTotalAmountRemainingAfterEjectingSomeAmount() {
		moneyMgr.ejectMoney(359);
		assertEquals(1001, moneyMgr.getCashLeft());
	}

}
