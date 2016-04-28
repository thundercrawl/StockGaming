package initialize;
/*
 * Use DB to store the current Stocks
 */

public class StockSpam {

	
	private initializeEntry entry;
	public StockSpam(initializeEntry en)
	{
		entry = en;
		
	}
	
	public void createSpamSource()
	{
		entry.create();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StockSpam sp = new StockSpam(new DerbyInitializedEntry());
		sp.createSpamSource();
		
	}

}
