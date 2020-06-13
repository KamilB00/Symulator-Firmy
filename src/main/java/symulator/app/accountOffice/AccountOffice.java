package symulator.app.accountOffice;

public class AccountOffice {
private Double vat;
private Double salaryTax;
private Double zus;

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


}
