package symulator.app.finance;

import java.util.Random;

public class Investor{
  // private double amount = randomAmount();
   private double yearProfit;
   private double time;


   //TODO MATEUSZ
   // 1. funkcjie Randomowe dla czasu w latach
   // 2. funcje randomowe dla kwoty oferowanej przez inwestora
   // 3. funkcje randomowe dla yearProfit w procentach


    public void setYearProfit(double yearProfit) {
        this.yearProfit = yearProfit;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public double getTime() {
        return time;
    }

    public double getYearProfit() {
        return yearProfit;
    }


public Investor(){
    System.out.println(randomTime());
    System.out.println(randomYearProfit());
}


    public void randomAmount() {

   }

    public  Double randomTime() {
        Random random = new Random();
        return (double) (random.nextInt(10) + 1);   //od 1 do 10 lat
    }


   public Double randomYearProfit() {
      Random random3 = new Random();
      return (double) random3.nextInt(101);
   }

}
