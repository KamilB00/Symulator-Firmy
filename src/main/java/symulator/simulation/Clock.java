package symulator.simulation;

public class Clock {

    private static Clock instance = new Clock();


    private Clock(){}


    public static Clock getInstance(){

        return instance;
    }


}
