package initialize;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DerbyInitializedEntry implements initializeEntry{

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private void createStocks(Statement st)
	{
		String sql = "";
		
	}
	@Override
	public void create()  {
		// TODO Auto-generated method stub
		try {
			
			DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
			Connection conn = DriverManager.getConnection("jdbc:derby:myDB;create=true");
			
			Statement st = conn.createStatement();
			String sql = "CREATE TABLE StocksRegister (NAME VARCHAR 32) NOT NULL,StockIndex VARCHAR(50) NOT NULL)";
			st.execute(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void drop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerNew() {
		// TODO Auto-generated method stub
		
	}

}
