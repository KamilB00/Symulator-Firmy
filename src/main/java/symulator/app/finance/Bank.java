package symulator.app.finance;

import symulator.simulation.Randomise;

import java.util.Random;

public class Bank {
    private double amount;
    private double interest;
    private Integer installments;


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
        System.out.println("Ustawiono kwotę: -->"+ getAmount());
    }

    public double getAmount() {
        return amount;
    }

    public void setInstallments(Integer installments) {
        this.installments = installments;
        System.out.println("Ustawiono raty: -->"+ getInstallments());
    }

    public Integer getInstallments() {
        return installments;
    }

}
