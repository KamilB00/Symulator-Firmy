package symulator.simulation;

import java.time.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class SimulationClock {

    private Integer years;

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }
public SimulationClock(){
        setYears(years);
}

    public int weeks = 0;
    public int simulationTime() {

        Date date = new Date();
        Calendar calendarCurrent = new GregorianCalendar();

        calendarCurrent.setTime(date);
        int year = calendarCurrent.get(Calendar.YEAR);
        int month = calendarCurrent.get(Calendar.MONTH);
        int day = calendarCurrent.get(Calendar.DAY_OF_MONTH);
        int hour = calendarCurrent.get(Calendar.HOUR);
        int minute = calendarCurrent.get(Calendar.MINUTE);
        int second = calendarCurrent.get(Calendar.SECOND);

        Calendar calendarFuture = new GregorianCalendar(year + getYears(), month, day);
        Calendar oneMonth = new GregorianCalendar(year, month + 1, day, hour + 12, minute, second);
        Calendar oneDay = new GregorianCalendar(year, month, day + 1, hour + 12, minute, second);
        long duration = calendarFuture.getTimeInMillis() - calendarCurrent.getTimeInMillis();
        long oneMonthMilis = oneMonth.getTimeInMillis() - calendarCurrent.getTimeInMillis();
        long oneDayMilis = oneDay.getTimeInMillis() - calendarCurrent.getTimeInMillis();



        for (long m = calendarCurrent.getTimeInMillis(); m < calendarFuture.getTimeInMillis(); m += (7 * oneDayMilis)) {
            weeks++;
        }
       return weeks;
    }
}



