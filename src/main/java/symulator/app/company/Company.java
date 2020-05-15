package symulator.app.company;


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


}
