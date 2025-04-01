package DDTPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class WritingDataToDB {

	public static void main(String[] args) throws SQLException {
		Driver driverRef=new Driver();
DriverManager.registerDriver(driverRef);
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Ninza_pro","root","tiger");
		
Statement stmt=conn.createStatement();
 int result = stmt.executeUpdate("insert into  ninza_crmDetails values('edge','//49.249.28.218:8098/','scott','tiger')");
 int result1 = stmt.executeUpdate("insert into  ninza_crmDetails values('edge','//49.249.28.218:8098/','scott','scott')");
 if(result !=0)
{
	System.out.println("data stored suceessfully");
	
}
else
{
	System.out.println("operation failed");
}
 if(result1 !=0)
 {
 	System.out.println("data stored suceessfully");
 	
 }
 else
 {
 	System.out.println("operation failed");
 }
conn.close();
}
}
