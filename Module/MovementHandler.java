package Module;

import Module.Vehicles.Drivable;

public class MovementHandler {
    private static int carLength = 100;
    private static int carWidth = 60;
    public static boolean withinWorld(Drivable car, int x, int y){
        x -= carLength;
        y -= carWidth;
        boolean outsideWorld = car.getX() > x && car.getDirection() == Dir.EAST ||
                               car.getX() < 0 && car.getDirection() == Dir.WEST ||
                               car.getY() > y && car.getDirection() == Dir.SOUTH ||
                               car.getY() < 0 && car.getDirection() == Dir.NORTH;
        return !outsideWorld;
    }
}
