package symulator.simulation;

import java.util.Random;

public class Randomise {
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
}
