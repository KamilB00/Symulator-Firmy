package dataBase;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "worker")
public class WorkerEntity {
    private static final long serialVersionUID = 1L;
    public WorkerEntity(){

    }

    public WorkerEntity(String position, double salary, double efficiency) {
        this.position=position;
        this.salary=salary;
        this.efficiency=efficiency;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID",unique = true, nullable =false)
    private int id;

    @Column(name ="POSITION",nullable = false)
    private String position;

    @Column(name= "SALARY",nullable = false)
    private double salary;

    @Column(name = "EFFICIENCY",nullable = false)
    private double efficiency;


    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public String getPosition() {
        return position;
    }
    public void setSalary(Double salary) {
        this.salary = salary;
    }
    public Double getSalary() {
        return salary;
    }
    public void setEfficiency(Double efficiency) {
        this.efficiency = efficiency;
    }
    public Double getEfficiency() {
        return efficiency;
    }

}
