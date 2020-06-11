package dataBase;


import org.hibernate.annotations.GenericGenerator;
import symulator.app.person.*;



import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "company_table")
public class CompanyRepository {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "QUARTER",unique = true, nullable =false)

    private Long quarter;
    @Column(name = "SPENDINGS")
    private double spendings;
    @Column(name = "PROFITS")
    private double profits;
    @Column(name = "EFFICIENCY")
    private double efficiency;
    @Column(name = "REALISED ORDERS")
    private int orders;
   @Column(name = "EVENT")
   private String event;

    public void setQuarter(Long quarter) {
        this.quarter = quarter;
    }
    public void setEfficiency(Double efficiency) {
        this.efficiency = efficiency;
    }
    public void setSpendings(Double spendings) {
        this.spendings = spendings;
    }
    public void setProfits(Double profits) {
        this.profits = profits;
    }
    public void setOrders(int orders) {
        this.orders = orders;
    }
    public void setEvent(String event) {
        this.event = event;
    }

    public Long getQuarter() {
        return quarter;
    }
    public Double getEfficiency() {
        return efficiency;
    }
    public Double getSpendings() {
        return spendings;
    }
    public Double getProfits() {
        return profits;
    }
    public int getOrders() {
        return orders;
    }
    public String getEvent() {
        return event;
    }

    public CompanyRepository() {

    }
}





