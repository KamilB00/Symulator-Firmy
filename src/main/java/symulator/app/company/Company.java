package symulator.app.company;


import dataBase.WorkerDAO;
import dataBase.WorkerEntity;
import org.hibernate.jdbc.Work;
import symulator.app.finance.Bank;
import symulator.app.finance.Investor;
import symulator.app.finance.OwnCapital;
import symulator.app.finance.VC;
import symulator.app.person.Worker;
import symulator.simulation.Randomise;
import symulator.simulation.SimulationClock;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;


public class Company {
    Randomise value = Randomise.getInstance();
    SimulationClock simulationClock = SimulationClock.getInstance();
    WorkerDAO workerDAO = new WorkerDAO();


    List<WorkerEntity> workerEntities;
    //================================================================================================================
    private static Company INSTANCE = null;

    private Company() {
        try {
            workerEntities = workerDAO.getAllWorkers();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static Company getInstance() {
        if (INSTANCE == null)
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

    private Double groupEfficiency1;

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
        System.out.println("company budget set --> " + getCompanyBudget());
    }

    public void setCompanyCosts(double companyCosts) {
        this.companyCosts = companyCosts;
        System.out.println("company costs set --> " + getCompanyCosts());
    }

    public void setCompanyEfficiency(double companyEfficiency) {
        this.companyEfficiency = companyEfficiency;
        System.out.println("company efficiency set --> " + getCompanyEfficiency());
    }

    public void setCompanyProfit(double companyProfit) {
        this.companyProfit = companyProfit;
        System.out.println("company profits set --> " + getCompanyProfit());
    }

    public void setRealisedOrders(Integer realisedOrders) {
        this.realisedOrders = realisedOrders;
        System.out.println("realised orders set ---> " + getRealisedOrders());
    }

    public void setOrdersInProcess(Integer ordersInProcess) {
        this.ordersInProcess = ordersInProcess;
        System.out.println("orders in process set ---> " + getOrdersInProcess());
    }

    public void setOrderAtOnce(Integer orderAtOnce) {
        this.orderAtOnce = orderAtOnce;
        System.out.println("orders at once set ---> " + getOrderAtOnce());
    }

    public void setProjectManagersNumber(Integer projectManagersNumber) {
        this.projectManagersNumber = projectManagersNumber;
        System.out.println("set PM number -->" + getProjectManagersNumber());
    }

    public void setAccountantsNumber(Integer accountantsNumber) {
        this.accountantsNumber = accountantsNumber;
        System.out.println("set ACCOUNTANTS number -->" + getAccountantsNumber());
    }

    public void setMarketersNumber(Integer marketersNumber) {
        this.marketersNumber = marketersNumber;
        System.out.println("set MARKETERS number -->" + getMarketersNumber());
    }

    public void setJuniorProgrammersNumber(Integer juniorProgrammersNumber) {
        this.juniorProgrammersNumber = juniorProgrammersNumber;
        System.out.println("set JuniorProgrammers number -->" + getJuniorProgrammersNumber());
    }

    public void setRegularProgrammersNumber(Integer regularProgrammersNumber) {
        this.regularProgrammersNumber = regularProgrammersNumber;
        System.out.println("set Regular Programmers number -->" + getRegularProgrammersNumber());
    }

    public void setSeniorProgrammersNumber(Integer seniorProgrammersNumber) {
        this.seniorProgrammersNumber = seniorProgrammersNumber;
        System.out.println("set Senior Programmers number -->" + getSeniorProgrammersNumber());
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

    public static void addEmployee(String position, Double salary, Double efficiency) {
        WorkerDAO workerDAO = new WorkerDAO();
        workerDAO.saveWorker(new WorkerEntity(position, salary, efficiency, true));
    }

    private Double juniorProgrammerSalary = value.juniorProgrammerSalary();
    private Double regularProgrammerSalary = value.regularProgrammerSalary();
    private Double seniorProgrammerSalary = value.seniorProgrammerSalary();
    private Double projectManagerSalary = value.projectManagerSalary();
    private Double marketerSalary = value.marketerSalary();
    private Double accountantSalary = value.accountantSalary();

    public void createJuniorProgrammers() {
        for (int i = 0; i < getJuniorProgrammersNumber(); i++) {
            addEmployee("Junior Programmer", juniorProgrammerSalary, value.efficiencyRate());
        }
    }

    public void createRegularProgrammers() {
        for (int i = 0; i < getRegularProgrammersNumber(); i++) {
            addEmployee("Regular Programmer", regularProgrammerSalary, value.efficiencyRate());
        }
    }

    public void createSeniorProgrammers() {
        for (int i = 0; i < getSeniorProgrammersNumber(); i++) {
            addEmployee("Senior Programmer", seniorProgrammerSalary, value.efficiencyRate());
        }
    }

    public void createAccountants() {
        for (int i = 0; i < getAccountantsNumber(); i++) {
            addEmployee("Ksiegowy", accountantSalary, value.efficiencyRate());
        }
    }

    public void createMarketers() {
        for (int i = 0; i < getMarketersNumber(); i++) {
            addEmployee("Marketer", marketerSalary, value.efficiencyRate());
        }
    }

    public void createProjectManagers() {
        for (int i = 0; i < getProjectManagersNumber(); i++) {
            addEmployee("Project Manager", projectManagerSalary, value.efficiencyRate());
        }
    }

    public Double minimalCosts() {
        return juniorProgrammerSalary * getJuniorProgrammersNumber() + regularProgrammerSalary * getRegularProgrammersNumber()
                + seniorProgrammerSalary * getSeniorProgrammersNumber() + accountantSalary * getAccountantsNumber() + marketerSalary * getMarketersNumber() + projectManagerSalary * getProjectManagersNumber();
    }

    public Double costsOfEquipment() {
        double computerEquipment = 3500.0;
        double desk = 1500.0;
        double chair = 700.0;
        double softwareLicence = 1000.0;
        return computerEquipment + desk + chair + softwareLicence;
    }

    public Integer allEmployees() {
        return getJuniorProgrammersNumber() + getRegularProgrammersNumber() + getSeniorProgrammersNumber() + getAccountantsNumber() + getMarketersNumber() + getProjectManagersNumber();
    }

    private HashMap<String, List<Project>> projectsList = new HashMap<>(); // key = project, value = groupname
    private HashMap<String, Boolean> groupsAndAvailability = new HashMap<>();
    private boolean first = true;

    public void createGroups(int howMany) {
        for (int i = 0; i < howMany; i++) {
            groupsAndAvailability.put("group " + i, false); // isBusy = false
        }

    }

    public void assignGroupsToWorkers() {
        for (int i = 0; i < workerEntities.size(); i++) {
            workerEntities.get(i).setGrp((String) groupsAndAvailability.keySet().toArray()[(int) (Math.random() * groupsAndAvailability.size())]);
        }
    }

    public void assignGroupsToProjects() {
        HashMap<String, Boolean> availableGroups = groupsAndAvailability.entrySet().stream().filter(x -> !x.getValue()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (prev, next) -> next, HashMap::new));
        HashMap<String, List<Project>> freeProjects = projectsList.entrySet().stream().filter(x -> x.getKey().equals("UNASSIGNED")).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (prev, next) -> next, HashMap::new));
        List<Project> getProjects = new ArrayList<>();
        getProjects.addAll(freeProjects.get("UNASSIGNED"));

        for (Map.Entry<String, Boolean> availableGroupsEntry : availableGroups.entrySet()) {


            groupsAndAvailability.replace(availableGroupsEntry.getKey(), true);
            try {
                Project p = getProjects.remove(getProjects.size()-1);
                List<Project> pl = new ArrayList<>();
                pl.add(p);
                projectsList.put(availableGroupsEntry.getKey(), pl);
                projectsList.put("UNASSIGNED", getProjects);

            } catch (NullPointerException e) {
                System.out.println("More groups than projects, projects should be always more than groups"); // It can be further changed
            }

        }

    }

