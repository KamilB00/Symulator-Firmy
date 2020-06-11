package symulator.simulation;

import symulator.app.company.Company;

import java.util.ArrayList;
import java.util.Random;

public class Randomise {


    private Randomise(){}
private static Randomise INSTANCE = null;

    public static Randomise getInstance(){
        if(INSTANCE == null)
            INSTANCE = new Randomise();
        return INSTANCE;
    }

    public Double seniorProgrammerSalary(){
        Random random = new Random();
        Double salary = random.nextInt(10000)+20000.0;
        return salary;
    }
    public Double juniorProgrammerSalary(){
        Random random = new Random();
        Double salary = random.nextInt(4000)+5000.0;
        return salary;
    }
    public Double regularProgrammerSalary(){
        Random random = new Random();
        Double salary = random.nextInt(15000)+10000.0;
        return salary;
    }
    public Double accountantSalary(){
        Random random = new Random();
        Double salary = random.nextInt(2000)+1500.0;
        return salary;
    }
    public Double marketerSalary(){
        Random random = new Random();
        Double salary = random.nextInt(2000)+3000.0;
        return salary;
    }
    public Double projectManagerSalary(){
        Random random = new Random();
        Double salary = random.nextInt(4000)+5000.0;
        return salary;
    }
    public Double efficiencyRate(){
        Random random = new Random();
        Double rate = random.nextInt(200) + 50.0;
        return rate/100.0;
    }

    public Double randomVCShares() {
        Random random = new Random();
        Double vcShares = random.nextInt(30)+10.0; //od 10 do 40%
        return vcShares;
    }

    public Double randomVCAmount() {
        Random random = new Random();
        Double vcAmount = random.nextInt(1800000) + 200000.0; //od 200k do 2m
        return vcAmount;
    }
    public Double generateBankPercentage(){
        Random rand = new Random();
        Double number = rand.nextInt(10)+1.0;
        return (number.doubleValue())/100;
    }

    public Integer randomInvestorTime() {
        Random random = new Random();
        Integer time = random.nextInt(10)+1;
        return time;   //od 1 do 10 lat
    }
    public Double randomInvestorYearProfit() {
        Random random = new Random();
        Double profit = random.nextInt(30)+1.0;
        return profit/100;   //od 1 do 10 lat
    }
    public Double randomInvestorAmount() {
        Random random = new Random();
        Double investorAmount = random.nextInt(1800000) + 200000.0; //od 200k do 2m
        return investorAmount;
    }

    public Double minimalCosts(){
        Company company = Company.getInstance();
        Double minimalCosts = company.getJuniorProgrammersNumber()*juniorProgrammerSalary();
        return minimalCosts;
    }
    public Integer levelOfOrderDifficulty(){
        Random random = new Random();
        Integer level = random.nextInt(3)+1;
                return level;
    }
    public Double priceAssessment(int level){
        Random random = new Random();
        double price = 0;
        switch(level){
            case 1:
                price = random.nextInt(40000)+20000.0;
                break;
            case 2:
                price = random.nextInt(50000)+50000.0;
                break;
            case 3:
                price = random.nextInt(400000)+100000.0;
                break;
            default:
                System.out.println("Can not assess order price");
        }
        return price;

    }public Integer randomOrderTime(int level) {
        Random random = new Random();
        int weeks = 0;
        switch (level) {
            case 1:
                weeks = random.nextInt(2) + 1;
                break;
            case 2:
                weeks = random.nextInt(5) + 3;
                break;
            case 3:
                weeks = random.nextInt(8) + 8;
                break;
            default:
                System.out.println("Can not assess order time");
        }
        return weeks;
    }

    public String randomNameOfOrder(){
        Random randomName = new Random();
        String name = "";
        int choice = randomName.nextInt(5)+1;
        switch(choice){
            case 1:
               name ="Aplikacja Webowa";
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
