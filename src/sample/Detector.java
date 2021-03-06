package sample;

/**
 * Created by Damian on 13.01.2018.
 */
public class Detector {
    public Detector(){}

    public static Signal measureSignal(double robot_x, double robot_y, Antena ant){
        Signal result = new Signal();
        result.setAntID(ant.getID());
        double ant_x = ant.getX();
        double ant_y = ant.getY();
        double diff_x = robot_x-ant_x;
        double diff_y = robot_y-ant_y;

        double distance = Math.sqrt(Math.pow(diff_x,2.0)+Math.pow(diff_y,2.0));
        double signalPower = (ant.getSignalRange()-distance)/ant.getSignalRange()*100;
        if(signalPower>=ant.getMinWorkingSignal())
            result.setSignalStrongEnough(true);
        else
            result.setSignalStrongEnough(false);
        result.setReceivedPowerSignal(signalPower);


        return result;
    }
}
