package symulator.app.person;

public class Marketer extends Worker {
    public Marketer(String position,Double salary,Double efficiency){
        super(position,salary,efficiency);
        System.out.println("konstruktor Marketer");
    }
}
