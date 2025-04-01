package DDTPractice;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DDTDatabase {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Ninza_pro","root","tiger");
		
Statement stmt=conn.createStatement();
ResultSet result = stmt.executeQuery("select * from ninza_crmDetails");
while(result.next())
{
	String browser = result.getString(1);
	String url = result.getString(2);
	String uname = result.getString(3);
	String password = result.getString(4);
	
	
	System.out.println(browser+" ");
	System.out.println(url+" ");
	System.out.println(uname+" ");
	System.out.println(password+" ");
	
}

conn.close();
	}

}
 