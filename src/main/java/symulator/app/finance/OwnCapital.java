package symulator.app.finance;

import symulator.app.company.Company;

public class OwnCapital {

    private static OwnCapital instance = null;
    private OwnCapital(){}
    public static OwnCapital getInstance(){
        if(instance==null)
            instance = new OwnCapital();
        return instance;
    }
Company company = Company.getInstance();
    private Double amount;

    VC vc = VC.getInstance();
    Bank bank = Bank.getInstance();
    Investor investor = Investor.getInstance();

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
        System.out.println("Own Capital set --> "+ getAmount());
        company.setCompanyBudget(getAmount());
    }


}
