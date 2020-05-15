package symulator.app.person;



public class Worker {
    private long id;
    private String position;
    private Double salary;
    private Double efficiency;


    public Worker(String position, Double salary, Double efficiency) {
        this.position = position;
        this.salary = salary;
        this.efficiency = efficiency;
    }


    // TODO KUBA
    //  1. nadpisanie wszystkich klas które dziedziczą po "workerze" i nadanie im wartości (dziedziczenie)


    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(Double efficiency) {
        this.efficiency = efficiency;
    }

}
