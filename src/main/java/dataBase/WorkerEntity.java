package dataBase;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "worker")
/**
 * Klasa odpowiedzialna za tworzenie obiektów (pracownicy), pola tabeli w bazie
 */
public class WorkerEntity {
    private static final long serialVersionUID = 1L;


    public WorkerEntity(){

    }

    public WorkerEntity(String position, double salary, double efficiency, boolean availability, String grp) {
        this.position=position;
        this.salary=salary;
        this.efficiency=efficiency;
        this.availability = availability;
        this.grp = grp;
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

    @Column(name = "GRP", nullable = true)
    private String grp;

    @Column(name = "AVAILABILITY",nullable = false)
    private boolean availability;


    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public double getEfficiency() {
        return efficiency;
    }

    public String getGrp() {
        return grp;
    }

    public void setGrp(String grp) {
        this.grp = grp;
    }


}
