package symulator.app.accountOffice;

import symulator.app.company.Company;

public class AccountOffice {

private Double odliczonyVat = 0.0;
private Double vat = 0.0;

Company company = Company.getInstance();

    public Double getOdliczonyVat() {
        return odliczonyVat;
    }
    public void setOdliczonyVat(Double odliczonyVat) {
        this.odliczonyVat = odliczonyVat;
    }

    public void setVat(Double vat) {
        this.vat = vat;
    }

    public Double getVat() {
        return vat;
    }

    public Double costsOfEquipment() {
        double computerEquipment = 3500.0;
        double desk = 1500.0;
        double chair = 1000.0;
        double softwareLicence = 1000.0;
        Double eq = computerEquipment+desk+chair+softwareLicence;
        return eq;
    }
    public Double equipmentVatTax(){
        Double eqTax = costsOfEquipment()*23/123.0;
        return  eqTax;
    }
    public void countCosts(){
       Double costs = company.allEmployees()*costsOfEquipment()+company.costsOfEmployees();
       company.setCompanyCosts(costs);
    }

}
