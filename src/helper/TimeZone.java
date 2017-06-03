package helper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeZone {
	
	// 2017-03-21 13:47:21
	
	
	public static String getDateTime() {
		
		DateFormat datetimeFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		Date dateTime = new Date();
		return datetimeFormat.format(dateTime).toString();
	}

}
