package symulator.app.company;


import dataBase.WorkerDAO;
import dataBase.WorkerEntity;
import symulator.app.finance.Bank;
import symulator.app.finance.Investor;
import symulator.app.finance.OwnCapital;
import symulator.app.finance.VC;
import symulator.simulation.Randomise;
import symulator.simulation.SimulationClock;

import java.util.ArrayList;
import java.util.Random;


public class Company {
    Randomise value = Randomise.getInstance();
    SimulationClock simulationClock = SimulationClock.getInstance();
    //================================================================================================================
    private static Company INSTANCE = null;
    private Company(){}
    public static Company getInstance(){
        if(INSTANCE==null)
            INSTANCE = new Company();
        return INSTANCE;
    }
    //================================================================================================================
    private Double companyEfficiency;

    private Double companyProfit;

    private Double companyCosts;

    private Double companyBudget;

    private Integer realisedOrders;

    private Integer ordersInProcess;

    private Integer orderAtOnce;

    //================================================================================================================


    private Integer projectManagersNumber;

    private Integer accountantsNumber;

    private Integer marketersNumber;

    private Integer juniorProgrammersNumber;

    private Integer regularProgrammersNumber;

    private Integer seniorProgrammersNumber;




    //================================================================================================================


    public void setCompanyBudget(Double companyBudget) {
        this.companyBudget = companyBudget;
        System.out.println("company budget set --> "+ getCompanyBudget());
    }

    public void setCompanyCosts(double companyCosts) {
        this.companyCosts = companyCosts;
        System.out.println("company costs set --> "+ getCompanyCosts());
    }

    public void setCompanyEfficiency(double companyEfficiency) {
        this.companyEfficiency = companyEfficiency;
        System.out.println("company efficiency set --> "+ getCompanyEfficiency());
    }

    public void setCompanyProfit(double companyProfit) {
        this.companyProfit = companyProfit;
        System.out.println("company profits set --> "+ getCompanyProfit());
    }

    public void setRealisedOrders(Integer realisedOrders) {
        this.realisedOrders = realisedOrders;
        System.out.println("realised orders set ---> "+ getRealisedOrders());
    }

    public void setOrdersInProcess(Integer ordersInProcess) {
        this.ordersInProcess = ordersInProcess;
        System.out.println("orders in process set ---> "+ getOrdersInProcess());
    }

    public void setOrderAtOnce(Integer orderAtOnce) {
        this.orderAtOnce = orderAtOnce;
        System.out.println("orders at once set ---> "+ getOrderAtOnce());
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

    public Double getCompanyBudget() {
        return companyBudget;
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

    public Integer getRealisedOrders() {
        return realisedOrders;
    }

    public Integer getOrdersInProcess() {
        return ordersInProcess;
    }

    public Integer getOrderAtOnce() {
        return orderAtOnce;
    }

    //=================================================================================================================

    public static void addEmployee ( String position, Double salary, Double efficincy ){
        WorkerDAO workerDAO = new WorkerDAO();
        workerDAO.saveWorker(new WorkerEntity(position, salary,efficincy));
    }
    private Double juniorProgrammerSalary = value.juniorProgrammerSalary();
    private Double regularProgrammerSalary = value.regularProgrammerSalary();
    private Double seniorProgrammerSalary = value.seniorProgrammerSalary();
    private Double projectManagerSalary = value.projectManagerSalary();
    private Double marketerSalary = value.marketerSalary();
    private Double accountantSalary = value.accountantSalary();

    public void  createJuniorProgrammers(){
        for(int i=0;i<getJuniorProgrammersNumber();i++) {
            addEmployee("Junior Programmer", juniorProgrammerSalary, juniorProgrammerSalary*value.efficiencyRate());
        }
    }
    public void createRegularProgrammers(){
        for(int i=0;i<getRegularProgrammersNumber();i++) {
            addEmployee("Regular Programmer", regularProgrammerSalary, regularProgrammerSalary*value.efficiencyRate());
        }
    }
    public void createSeniorProgrammers(){
        for(int i=0;i<getSeniorProgrammersNumber();i++) {
            addEmployee("Senior Programmer", seniorProgrammerSalary, seniorProgrammerSalary*value.efficiencyRate());
        }
    }
    public void createAccountants(){
        for(int i=0;i<getAccountantsNumber();i++) {
            addEmployee("Ksiegowy", accountantSalary, accountantSalary*value.efficiencyRate());
        }
    }
    public void createMarketers(){
        for(int i=0;i<getMarketersNumber();i++) {
            addEmployee("Marketer", marketerSalary, marketerSalary*value.efficiencyRate());
        }
    }
    public void createProjectManagers(){
        for(int i=0;i<getProjectManagersNumber();i++) {
            addEmployee("Project Manager", projectManagerSalary, projectManagerSalary*value.efficiencyRate());
        }
    }

    public  Double minimalCosts(){
       return juniorProgrammerSalary*getJuniorProgrammersNumber()+regularProgrammerSalary*getRegularProgrammersNumber()
               +seniorProgrammerSalary*getSeniorProgrammersNumber()+accountantSalary*getAccountantsNumber() +marketerSalary*getMarketersNumber()+projectManagerSalary*getProjectManagersNumber();
    }
    public Double costsOfEquipment(){
         double computerEquipment = 3500.0;
         double desk = 1500.0;
         double chair = 700.0;
         double softwareLicence = 1000.0;
        return computerEquipment+desk+chair+softwareLicence;
    }

    public Integer allEmployees(){
        return getJuniorProgrammersNumber()+getRegularProgrammersNumber()+getSeniorProgrammersNumber()+getAccountantsNumber()+getMarketersNumber()+getProjectManagersNumber();
    }

    public ArrayList<Projects> addAnOrder(){
        ArrayList<Projects> projectsList = new ArrayList<>();
        Projects projects = new Projects();
        projects.setLevelOfDifficulty(value.levelOfOrderDifficulty());
        projects.setPrice(value.priceAssessment(projects.getLevelOfDifficulty()));
        projects.setProjectTime(value.randomOrderTime(projects.getLevelOfDifficulty()));
        projects.setOrderName(value.randomNameOfOrder());
        projectsList.add(projects);
        return projectsList;
    }
    public void viewProjects(){
        ArrayList<Projects> view = addAnOrder();
        for(int i=0;i<addAnOrder().size();i++){
            System.out.println("Level od difficulty :"+ view.get(i).getLevelOfDifficulty()+ " Price : "+view.get(i).getPrice()+" Order time :"+ view.get(i).getProjectTime()+" Order Category: "+view.get(i).getOrderName());
        }
    }
    public void orderRealisationTime(){


    }
    public void orderRealisation(){
        for(int i=0;i<getOrderAtOnce();i++){
            addAnOrder();
            viewProjects();
        }

    }




}


