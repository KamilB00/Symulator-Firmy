package symulator.app.company;

import dataBase.WorkerDAO;
import dataBase.WorkerEntity;
import symulator.app.person.*;
import symulator.simulation.Randomise;
import symulator.Main;
public class Company {
    Randomise value = new Randomise();
    private double companyEfficiency;

    private double companyProfit;

    private double companyCosts;

    private Integer employeeCounter;

    private Integer ProjectManagersNumber;

    private Integer AccountantsNumber;

    private Integer MarketersNumber;

    private Integer JuniorProgrammersNumber;

    private Integer RegularProgrammersNumber;

    private Integer SeniorProgrammersNumber;

    private Integer projectNumber;
    //================================================================================================================
    public Company(){}

    //================================================================================================================
    public void setEmployeeCounter(Integer employeeCounter) {
        this.employeeCounter = employeeCounter;
    }

    public void setCompanyCosts(double companyCosts) {
        this.companyCosts = companyCosts;
    }

    public void setCompanyEfficiency(double companyEfficiency) {
        this.companyEfficiency = companyEfficiency;
    }

    public void setCompanyProfit(double companyProfit) {
        this.companyProfit = companyProfit;
    }

    public void setProjectNumber(Integer projectNumber) {
        this.projectNumber = projectNumber;
    }

    public void setProjectManagersNumber(Integer projectManagersNumber) {
        ProjectManagersNumber = projectManagersNumber;
    }

    public void setAccountantsNumber(Integer accountantsNumber) {
        AccountantsNumber = accountantsNumber;
    }

    public void setMarketersNumber(Integer marketersNumber) {
        MarketersNumber = marketersNumber;
    }

    public void setJuniorProgrammersNumber(Integer juniorProgrammersNumber) {
        JuniorProgrammersNumber = juniorProgrammersNumber;
    }

    public void setRegularProgrammersNumber(Integer regularProgrammersNumber) {
        RegularProgrammersNumber = regularProgrammersNumber;
    }

    public void setSeniorProgrammersNumber(Integer seniorProgrammersNumber) {
        SeniorProgrammersNumber = seniorProgrammersNumber;
    }
    //================================================================================================================

    public double getCompanyCosts() {
        return companyCosts;
    }

    public double getCompanyEfficiency() {
        return companyEfficiency;
    }

    public double getCompanyProfit() {
        return companyProfit;
    }

    public Integer getEmployeeCounter() {
        return employeeCounter;
    }

    public Integer getProjectNumber() {
        return projectNumber;
    }

    public Integer getProjectManagersNumber() {
        return ProjectManagersNumber;
    }

    public Integer getAccountantsNumber() {
        return AccountantsNumber;
    }

    public Integer getJuniorProgrammersNumber() {
        return JuniorProgrammersNumber;
    }

    public Integer getMarketersNumber() {
        return MarketersNumber;
    }

    public Integer getRegularProgrammersNumber() {
        return RegularProgrammersNumber;
    }

    public Integer getSeniorProgrammersNumber() {
        return SeniorProgrammersNumber;
    }
    //=================================================================================================================

    public static void addEmployee ( String position, Double salary, Double efficincy ){
        WorkerDAO workerDAO = new WorkerDAO();
        workerDAO.saveWorker(new WorkerEntity(position, salary,efficincy));
    }
    public void  createJuniorProgrammers(){
        for(int i=0;i<getJuniorProgrammersNumber();i++) {
            ProgrammerJunior junior = new ProgrammerJunior("Junior Programmer", value.juniorProgrammerSalary(), value.juniorProgrammerSalary() * value.efficiencyRate());
            addEmployee("Junior Programmer", value.juniorProgrammerSalary(), value.juniorProgrammerSalary()*value.efficiencyRate());
        }
    }
    public void createRegularProgrammers(){
        for(int i=0;i<getRegularProgrammersNumber();i++) {
            addEmployee("Regular Programmer", value.regularProgrammerSalary(), value.regularProgrammerSalary()*value.efficiencyRate());
        }
    }
    public void createSeniorProgrammers(){
        for(int i=0;i<getSeniorProgrammersNumber();i++) {
            addEmployee("Senior Programmer", value.seniorProgrammerSalary(), value.seniorProgrammerSalary()*value.efficiencyRate());
        }
    }
    public void createAccountants(){
        for(int i=0;i<getAccountantsNumber();i++) {
            addEmployee("Ksiegowy", value.accountantSalary(), value.accountantSalary()*value.efficiencyRate());
        }
    }
    public void createMarketers(){
        for(int i=0;i<getMarketersNumber();i++) {
            addEmployee("Marketer", value.marketerSalary(), value.marketerSalary()*value.efficiencyRate());
        }
    }
    public void createProjectManagers(){
        for(int i=0;i<getProjectManagersNumber();i++) {
            addEmployee("Project Manager", value.projectManagerSalary(), value.projectManagerSalary()*value.efficiencyRate());
        }
    }

}


