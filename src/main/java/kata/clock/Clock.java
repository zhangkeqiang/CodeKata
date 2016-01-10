package kata.clock;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Clock {
	Date time;
	int offset_UTC;
	public Clock(int offset_UTC) {
		this.offset_UTC = offset_UTC;
	}

	public String getTime() {
		Date utctime = UTCTimer.getUTCTimer().getUTCTime();
		Calendar cal=Calendar.getInstance(); 
		cal.setTime(utctime);
		cal.add(Calendar.HOUR, offset_UTC);
		time = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		String retTime = sdf.format(time);
		return retTime;
	}

}
