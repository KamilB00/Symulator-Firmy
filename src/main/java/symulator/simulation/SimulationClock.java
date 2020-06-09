package symulator.simulation;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class SimulationClock {

    private Integer simulationYears = 1;

    public Integer getYears() {
        System.out.println("get years --> "+simulationYears);
        return simulationYears;

    }

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
    private SimulationClock(){
    }

    Date date = new Date();
    Calendar calendarCurrent = new GregorianCalendar();
    private int weeks = 0;
    public int simulationTime() {

       calendarCurrent.setTime(date);

        Integer year = calendarCurrent.get(Calendar.YEAR);
        Integer month = calendarCurrent.get(Calendar.MONTH);
        Integer day = calendarCurrent.get(Calendar.DAY_OF_MONTH);
        Integer hour = calendarCurrent.get(Calendar.HOUR);
        Integer minute = calendarCurrent.get(Calendar.MINUTE);
        Integer second = calendarCurrent.get(Calendar.SECOND);

        Calendar calendarFuture = new GregorianCalendar(year + getYears(), month, day);
        Calendar oneDay = new GregorianCalendar(year, month, day + 1, hour+12, minute, second);
        long duration = calendarFuture.getTimeInMillis() - calendarCurrent.getTimeInMillis();
        long oneDayMilis = oneDay.getTimeInMillis() - calendarCurrent.getTimeInMillis();


        for (long m = calendarCurrent.getTimeInMillis(); m < calendarFuture.getTimeInMillis(); m += (7 * oneDayMilis)) {
            weeks++;
        }
       return weeks;
    }
    public Date timeUpdate(int tick){
        calendarCurrent.set(calendarCurrent.get(Calendar.DAY_OF_MONTH), calendarCurrent.get(Calendar.MONTH),calendarCurrent.get(Calendar.YEAR));
      Integer days = calendarCurrent.get(Calendar.DAY_OF_MONTH)+tick*7;
      calendarCurrent.set(days,calendarCurrent.get(Calendar.MONTH),calendarCurrent.get(Calendar.YEAR));
        return calendarCurrent.getTime();

    }
}



