package symulator.app.company;


import symulator.app.person.*;
import symulator.app.person.Marketer;
import symulator.app.person.ProgrammerJunior;
import symulator.app.person.ProgrammerRegular;
import symulator.app.person.ProgrammerSenior;
import symulator.app.person.Accountant;
import symulator.app.person.ProjectMenager;

public class Company  {
    private double efficiency;
    private double profit;
    private double losses;
    private Integer employeeCounter;
    private Integer projectNumber;

    public void setEmployeeCounter(Integer employeeCounter) {
        this.employeeCounter = employeeCounter;
    }

    public Integer getEmployeeCounter() {
        return employeeCounter;
    }

    public Integer getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(Integer projectNumber) {
        this.projectNumber = projectNumber;
    }

    public Company() {
    }
    ProjectMenager projectMenager = new ProjectMenager("Menadżer projektów",10000.0,20000.0);
    Accountant accountant = new Accountant("Ksiegowy",6000.0,10000.0);
    Marketer marketer = new Marketer("Marketingowiec",8000.0, 12000.0);
    ProgrammerJunior programmerJunior = new ProgrammerJunior("Młodszy programista", 4000.0,6500.0);
    ProgrammerRegular programmerRegular = new ProgrammerRegular("Programista", 9000.0 , 14000.0);
    ProgrammerSenior programmerSenior = new ProgrammerSenior("Starszy programista", 14000.0, 22000.0);
    }



