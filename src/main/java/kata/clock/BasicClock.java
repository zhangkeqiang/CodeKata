package kata.clock;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class BasicClock {
	private Date time;
	private int offset_UTC;
	public BasicClock(int offset_UTC) {
		this.offset_UTC = offset_UTC;
	}

	public void setTime(String time) {		
		Date utctime;
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("hh:mm:ss",java.util.Locale.CHINA);
		try {
			this.time = sdf.parse(time);
		} catch (ParseException e) {			
			e.printStackTrace();
			this.time = new Date();
		}
		Calendar cal=Calendar.getInstance(); 
		cal.setTime(this.time);
		cal.add(Calendar.HOUR, -offset_UTC);
		utctime = cal.getTime();
		UTCTimer.getUTCTimer().setUTCTime(utctime);
	}
	
}
