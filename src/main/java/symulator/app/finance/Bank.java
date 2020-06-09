package symulator.app.finance;

import symulator.app.company.Company;
import symulator.simulation.Randomise;

import java.util.Random;

public class Bank {
    private Double amount;
    private Double interest;
    private Integer installments;

    private static Bank instance = null;
    private Bank(){}
    public static Bank getInstance(){
        if(instance==null)
            instance = new Bank();
        return instance;
    }
    Randomise randomise = Randomise.getInstance();
    Company company = Company.getInstance();
    /**
     *Kwota do zwrotu
     */
    public Double returnAmount(){
        Double returnAmount = getAmount()*randomise.generateBankPercentage();
        return returnAmount;
    }
    public Double percent(){
        Double percent = returnAmount()/getAmount();
        return percent;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
        System.out.println("Bank Ustawiono kwotę: -->"+ getAmount());
        company.setCompanyBudget(getAmount());

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


}
