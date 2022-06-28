package resources;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class scheduleDateTime {
	
	public String scheduledatetime(int year,int month,int date,int hour,int minute,int second)
	{
		/*
		 * SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
		 * //03.03.2022 22:42:20 Date date = new Date(); Date afterAdding10Mins = new
		 * Date(timeInSecs + (10 * 60 * 1000));
		 * System.out.println(formatter.format(date)); cl. add(Calendar.MINUTE, 3);
		 */
	     SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
	        Date date1 = new Date();
//	        System.out.println("Current Date " + dateFormat.format(date));

	        // Convert Date to Calendar
	        Calendar c = Calendar.getInstance();
	        c.setTime(date1);
	        // Perform addition/subtraction
	        c.add(Calendar.YEAR, year);
	        c.add(Calendar.MONTH, month);
	        c.add(Calendar.DATE, date);
	        c.add(Calendar.HOUR, hour);
	        c.add(Calendar.MINUTE, minute);
	        c.add(Calendar.SECOND, second);

	        // Convert calendar back to Date
	        Date currentDatePlusOne = c.getTime();

//	        System.out.println("Updated Date " + dateFormat.format(currentDatePlusOne));
	        String scheduleddate=dateFormat.format(currentDatePlusOne);
//	        System.out.println(scheduleddate);
	        
	        return scheduleddate;
	}

}
