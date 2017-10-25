package kata.clock;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Clock {
    public static final String H12NOZERO = "h:mm:ss";
    public static final String H12ZERO = "hh:mm:ss";
    public static final String H24NOZERO = "H:mm:ss";
    public static final String H24ZERO = "HH:mm:ss";
    Date time;
    int offsetOfUTC;
    private String displayFormat = H12ZERO;
    public Clock(int offsetOfUTC) {
        this.offsetOfUTC = offsetOfUTC;
    }

    public String getTime() {
        Date utctime = UTCTimer.getUTCTimer().getUTCTime();
        Calendar cal=Calendar.getInstance(); 
        cal.setTime(utctime);
        cal.add(Calendar.HOUR, offsetOfUTC);
        time = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat(displayFormat);
        return sdf.format(time);
    }

    public void setDisplayFormat(String mode) {
        this.displayFormat = mode;
    }

}
