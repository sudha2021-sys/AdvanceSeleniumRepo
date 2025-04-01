package genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	Connection conn;
	
	public void getDBConnection(String url,String uname,String password)
	{
		try
		{
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			conn=DriverManager.getConnection(url, uname, password);
			
		}
		catch(Exception e)
		{
			System.out.println("connection not established");
	}
	}
	
		public void closeDBConnection()
		{
			try
			{
				conn.close();
			}
				catch(Exception e)
				{
			}
		}
		public ResultSet executeSelectQuery(String query)
		{
			ResultSet result=null;
			try
			{
				Statement stmt=conn.createStatement();
				result=stmt.executeQuery(query);
			}
			catch(Exception e)
			{
				
			}
			return result;
		}
		public int executeNonSelectQuery(String query)
		{
			int result=0;
			try
			{
				Statement stmt=conn.createStatement();
				result=stmt.executeUpdate(query);
			}
			catch(Exception e)
			{
				
			}
			return result;
		}
	}