    public void realizeProjects() {

        System.out.println("1");

        HashMap<String, Double> groupEfficiency = new HashMap<>();

        for (int i = 0; i < workerEntities.size(); i++) {
            if (groupEfficiency.containsKey(workerEntities.get(i).getGrp())) {
                groupEfficiency1 = groupEfficiency.get(workerEntities.get(i).getGrp());
                groupEfficiency1 += workerEntities.get(i).getEfficiency();
                groupEfficiency.replace(workerEntities.get(i).getGrp(), groupEfficiency1);
            } else {
                groupEfficiency.put(workerEntities.get(i).getGrp(), workerEntities.get(i).getEfficiency());
            }


        }


        Iterator<Map.Entry<String, List<Project>>> projectIterator = projectsList.entrySet().iterator();
        while (projectIterator.hasNext()) {
            Map.Entry<String, List<Project>> projectEntry = projectIterator.next();
            if(!projectEntry.getKey().equals("UNASSIGNED")) {

                //Double projectTime = projectEntry.getKey().getProjectTime();
                Double groupEff = groupEfficiency.get(projectEntry.getKey());
                List<Project> getProjcs = new ArrayList<>();
                getProjcs.addAll(projectEntry.getValue());
                int projectsQuantity = getProjcs.size();
                Iterator pit = getProjcs.iterator();
                while (pit.hasNext()) {
                    Project project = (Project) pit.next();
                    project.setProjectTime(project.getProjectTime() - groupEff / projectsQuantity);

                    if (project.getProjectTime() <= 0) {
                        groupsAndAvailability.replace(projectEntry.getKey(), false);
                        pit.remove();
                    }
                }
                projectsList.replace(projectEntry.getKey(), getProjcs);
            }

            //Double projectPrice = projectEntry.getKey().getPrice(); 46, 6, 2


        } // 109, 25, 158 - >  89, 11

        // dzien: 1000(dni) = 1000(dni)- (pracownik*efektywnosc  1*1.0 + 1*2.0+ 1*8.0)=10 dni = czas skoczenia 100 dni
        // obecny stan dni =< 0 jesli tak to usun projekt, dodaj do statystyk i ustaw grupe na niezajeta isBusy = false

    }

