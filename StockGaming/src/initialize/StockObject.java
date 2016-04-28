package initialize;

public class StockObject {

	public final String name;
	public final int index;
	enum StockStatus{On,Off};
	private StockStatus status;
	public StockObject(String s1,int stockindex)
	{
		name = s1;
		index = stockindex;	
	}
	
	public void setOnlineStatus(StockStatus st)
	{
		status = st;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		sb.append(name);
		sb.append("\\");
		sb.append(index);
		return sb.toString();
		
	}

}
