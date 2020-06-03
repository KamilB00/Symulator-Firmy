package symulator.app.finance;

public class Investor{

    private static Investor instance = null;
    private Investor(){}
    public static Investor getInstance(){
        if(instance==null)
            instance = new Investor();
        return instance;
    }

    private double offeredAmount;
   private double yearProfit;
   private double time;


    public void setYearProfit(double yearProfit) {

        this.yearProfit = yearProfit;
        System.out.println("Investor year profit --> " + yearProfit);
    }

    public void setTime(double time) {

        this.time = time;
        System.out.println("Investor time --> "+ time);
    }

    public double getTime() {
        return time;
    }

    public double getYearProfit() {
        return yearProfit;
    }

    public void setOfferedAmount(double offeredAmount) {
        System.out.println("Offered amount --> "+ offeredAmount);
        this.offeredAmount = offeredAmount;
    }

    public double getOfferedAmount() {
        return offeredAmount;
    }

}


