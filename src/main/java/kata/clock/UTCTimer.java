package kata.clock;

import java.text.ParseException;
import java.util.Date;

public class UTCTimer {
	private Date time;
	private UTCTimer(){
		//private new 
	}
	private static UTCTimer utc = new UTCTimer();
	
	public static UTCTimer getUTCTimer(){
		return utc;		
	}
	
	public void setUTCTime(Date time){
		this.time = time;
	}
	
	public Date getUTCTime(){
		return this.time;
	}
}
