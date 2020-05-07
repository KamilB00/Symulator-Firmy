package symulator.app.finance;

public class Bank {
    private double amount;
    private double interest;
    private double percentage;
    private double installments;

    public double getAmount() {
        return amount;
    }

    public double getInterest() {
        return interest;
    }

    public double getPercentage() {
        return percentage;
    }

    public double getInstallments() {
        return installments;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public void setInstallments(double installments) {
        this.installments = installments;
    }

    public double returnAmount(){
        double calculate = getPercentage()*getAmount();
        return calculate;
    }

}
