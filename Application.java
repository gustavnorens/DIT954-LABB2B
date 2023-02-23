import GUI.ControlPanel;
import GUI.CarView;

import javax.swing.*;
import java.awt.*;

import Module.Vehicles.VehicleFactory;
import Module.World;
public class Application {
    public static void main(String[] args) {
        int X = 800;
        int Y = 800;
        int carViewHeight = 540;
        int delay = 50;

        World world = new World(X, carViewHeight, delay);
        world.add(VehicleFactory.createNewVolvo(0,0));
        world.add(VehicleFactory.createNewSaab(0,100));
        world.add(VehicleFactory.createNewScania(0,200));


        ControlPanel control = new ControlPanel(X, world);
        CarView view = new CarView(X, carViewHeight, world);

        world.addObserver(view);
        Window window = new Window("CarSim", X ,Y ,view , control);
    }

    /**
     * This class represents the full view of the MVC pattern of your car simulator.
     * It initializes with being center on the screen and attaching it's controller in it's state.
     * It communicates with the Controller by calling methods of it when an action fires of in
     * each of it's components.
     * TODO: Write more actionListeners and wire the rest of the buttons
     **/

    public static class Window extends JFrame {
        private final int X;
        private final int Y;
        private final CarView carView;
        private final ControlPanel control;
        // Constructor
        public Window(String frameName, int X, int Y, CarView carView, ControlPanel control){
            this.carView = carView;
            this.control = control;
            this.X = X;
            this.Y = Y;
            initComponents(frameName);
        }

        // Sets everything in place and fits everything
        // TODO: Take a good look and make sure you understand how these methods and components work
        private void initComponents(String title) {
            this.setTitle(title);
            this.setPreferredSize(new Dimension(X,Y));
            this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
            this.add(carView);
            this.add(control);

            // TODO: Create more for each component as necessary

            // Make the frame pack all it's components by respecting the sizes if possible.
            this.pack();
            // Get the computer screen resolution
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            // Center the frame
            this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
            // Make the frame visible
            this.setVisible(true);
            // Make sure the frame exits when "x" is pressed
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
}