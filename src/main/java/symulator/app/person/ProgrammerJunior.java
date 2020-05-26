package symulator.app.person;

public class ProgrammerJunior extends Worker {

    public ProgrammerJunior(String position,Double salary,Double efficiency){

        super(position,salary,efficiency);

        System.out.println("utworzono ProgrammerJunior -->"+ getSalary());
    }
}
