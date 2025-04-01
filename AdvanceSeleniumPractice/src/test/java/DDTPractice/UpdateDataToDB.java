package DDTPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class UpdateDataToDB {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
				
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Ninza_pro","root","tiger");
				
		Statement stmt=conn.createStatement();
		 int result = stmt.executeUpdate("update  ninza_crmDetails set uname='admin' where password='tiger'");
		if(result !=0)
		{
			System.out.println("data updates suceessfully");
			
		}
		else
		{
			System.out.println("operation failed");
		}
		conn.close();
		}
}

		
