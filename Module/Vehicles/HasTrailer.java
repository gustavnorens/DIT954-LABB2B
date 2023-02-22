package Module.Vehicles;

public interface HasTrailer extends Drivable {
    void increaseTrailerTilt(double deg);
    void decreaseTrailerTilt(double deg);
}
