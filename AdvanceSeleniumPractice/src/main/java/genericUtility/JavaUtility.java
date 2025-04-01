package genericUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	
	public int getRandumNum(int limit)
	
	{
		Random ranNum=new Random();
		int data = ranNum.nextInt(limit);
		return data;
		
		
	}
	public String generateReqdate(int days)
	{
		
		Date dateobj=new Date();
	       SimpleDateFormat sim=new SimpleDateFormat("dd-MM-yyyy");
	       String todayDate = sim.format(dateobj);
	      
		 Calendar cal=sim.getCalendar();
	       cal.add(Calendar.DAY_OF_MONTH,10);
	       String closeDate = sim.format(cal.getTime());
	       return closeDate;
	}
}