    public void displayProjectsWorkersAndGroupsInTable() {

    }

    public boolean checkIfNumberOfProjectsAreBelow() {
        return projectsList.size() < (25 - (int) (Math.random() * 10));
    }

    public void addProjects(int howMany) { // dodaje projekty i przypisuje go jako nieprzypisany do zadnej groupy
        for (int i = 0; i < howMany; i++) {
            Project projects = new Project();
            projects.setLevelOfDifficulty(value.levelOfOrderDifficulty());
            projects.setPrice(value.priceAssessment(projects.getLevelOfDifficulty()));
            projects.setProjectTime(value.randomOrderTime(projects.getLevelOfDifficulty()));
            projects.setOrderName(value.randomNameOfOrder());
            if (projectsList.containsKey("UNASSIGNED")) {

                List<Project> getP = new ArrayList<>();
                getP.addAll(projectsList.get("UNASSIGNED"));
                getP.add(projects);
                projectsList.replace("UNASSIGNED", getP);

            }
            else
                projectsList.put("UNASSIGNED",  List.of(projects));

        }

    }

    public void runProjectsManagerInDay() { // Wywoluje sie co jeden dzien, tworzy grupy jesli ich nie ma przypisuje grupy do pracownikow realizuje projekty i dodaje jesli ich wartosc spadla ponizej
        if (first) {
            addProjects((int) (Math.random() * 10) + orderAtOnce + 1);
            createGroups(getOrderAtOnce()); //Later change from creation to fetching from database but first it has to be saved into db and currently it isn't
            assignGroupsToWorkers();
            assignGroupsToProjects();
            first = false;
        }
        realizeProjects();
        if (checkIfNumberOfProjectsAreBelow())
            addProjects((int) (Math.random() * 10));
        assignGroupsToProjects();

    }

    public void viewProjects() {
        for (Map.Entry<String, List<Project>> projectEntry : projectsList.entrySet()) {
            System.out.println("Team :" + projectEntry.getKey());
            projectEntry.getValue().forEach(p -> System.out.println("Level od difficulty :" + p.getLevelOfDifficulty() + " Price : " + p.getPrice() + " Order time :" + p.getProjectTime() + " Order Category: " + p.getOrderName()));
        }
    }

    public void orderRealisationTime() {
    }

    // dodawanie wszystkich pensji pracowników
    public Double countSalaries(){
        Double allSalaries =0.0;
        Double allSalaryTaxes = 0.0;
        for (int i=0;i<workerEntities.size(); i++){
            allSalaries += workerEntities.get(i).getSalary();
            // składki: EMERYTALNE, RENTOWE, WYPADKOWE, FUNDUSZ PRACY, FGŚP
            allSalaryTaxes += (workerEntities.get(i).getSalary()*0.0976)+(workerEntities.get(i).getSalary()*0.065)+(workerEntities.get(i).getSalary()*0.0167)+(workerEntities.get(i).getSalary()*0.0245)+(workerEntities.get(i).getSalary()*0.001);

        }
        return allSalaries+allSalaryTaxes;
    }



}