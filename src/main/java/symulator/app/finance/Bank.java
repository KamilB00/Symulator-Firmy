package symulator.app.finance;

import symulator.app.company.Company;
import symulator.simulation.Randomise;

public class Bank {
    private Double amount;
    private Double interest = 0.0;
    private Integer installments;
    private Double returnAmount = 0.0;
    private Double percent;

    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }

    private static Bank instance = null;
    private Bank(){}
    public static Bank getInstance(){
        if(instance==null)
            instance = new Bank();
        return instance;
    }


    public void countReturnAmount(){
               returnAmount=(amount*(1+(getPercent()/100)));
        setReturnAmount(returnAmount);

    }
    public Double countInstallmentPrice(){
        return getReturnAmount() /getInstallments();
    }


    public Double countInterest(){
        return getAmount()*0.05;
    }

    public void setAmount(Double amount) {
        this.amount = amount;

        System.out.println("Bank Ustawiono kwotę: -->"+ getAmount());
    }

    public Double getAmount() {
        return amount;
    }

    public void setInstallments(Integer installments) {
        this.installments = installments;
        System.out.println("Bank Ustawiono raty: -->"+ getInstallments());

    }

    public Integer getInstallments() {
        return installments;
    }

    public Double getInterest() {
        return interest;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }

    public Double getReturnAmount() {
        return returnAmount;
    }

    public void setReturnAmount(Double returnAmount) {
        this.returnAmount = returnAmount;
    }
}
