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


}
