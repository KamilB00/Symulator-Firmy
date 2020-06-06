package symulator.app.finance;

import symulator.simulation.Randomise;

import java.util.Random;

public class Bank {
    private double amount;
    private double interest;
    private Integer installments;

    private static Bank instance = null;
    private Bank(){}
    public static Bank getInstance(){
        if(instance==null)
            instance = new Bank();
        return instance;
    }
    Randomise randomise = Randomise.getInstance();
    /**
     *Kwota do zwrotu
     */
    public double returnAmount(){
        Double returnAmount = getAmount()*randomise.generateBankPercentage();
        return returnAmount;
    }


    public void setAmount(double amount) {
        this.amount = amount;
        System.out.println("Bank Ustawiono kwotę: -->"+ getAmount());
    }

    public double getAmount() {
        return amount;
    }

    public void setInstallments(Integer installments) {
        this.installments = installments;
        System.out.println("Bank Ustawiono raty: -->"+ getInstallments());
    }

    public Integer getInstallments() {
        return installments;
    }

}
