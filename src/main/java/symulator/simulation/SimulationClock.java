package symulator.simulation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class SimulationClock {

    private Integer simulationYears = 1;



    private static SimulationClock instance = null;

    public static SimulationClock getInstance(){
        if(instance==null)
            instance = new SimulationClock();
        return instance;
    }
    public void setYears(Integer years) {
        this.simulationYears = years;
        System.out.println("set years -->"+ getYears());
    }
    public Integer getYears() {
        return simulationYears;

    }

    private SimulationClock(){
    }

    Date date = new Date();

    private int weeks = 0;
    public int simulationTime() {

        Calendar calendarCurrent = new GregorianCalendar();


       calendarCurrent.setTime(date);

        int year = calendarCurrent.get(Calendar.YEAR);
        int month = calendarCurrent.get(Calendar.MONTH);
        int day = calendarCurrent.get(Calendar.DAY_OF_MONTH);
        int hour = calendarCurrent.get(Calendar.HOUR_OF_DAY);
        int minute = calendarCurrent.get(Calendar.MINUTE);
        int second = calendarCurrent.get(Calendar.SECOND);

        Calendar calendarFuture = new GregorianCalendar(year + getYears(), month, day);
        Calendar oneDay = new GregorianCalendar(year, month, day + 1, hour, minute, second);
        long duration = calendarFuture.getTimeInMillis() - calendarCurrent.getTimeInMillis();
        long oneDayMilis = oneDay.getTimeInMillis() - calendarCurrent.getTimeInMillis();


        for (long m = calendarCurrent.getTimeInMillis(); m < calendarFuture.getTimeInMillis(); m += (7 * oneDayMilis)) {
            weeks++;
        }
       return weeks;
    }

    public Date timeUpdate(int tick){
        Calendar calendarUpdate = new GregorianCalendar();
        Calendar calendarCurrent = new GregorianCalendar();
        calendarCurrent.setTime(date);

        int year = calendarCurrent.get(Calendar.YEAR);
        int month = calendarCurrent.get(Calendar.MONTH);
        int day = calendarCurrent.get(Calendar.DAY_OF_MONTH);
        int hour = calendarCurrent.get(Calendar.HOUR_OF_DAY);
        int minute = calendarCurrent.get(Calendar.MINUTE);
        int second = calendarCurrent.get(Calendar.SECOND);

      calendarUpdate.set(year,month,day+(tick*7),hour,minute,second);


        return calendarUpdate.getTime();
    }
    public String timeFormat(Date calendar){
        DateFormat df = new SimpleDateFormat("dd  MM  yyyy");

        String curDate = df.format(calendar.getTime());
        return curDate;
    }



}



