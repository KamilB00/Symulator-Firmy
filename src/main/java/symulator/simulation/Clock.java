package symulator.simulation;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class Clock {

    private static Clock instance = new Clock();


    private Clock(){}


    private Date getDateFromMilis(Long mili){
        return Date.from(Instant.ofEpochMilli(mili));
    }
    public static Clock getInstance(){
        Calendar.getInstance().getTimeInMillis();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, 5);
        Date  date = cal.getTime();


        return instance;
    }


}
