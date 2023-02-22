package Module.Vehicles;
import Module.DoublePoint;

public abstract class VehicleFactory {

    public static HasTurbo createNewSaab(double x, double y){
        return new Saab95(new DoublePoint(x,y));
    }

    public static Drivable createNewVolvo(double x, double y){
        return new Volvo240(new DoublePoint(x,y));
    }

    public static HasTrailer createNewScania(double x, double y){
        return new Scania(new DoublePoint(x,y));
    }
}

