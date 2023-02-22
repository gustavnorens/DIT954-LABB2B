package Module.Vehicles;

import Module.DoublePoint;
import java.awt.*;

/** Subclass of car, represents the 240 */
public class Volvo240 extends AbstractVehicle implements Drivable{

    /** the trimfactor of the car */
    private final static double trimFactor = 1.25;

    /** constructor */
    Volvo240(DoublePoint point){
        super(100, "Volvo240",Color.black, point, 4);
    }


    /** returns the cars speedfactor */
    @Override
    double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }
}
