package Model;

public class Horse {
	//horse name
	private String name;
	//odds
	private int odds;
	//winning
	private boolean winning;
	//constructor to create a horse object
	public Horse(String name, int odds) {
		this.name = name;
		this.odds = odds;
	}
	//constructor to create a winning horse object
	public Horse(String name, int odds, boolean winning) {
		this.name = name;
		this.odds = odds;
		this.winning = winning;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the odds
	 */
	public int getOdds() {
		return odds;
	}
	/**
	 * @param odds the odds to set
	 */
	public void setOdds(int odds) {
		this.odds = odds;
	}
	/**
	 * @return the winning
	 */
	public boolean isWinning() {
		return winning;
	}
	/**
	 * @param winning the winning to set
	 */
	public void setWinning(boolean winning) {
		this.winning = winning;
	}
}
