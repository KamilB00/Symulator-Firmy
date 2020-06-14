package symulator.simulation;

import symulator.app.company.Company;

import java.util.ArrayList;
import java.util.Random;

public class Randomise {


    private Randomise(){
        //-------------------------------------------------------------------------------------------------------
        /**
         * SINGLETON DLA KLASY RANDOMISE
         */
    }
private static Randomise INSTANCE = null;

    public static Randomise getInstance(){
        if(INSTANCE == null)
            INSTANCE = new Randomise();
        return INSTANCE;
    }
    //-------------------------------------------------------------------------------------------------------

    /**
     * FUNKCJA RANDOMOWA DLA WYPŁAT SENIOR PROGRAMISTÓW
     * @return
     */
    public Double seniorProgrammerSalary(){
        Random random = new Random();
        Double salary = random.nextInt(10000)+20000.0;
        return salary;
    }

    /**
     * FUNKCJA RANDOMOWA DLA WYPŁAT JUNIOR PROGRAMISTÓW
     * @return
     */
    public Double juniorProgrammerSalary(){
        Random random = new Random();
        Double salary = random.nextInt(4000)+5000.0;
        return salary;
    }

    /**
     * FUNKCJA RANDOMOWA DLA WYPŁAT REGULAR PROGRAMISTÓW
     * @return
     */
    public Double regularProgrammerSalary(){
        Random random = new Random();
        Double salary = random.nextInt(15000)+10000.0;
        return salary;
    }

    /**
     * FUNKCJA RANDOMOWA DLA WYPŁAT KSIĘGOWYCH
     * @return
     */
    public Double accountantSalary(){
        Random random = new Random();
        Double salary = random.nextInt(2000)+1500.0;
        return salary;
    }

    /**
     * FUNKCJA RANDOMOWA DLA WYPŁAT MARKETERÓW
     * @return
     */
    public Double marketerSalary(){
        Random random = new Random();
        Double salary = random.nextInt(2000)+3000.0;
        return salary;
    }

    /**
     * FUNKCJA RANDOMOWA DLA WYPŁAT PROJECT MANAGERÓW
     * @return
     */
    public Double projectManagerSalary(){
        Random random = new Random();
        Double salary = random.nextInt(4000)+5000.0;
        return salary;
    }

    /**
     * FUNKCJA RANDOWMOWA DLA WSKAŹNIKA EFEKTYWNOŚCI
     * @return
     */
    public Double efficiencyRate(){
        Random random = new Random();
        Double rate = random.nextInt(3) + 1.0;
        return rate;
    }

    /**
     * FUNKCJA RANDOWMOWA DLA UDZIAŁÓW VENTURE CAPITALS
     * @return
     */
    public Double randomVCShares() {
        Random random = new Random();
        Double vcShares = random.nextInt(30)+10.0; //od 10 do 40%
        return vcShares;
    }

    /**
     * FUNKCJA RANDOWMOWA DLA KWOTY OFEROWANEJ PRZEZ VENTURE CAPITALS
     * @return
     */
    public Double randomVCAmount() {
        Random random = new Random();
        Double vcAmount = random.nextInt(1800000) + 200000.0; //od 200k do 2m
        return vcAmount;
    }

    /**
     * FUNKCJA RANDOWMOWA DLA PROCENTU KREDYTU
     * @return
     */
    public Double generateBankPercentage(){
        Random rand = new Random();
        Double number = rand.nextInt(10)+1.0;
        return (number.doubleValue());
    }

    /**
     * FUNKCJA RANDOWMOWA DLA CZASU TRWANIA UMOWY Z INVESTOREM
     * @return
     */
    public Integer randomInvestorTime() {
        Random random = new Random();
        Integer time = random.nextInt(10)+1;
        return time;   //od 1 do 10 lat
    }

    /**
     * FUNKCJA RANDOWMOWA DLA PROCENTU ZYSKU INVESTORA
     * @return
     */
    public Double randomInvestorYearProfit() {
        Random random = new Random();
        Double profit = random.nextInt(30)+1.0;
        return profit/100;   //od 1 do 10 lat
    }

    /**
     * FUNKCJA RANDOWMOWA DLA KWOTY OFEROWANEJ PRZEZ INVESTORA
     * @return
     */
    public Double randomInvestorAmount() {
        Random random = new Random();
        Double investorAmount = random.nextInt(1800000) + 200000.0; //od 200k do 2m
        return investorAmount;
    }

    /**
     * FUNKCJA RANDOWMOWA DLA POZIOMU SKOMPLIKOWANIA PROJEKTU
     * @return
     */
    public Integer levelOfOrderDifficulty(){
        Random random = new Random();
        Integer level = random.nextInt(3)+1;
                return level;
    }

    /**
     * FUNKCJA RANDOWMOWA DLA PRZYCIAŁU KWOTY WEDLE SKOMPLIKOWANIA
     * @param level
     * @return
     */
    public Double priceAssessment(int level){
        Random random = new Random();
        double price = 0;
        switch(level){
            case 1:
                price = random.nextInt(80000)+20000.0;
                break;
            case 2:
                price = random.nextInt(500000)+500000.0;
                break;
            case 3:
                price = random.nextInt(1200000)+1000000.0;
                break;
            default:
                System.out.println("Can not assess order price");
        }
        return price;

    }

    /**
     * FUNKCJA RANDOWMOWA DLA CZASU TRWANIA POJEDYŃCZEGO ZAMÓWIENIA (PROJEKTU)
     * @param level
     * @return
     */
    public Double randomOrderTime(int level) {
        Random random = new Random();
        double days = 0;
        switch (level) {
            case 1:
                days = random.nextInt(2000) + 1000;
                break;
            case 2:
                days = random.nextInt(3000) + 1000;
                break;
            case 3:
                days = random.nextInt(4000) +1000;
                break;
            default:
                System.out.println("Can not assess order time");
        }
        return days;
    }


    private static int quantityAppWeb = 0;

    /**
     * FUNKCJA RANDOWMOWA DLA NAZWY REALIZOWANEGO PROJEKTU
     * @return
     */
    public String randomNameOfOrder(){
        Random randomName = new Random();
        String name = "";
        int choice = randomName.nextInt(5)+1;
        switch(choice){
            case 1:
               name ="Aplikacja Webowa " + String.valueOf(quantityAppWeb);
               quantityAppWeb++;
                break;
            case 2:
                name ="Aplikacja Mobilna";
                break;
            case 3:
                name ="Strona internetowa";
                break;
            case 4:
                name ="Narzędzia wewnętrzne";
                break;
            case 5:
                name ="Projekt graficzny";
                break;
            default:
                System.out.println("Can not name order");
        }
        return name;
    }

}
