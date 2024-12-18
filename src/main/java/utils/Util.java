package utils;

import java.util.Date;

public class Util {
	
	public static String  EmailWithDateTimeStamp() {
		Date date = new Date();
		String timeStamp = date.toString().replace(" ","_").replace(":","_");
		return "yucelselenium" + timeStamp + "@gmail.com";
		
	}

}
