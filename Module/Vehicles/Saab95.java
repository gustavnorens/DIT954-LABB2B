package Module.Vehicles;
import Module.DoublePoint;


import java.awt.*;

/** Subclass of car, represents the Saab 95 */
public class Saab95 extends AbstractVehicle implements HasTurbo{

    /** turbo of the car */
    private boolean turboOn;

    /** constructor */
    Saab95(DoublePoint point){
        super(125,"Saab95", Color.red, point,2);
        turboOn = false;
    }

    /** turns on the cars turbo */
    public void setTurboOn(){
        turboOn = true;
    }

    /** turns off the cars turbo */
    public void setTurboOff(){
        turboOn = false;
    }


    /** returns the cars speedfactor */
    @Override
    double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }
}
