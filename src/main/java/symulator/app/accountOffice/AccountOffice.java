package symulator.app.accountOffice;

import symulator.app.company.Company;
import symulator.app.finance.OwnCapital;

public class AccountOffice {
    Company company = Company.getInstance();

private Double odliczonyVat = 0.0;
private Double vat = 0.0;

    private static AccountOffice instance = null;
    private AccountOffice(){}
    public static AccountOffice getInstance(){
        if(instance==null)
            instance = new AccountOffice();
        return instance;
    }

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

    /**
     * KWOTA PODSTAWOWEGO WYPOSAŻENIA PRACOWNIKA
     * @return
     */
    public Double costsOfEquipment() {
        double computerEquipment = 3500.0;
        double desk = 1500.0;
        double chair = 1000.0;
        double softwareLicence = 1000.0;
        Double eq = computerEquipment+desk+chair+softwareLicence;
        return eq;
    }

    /**
     * KWOTA VAT ZA WYPOSAŻENIE JEDNEGO PRACOWNIKA
     * @return
     */
    public Double equipmentVatTax(){
        Double eqTax = costsOfEquipment()*23/123.0;
        return  eqTax;
    }

    /**
     * LICZENIE KOSZTÓW ZWIĄZANYCH Z JEDNYM PRACOWNIKIEM
     */
    public void countCosts(){
       Double costs = company.workerEntities.size()*costsOfEquipment()+company.costsOfEmployees();
       company.setCompanyCosts(costs);
    }

}
