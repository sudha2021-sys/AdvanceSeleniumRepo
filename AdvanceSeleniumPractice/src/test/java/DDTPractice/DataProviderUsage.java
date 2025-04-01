package DDTPractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderUsage {
@Test(dataProvider = "getdata")
	public void testCase(String firstname,String lastname)
	{
		System.out.println("FirstName"+firstname+" lastName"+lastname);
		
	}

@DataProvider
 public Object[][] getdata()
 {
	 Object[][] arrobj=new Object[3][2];
	 arrobj[0][0]="john";
	 arrobj[0][1]="dev";
	 arrobj[1][0]="rocky";
      arrobj[1][1]="boy";
	 arrobj[2][0]="nikky";
	 arrobj[2][1]="rao";
	 return arrobj;
 }
}
