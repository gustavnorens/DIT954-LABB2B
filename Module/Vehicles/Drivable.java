package Module.Vehicles;

import Module.Dir;
/** Interface to implement the methods required by a movable object*/
public interface Drivable extends Drawable {
    /** asserts that all subtypes of Datamodules.Movable must implement move */
    void move();
    /** asserts that all subtypes of Datamodules.Movable must implement turnLeft */
    void turnLeft();
    /** asserts that all subtypes of Datamodules.Movable must implement turnRight */
    void turnRight();

    void gas(double amount);

    void brake(double amount);

    void startEngine();

    void stopEngine();

    Dir getDirection();
}
