package symulator.app.finance;

import java.util.Random;

public class VC {
    private double amount = randomAmount();
    private double shares = randomShares();


    //TODO MATEUSZ
    // 1. funkcje randomowe dla udziałów i oferowanej kwoty

    double randomAmount() {
        Random random2 = new Random();
        return (double) (random2.nextInt(10) + 1) * 200000;  //od 200k do 2kk
    }

    double randomShares() {
        Random random3 = new Random();
        return (double) random3.nextInt(21) + 10;   //od 10% do 30%
    }

}
