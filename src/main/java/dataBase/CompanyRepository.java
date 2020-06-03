package dataBase;


import org.hibernate.annotations.GenericGenerator;
import symulator.app.person.*;



import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "company_table")
public class CompanyRepository {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "incremator")
    @GenericGenerator(name = "incrementor", strategy = "incrementer")
    private Long id;
    @Column(name = "Costs")
    private Double costs;
    @Column(name = "Profits")
    private Double profits;
    @Column(name = "Efficiency")
    private Double efficiency;


    public void setId(Long id) {
        this.id = id;
    }
    public void setEfficiency(Double efficiency) {
        this.efficiency = efficiency;
    }
    public void setCosts(Double costs) {
        this.costs = costs;
    }
    public void setProfits(Double profits) {
        this.profits = profits;
    }

    public Long getId() {
        return id;
    }
    public Double getEfficiency() {
        return efficiency;
    }
    public Double getCosts() {
        return costs;
    }
    public Double getProfits() {
        return profits;
    }

    public CompanyRepository() {

    }
}





