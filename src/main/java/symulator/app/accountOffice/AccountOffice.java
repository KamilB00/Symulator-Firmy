package symulator.app.accountOffice;

import symulator.app.company.Company;

public class AccountOffice {

private Double vat;
private Double salaryTax;
private Double zus;
Company company = Company.getInstance();
    public Double getSalaryTax() {
        return salaryTax;
    }

    public Double getVat() {
        return vat;
    }

    public Double getZus() {
        return zus;
    }

    public void setSalaryTax(Double salaryTax) {
        this.salaryTax = salaryTax;
    }

    public void setVat(Double vat) {
        this.vat = vat;
    }

    public void setZus(Double zus) {
        this.zus = zus;
    }


    public Double equipmentVatTaxMonthly(){
        return  (costsOfEquipment()*23)/123.0;
    }

    public Double costsOfEquipment() {
        double computerEquipment = 3500.0;
        double desk = 1500.0;
        double chair = 700.0;
        double softwareLicence = 1000.0;
        return computerEquipment + desk + chair + softwareLicence;
    }
    public void countCosts(){
       Double costs = company.allEmployees()*costsOfEquipment()+company.costsOfEmployees();
       company.setCompanyCosts(costs);
    }

}
