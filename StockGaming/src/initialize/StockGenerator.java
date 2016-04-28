package initialize;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class StockGenerator {

	public static HashMap<String,StockObject> sb = new HashMap<String,StockObject> ();
	private static  boolean oneStopSpam = false;
	private static void createOneStopStocks()
	{
		ArrayList<String> First = new ArrayList<String>();
		ArrayList<String> Medium = new ArrayList<String>();
		ArrayList<String> Names = new ArrayList<String>();
		
		try {
			FileInputStream ft = new FileInputStream("\\StockGenerator\\StockFeeds");
			InputStreamReader rd = new InputStreamReader (ft,Charset.forName("UTF-8"));
			BufferedReader br = new BufferedReader (rd);
			
			String line = br.readLine();
			
			line = line.substring(line.indexOf('='),line.length()-1);
			
			for(String feed:line.split(","))
				First.add(feed);
			
			line = br.readLine();
			line = line.substring(line.indexOf('='),line.length()-1);
			
			for(String feed:line.split(","))
				Medium.add(feed);
				
			line = br.readLine();
			line = line.substring(line.indexOf('='),line.length()-1);
			for(String feed:line.split(","))
				Names.add(feed);
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int limit =StockConfig.StockLimit;
		while(limit -- > 0)
		{
			String newStock = First.get((int) (Math.random()*(First.size()-1)))+Medium.get((int) (Math.random()*(Medium.size()-1)))+Names.get((int) (Math.random()*(Names.size()-1)));
			sb.put(newStock,new StockObject(newStock,StockConfig.stockIndex++));
		}
		
	}
	public static StockObject SpamAStock()
	{
		if(!oneStopSpam){
			
			createOneStopStocks();
			
		}
		Set<String> keys  = sb.keySet();
		
		Iterator<String> key = keys.iterator();
		
		if(key !=null )
		{
			StockObject obj = sb.get(key);
			sb.remove(key);
			
			return obj;
			
		}
		
		return null;
			
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(SpamAStock());
	}

}
