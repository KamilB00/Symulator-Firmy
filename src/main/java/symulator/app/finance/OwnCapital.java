package symulator.app.finance;

import symulator.app.company.Company;

public class OwnCapital {

    //----------------------------------------------------------------------------------------------------------------
    /**
     * SINGLETON DLA KLASY OWNCAPITAL
     */
    private static OwnCapital instance = null;
    private OwnCapital(){}
    public static OwnCapital getInstance(){
        if(instance==null)
            instance = new OwnCapital();
        return instance;
    }
    //----------------------------------------------------------------------------------------------------------------
Company company = Company.getInstance();
    private Double amount;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
        System.out.println("Own Capital set --> "+ getAmount());
        company.setCompanyBudget(getAmount());
    }


}
