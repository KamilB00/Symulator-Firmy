package symulator.app.finance;
import java.util.Random;

public class Investor {
   private double amount = randomAmount();
   private double yearProfit = randomYearProfit();
   private double time = randomTime();


   //TODO MATEUSZ
   // 1. funkcjie Randomowe dla czasu w latach
   // 2. funcje randomowe dla kwoty oferowanej przez inwestora
   // 3. funkcje randomowe dla yearProfit w procentach


   double randomTime() {
      Random random = new Random();
      return (double) (random.nextInt(10) + 1);   //od 1 do 10 lat
   }

   double randomAmount() {
      Random random2 = new Random();

      if(time == 1) return (double) (random2.nextInt(5) + 1) * 100000;
      else if(time == 2) return (double) (random2.nextInt(11) + 5) * 100000;
      else if(time == 3) return (double) (random2.nextInt(16) + 10) * 100000;
      else if(time == 4) return (double) (random2.nextInt(21) + 15) * 100000;
      else if(time == 5) return (double) (random2.nextInt(26) + 20) * 100000;
      else if(time == 6) return (double) (random2.nextInt(31) + 25) * 100000;
      else if(time == 7) return (double) (random2.nextInt(36) + 30) * 100000;
      else if(time == 8) return (double) (random2.nextInt(41) + 35) * 100000;
      else if(time == 9) return (double) (random2.nextInt(46) + 40) * 100000;
      else if(time == 10) return (double) (random2.nextInt(51) + 45) * 100000;
         else return 0;
   }

   double randomYearProfit() {
      Random random3 = new Random();
      return (double) random3.nextInt(101);
   }

}
