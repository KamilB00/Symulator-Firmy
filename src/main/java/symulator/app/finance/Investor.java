package symulator.app.finance;

import symulator.app.company.Company;


public class Investor{

    private static Investor instance = null;
    private Investor(){}
    public static Investor getInstance(){
        if(instance==null)
            instance = new Investor();
        return instance;
    }
Company company = Company.getInstance();
    private Double offeredAmount;
   private Double yearProfit;
   private Integer time;



    public void setYearProfit(Double yearProfit) {

        this.yearProfit = yearProfit;
        System.out.println("Investor year profit --> " + yearProfit);
    }

    public void setTime(Integer time) {

        this.time = time;
        System.out.println("Investor time --> "+ time);
    }

    public Integer getTime() {
        return time;
    }

    public Double getYearProfit() {
        return yearProfit;
    }

    public void setOfferedAmount(Double offeredAmount) {
        this.offeredAmount = offeredAmount;
        System.out.println("Offered amount --> "+ getOfferedAmount());
        company.setCompanyBudget(getOfferedAmount());

    }

    public Double getOfferedAmount() {
        return offeredAmount;
    }

}


