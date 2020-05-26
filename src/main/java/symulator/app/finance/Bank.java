package symulator.app.finance;

import java.util.Random;

public class Bank {
    private double amount;
    private double interest;
    private Integer installments;

    /**
     *Kwota do zwrotu
     */
    public double returnAmount(){
        Double returnAmount = getAmount()*generatePercentage();
        return returnAmount;
    }

    /**
     *  Funkcja do Generowanie  oprocentowania
     */
    public double generatePercentage(){
        Random rand = new Random();
        Integer number = rand.nextInt(10)+1;
        Double percentage = (number.doubleValue())/100;
        return percentage;
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





    //TODO TOMEK
    // 1. Generowanie na podstwaie wpisanej kwoty (większej niż 100k) warunków oprocentowania, rat
    // 2. w przypadku opóźnienia naliczanie odsetek  (interest), raty będą automatycznie zwracane przez księgowość, opóźnienie będzie wynikało tylko z niewypłacalności kogoś i wtedy dług się powiększa

}
