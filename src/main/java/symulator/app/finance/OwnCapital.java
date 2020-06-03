package symulator.app.finance;

public class OwnCapital {

    private static OwnCapital instance = null;
    private OwnCapital(){}
    public static OwnCapital getInstance(){
        if(instance==null)
            instance = new OwnCapital();
        return instance;
    }

    private double amount;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
