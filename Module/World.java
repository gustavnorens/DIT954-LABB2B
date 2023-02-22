package Module;

import Module.Vehicles.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class World {
    private final List<Drivable> drivables;
    private final List<HasTurbo> turbos;
    private final List<HasTrailer> trucks;
    private final List<Observer> observers;
    private final Timer timer;

    public final int TILTAMOUNT = 10;
    private final int width, height;

    private int startingYValue = 0;

    public World(int width, int height, int delay) {
        this.width = width;
        this.height = height;
        timer = new Timer(delay,new TimerListener());
        timer.start();
        drivables = new ArrayList<>();
        turbos = new ArrayList<>();
        trucks = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public void add(Drivable car) {
        drivables.add(car);
        startingYValue += 100;
    }

    public void add(HasTurbo car) {
        turbos.add(car);
        drivables.add(car);
        startingYValue += 100;
    }

    public void add(HasTrailer car) {
        trucks.add(car);
        drivables.add(car);
        startingYValue += 100;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public List<Drivable> getDrivables() { return drivables; }

    public List<HasTrailer> getTrucks() {
        return trucks;
    }

    public List<HasTurbo> getTurbos() {return turbos; }

    public List<Drawable> getDrawables() { //Möjligen skulle vi kunna parametrisera denna?
        List<Drawable> drawables = new ArrayList<>();
        for (Drivable d : getDrivables()){
            drawables.add(d);
        }
        return drawables;
    }

    public void removeLatest() {
        if (!drivables.isEmpty()) {
            Drivable removedCar = drivables.remove(drivables.size() - 1);
            if (removedCar.equals(getLastElement(turbos))) {
                turbos.remove(turbos.size() - 1);
            } else if (removedCar.equals(getLastElement(trucks))) {
                trucks.remove(trucks.size() - 1);
            }
        }
        startingYValue -= 100;
    }

    public void addRandomCar(){
        if (drivables.size() < 5) {
            Random rand = new Random();
            int s = rand.nextInt(3);
            switch(s) {
                case 0:
                    add(VehicleFactory.createNewVolvo(0, startingYValue));
                    break;
                case 1:
                    add(VehicleFactory.createNewSaab(0,startingYValue));
                    break;
                case 2:
                    add(VehicleFactory.createNewScania(0,startingYValue));
                    break;
            }
        }
    }

    private <T extends Drivable> T getLastElement (List<T> cars) {
        if (cars.isEmpty()) {
            return null;
        }
        else {
            return cars.get(cars.size() - 1);
        }
    }

    private void notifyObservers() {
        for (Observer o : observers) {
            o.update();
        }
    }
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Drivable d : getDrivables())  {
                d.move();
                if (!MovementHandler.withinWorld(d,width,height)) {
                    d.stopEngine();
                    d.turnRight();
                    d.turnRight();
                    d.startEngine();
                }
                // Collision check
            }
            notifyObservers();
        }
    }
}
