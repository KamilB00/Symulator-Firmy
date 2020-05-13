package symulator.app.finance;

import java.util.Random;

public class Bank {
    private double amount;
    private double interest;
    private double percentage;
    private double installments;




    public double returnAmount(){
        double calculate = percentage*amount;
        return calculate;
    }

    public void generateCreditConditions(){
        Random rand = new Random();
        Integer years = 10;
        Integer yearsRandom =rand.nextInt(years);
        System.out.println("wygenerowana liczba lat: "+yearsRandom);

    }

    //TODO TOMEK
    // 1. Generowanie na podstwaie wpisanej kwoty (większej niż 100k) warunków oprocentowania, rat
    // 2. w przypadku opóźnienia naliczanie odsetek  (interest), raty będą automatycznie zwracane przez księgowość, opóźnienie będzie wynikało tylko z niewypłacalności kogoś i wtedy dług się powiększa

}
