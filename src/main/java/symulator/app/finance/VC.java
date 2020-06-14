package symulator.app.finance;

import symulator.app.company.Company;


public class VC {
    private Double amount;
    private Double shares;


    private static VC instance = null;
    private VC(){}
    public static VC getInstance(){
        if(instance==null)
            instance = new VC();
        return instance;
    }

Company company = Company.getInstance();
    public void setAmount(Double amount) {

        this.amount = amount;
        System.out.println("VC ustawion amount ---> "+ amount);
        company.setCompanyBudget(getAmount());
    }

    public Double getAmount() {
        return amount;
    }

    public void setShares(Double shares) {
        this.shares = shares;
        System.out.println("VC ustawiono shares --> "+ shares);
    }

    public Double getShares() {
        return shares;
    }
}
