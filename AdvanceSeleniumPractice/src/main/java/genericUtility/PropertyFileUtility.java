package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {
	public String readingDataFromPropFile(String Key) throws IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\sudha\\eclipse-workspace\\newjavaproject\\src\\sudha\\AdvanceSeleniumPractice\\src\\test\\resources\\commonData.properties");
	Properties prop=new Properties();
	prop.load(fis);
	String data=prop.getProperty(Key);
	return data;
	}

}
