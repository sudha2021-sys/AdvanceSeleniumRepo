package DDTPractice;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ReadingJSONFile {


	
		public static void main(String[] args) throws IOException, ParseException, org.json.simple.parser.ParseException {
			JSONParser parser=new JSONParser();
			FileReader file=new FileReader("C:\\Users\\sudha\\eclipse-workspace\\newjavaproject\\src\\sudha\\AdvanceSeleniumPractice\\src\\test\\resources\\stuData.json");
			Object javaObj = parser.parse(file);
			
			JSONObject obj=(JSONObject)javaObj;
			String name = obj.get("name").toString();
			String id = obj.get("id").toString();
			String branch = obj.get("branch").toString();
			String age = obj.get("age").toString();
			String IsStudent = obj.get("IsStudent").toString();
			Object IsStudent1 = obj.get("IsStudent");
			Object backlog = obj.get("backlog");
			System.out.println(name);
			System.out.println(id);
	
			System.out.println(branch);
			System.out.println(age);
			System.out.println(IsStudent);
			System.out.println(IsStudent1);
			System.out.println(backlog);
			
			
			
		}

	
	 
	

}
