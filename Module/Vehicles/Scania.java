package Module.Vehicles;

import java.awt.*;

import Module.DoublePoint;
public class Scania extends AbstractVehicle implements HasTrailer {
    private double trailerTilt;

    /** constructor for Scania */   /** Constructor */
    Scania(DoublePoint point){
        super(100, "Scania", Color.white, point, 2);
        trailerTilt = 0;
    }

    /** Increases the trailer tilt by a chosen amount of degrees */     /** Increases the trailer tilt a given amount of degrees */
    public void increaseTrailerTilt(double deg){
       if (currentSpeed == 0 && deg >= 0) {
           if (deg + trailerTilt > 70) {
               trailerTilt = 70;
               return;
           }
           trailerTilt += deg;
       }
    }

     /** decreases the trailer tilt a chosen amount of degrees */
    public void decreaseTrailerTilt(double deg){
        if (currentSpeed == 0 && deg >= 0) {
            if (trailerTilt - deg < 0) {
                trailerTilt = 0;
                return;
            }
            trailerTilt -= deg;
        }
    }

    /** Returns the current trailer tilt */     /** returns the current trailer tilt */
    public double getTrailerTilt(){
        return trailerTilt;
    }

    private boolean canDrive() {
        if (trailerTilt > 0) {
            return false;
        }
        return true;
    }
    public void gas(double amount){
        if (canDrive()){
            super.gas(amount);
        }
    }
    public void startEngine(){
        if (canDrive()){
            super.startEngine();
        }
    }
}
