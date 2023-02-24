package Module.Vehicles;

import java.awt.*;

import Module.DoublePoint;
public class Scania extends AbstractVehicle implements HasTrailer {
    private double trailerTilt;
    private TrailerState state;

    /** constructor for Scania */   /** Constructor */
    Scania(DoublePoint point){
        super(100, "Scania", Color.white, point, 2);
        trailerTilt = 0;
        state = new DownState();
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
       if (deg > 0) {
           state = new UpState();
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
        if (trailerTilt == 0) {
            state = new DownState();
        }
    }

    /** Returns the current trailer tilt */     /** returns the current trailer tilt */
    public double getTrailerTilt(){
        return trailerTilt;
    }

    private boolean canDrive() {
        return trailerTilt == 0;
    }
    public void gas(double amount){
        state.gas(amount);
    }
    public void startEngine(){
        if (canDrive()){
            super.startEngine();
        }
    }
    class UpState implements TrailerState{
        public void gas(double amount){

        }
    }

    class DownState implements TrailerState {
        public void gas(double amount){
            Scania.super.gas(amount);
        }
    }
}


