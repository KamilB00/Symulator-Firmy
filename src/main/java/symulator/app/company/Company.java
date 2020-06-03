package symulator.app.company;

import dataBase.WorkerDAO;
import dataBase.WorkerEntity;
import symulator.simulation.Randomise;


public class Company {
    private static Company INSTANCE = null;
    private Company(){}
    public static Company getInstance(){
        if(INSTANCE==null)
            INSTANCE = new Company();
        return INSTANCE;
    }


    Randomise value = Randomise.getInstance();

    private double companyEfficiency;

    private double companyProfit;

    private double companyCosts;

    private Integer employeeCounter;

    private Integer projectManagersNumber;

    private Integer accountantsNumber;

    private Integer marketersNumber;

    private Integer juniorProgrammersNumber;

    private Integer regularProgrammersNumber;

    private Integer seniorProgrammersNumber;

    private Integer projectNumber;
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
        this.projectManagersNumber = projectManagersNumber;
        System.out.println("set PM number -->"+getProjectManagersNumber());
    }

    public void setAccountantsNumber(Integer accountantsNumber) {
        this.accountantsNumber = accountantsNumber;
        System.out.println("set ACCOUNTANTS number -->"+getAccountantsNumber());
    }

    public void setMarketersNumber(Integer marketersNumber) {
        this.marketersNumber = marketersNumber;
        System.out.println("set MARKETERS number -->"+getMarketersNumber());
    }

    public void setJuniorProgrammersNumber(Integer juniorProgrammersNumber) {
        this.juniorProgrammersNumber = juniorProgrammersNumber;
        System.out.println("set JuniorProgrammers number -->"+getJuniorProgrammersNumber());
    }

    public void setRegularProgrammersNumber(Integer regularProgrammersNumber) {
        this.regularProgrammersNumber = regularProgrammersNumber;
        System.out.println("set Regular Programmers number -->"+getRegularProgrammersNumber());
    }

    public void setSeniorProgrammersNumber(Integer seniorProgrammersNumber) {
        this.seniorProgrammersNumber = seniorProgrammersNumber;
        System.out.println("set Senior Programmers number -->"+getSeniorProgrammersNumber());
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
        return projectManagersNumber;
    }

    public Integer getAccountantsNumber() {
        return accountantsNumber;
    }

    public Integer getJuniorProgrammersNumber() {
        return juniorProgrammersNumber;
    }

    public Integer getMarketersNumber() {
        return marketersNumber;
    }

    public Integer getRegularProgrammersNumber() {
        return regularProgrammersNumber;
    }

    public Integer getSeniorProgrammersNumber() {
        return seniorProgrammersNumber;
    }
    //=================================================================================================================

    public static void addEmployee ( String position, Double salary, Double efficincy ){
        WorkerDAO workerDAO = new WorkerDAO();
        workerDAO.saveWorker(new WorkerEntity(position, salary,efficincy));
    }

    public void  createJuniorProgrammers(){
        for(int i=0;i<getJuniorProgrammersNumber();i++) {
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
    public Double minimalCosts(){
        Double minimalCosts = value.juniorProgrammerSalary();
       return minimalCosts;
    }

}


