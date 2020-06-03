package symulator.app.finance;

import symulator.simulation.SimulationClock;

import java.util.Random;

public class VC {
    private double amount;
    private double shares;


    private static VC instance = null;
    private VC(){}
    public static VC getInstance(){
        if(instance==null)
            instance = new VC();
        return instance;
    }

    public void setAmount(double amount) {

        this.amount = amount;
        System.out.println("VC ustawion amount ---> "+ amount);
    }

    public double getAmount() {
        return amount;
    }

    public void setShares(double shares) {

        this.shares = shares;
        System.out.println("VC ustawiono shares --> "+ shares);
    }

    public double getShares() {
        return shares;
    }
}
