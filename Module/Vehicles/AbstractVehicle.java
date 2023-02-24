package Module.Vehicles;

import Module.Dir;

import java.awt.Color;

import Module.DoublePoint;

/** Car super-class */
public abstract class AbstractVehicle implements Drivable {

    /** Current direction of the of car */
    Dir dir;

    /** Width, Height, and length of the Car-Object */
    double width, height;

    /** Number of doors on the car */
    int nrDoors;

    /** Engine power of the car */
    double enginePower;

    /** The current speed of the car */
    double currentSpeed;

    /** Color of the car */
    Color color;

    /** The car model name */
    String modelName;

    /** X position in the 2d plane */
    DoublePoint position;

    /** Y position in the 2d plane */
    AbstractVehicle(int enginePower, String modelName, Color color, DoublePoint point, int nrDoors){
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.position = point;
        dir = Dir.EAST;
        stopEngine();
        this.width = 100;
        this.height = 60;

    }

    /** return the height of the car */
    public double getHeight() {
        return height;
    }

    /** returns the width of the car */
    public double getWidth() {
        return width;
    }

    /** returns the number of doors of the cars */
    public int getNrDoors(){
        return nrDoors;
    }

    /** return the engine power of the car */
    public double getEnginePower(){
        return enginePower;
    }

    /** returns the current speed of the car */
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    /** returns the color of the car */
    public Color getColor(){
        return color;
    }

    /** sets the color of the car */
    public void setColor(Color clr){
        color = clr;
    }

    /** sets the cars current speed to 0.1*/
    public void startEngine(){
        currentSpeed = 0.1;
    }

    /** sets the cars currentspeed to 0 */
    public void stopEngine(){
        currentSpeed = 0;
    }

    public Dir getDirection() {
        return dir;
    }

    /** moves the car by the current speed in its current direction*/
    @Override
    public void move(){
        switch (dir) {
            case NORTH -> position.move(0, currentSpeed);
            case SOUTH -> position.move(0, -currentSpeed);
            case WEST -> position.move(-currentSpeed, 0);
            case EAST -> position.move(currentSpeed,0);
        }
    }

    /** turns the car to the left */
    @Override
    public void turnLeft(){
        dir = switch (dir) {
            case NORTH -> Dir.WEST;
            case WEST -> Dir.SOUTH;
            case SOUTH -> Dir.EAST;
            case EAST -> Dir.NORTH;
        };
    }

    /** turns the car to the right */
    @Override
    public void turnRight(){
        dir = switch (dir) {
            case NORTH -> Dir.EAST;
            case WEST -> Dir.NORTH;
            case SOUTH -> Dir.WEST;
            case EAST -> Dir.SOUTH;
        };
    }

   /** returns the cars speedfactor */
   double speedFactor() {
        return enginePower * 0.01;
   }
   /** increases the speed of the car by a given amount */

   void incrementSpeed(double amount){
       currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
   }

   /** decreases the speed of the car by a given amount */
   void decrementSpeed(double amount){
       currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
   }

    // TODO fix this method according to lab pm
    /** gives gas to the car */
    public void gasProxy(double amount){
        if (amount > 1) {
            incrementSpeed(1);
        }
        else if (amount > 0 && amount <= 1) {
            incrementSpeed(amount);
        }
    }

    public void gas(double amount) {
        gasProxy(amount);
    }

    // TODO fix this method according to lab pm
    /** brakes the car */
    public void brake(double amount){
        if (amount > 1){
            decrementSpeed(1);
        }
        else if (amount > 0 && amount <= 1){
            decrementSpeed(amount);
        }
    }

    /** getModelName returns the modelName of the Vehicle */
    public String getModelName() {
        return modelName;
    }

    /** getX gets the X position of the Vehicle */
    public double getX(){
        return position.getX();
    }

    /** getY gets the Y position of the Vehicle */
    public double getY(){
        return position.getY();
    }

}
