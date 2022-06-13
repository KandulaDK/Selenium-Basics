package JavaCollections;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateCalDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date d = new Date();
		System.out.println(d.toString());
		SimpleDateFormat sdf = new SimpleDateFormat("d/M/yyyy");
		SimpleDateFormat sd = new SimpleDateFormat("d/M/yyyy hh:mm:ss");
		System.out.println(sdf.format(d));
		System.out.println(sd.format(d));
		
		
		Calendar cal =Calendar.getInstance();
		SimpleDateFormat cdf = new SimpleDateFormat("d/M/yyyy");
		System.out.println(cdf.format(cal.getTime()));
		System.out.println(cal.get(Calendar.AM_PM));
		
	}

}
