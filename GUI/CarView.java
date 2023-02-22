package GUI;

import Module.Vehicles.Drawable;
import Module.Observer;
import Module.World;

import java.util.List;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class CarView extends JPanel implements Observer {
    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;
    private World world;
    public CarView(int x, int y, World world) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.world = world;
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "CarGraphics.pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Datamodules.Vehicles.Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: CarGraphics.pics -> MOVE *.jpg to CarGraphics.pics.
            // if you are starting in IntelliJ.
            volvoImage = ImageIO.read(CarView.class.getResourceAsStream("pics/Volvo240.jpg"));
            saabImage = ImageIO.read(CarView.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(CarView.class.getResourceAsStream("pics/Scania.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Drawable d : world.getDrawables()){
            int x = (int)Math.round(d.getX());
            int y = (int)Math.round(d.getY());
            String modelName = d.getModelName();
            g.drawImage(getImage(modelName),x,y,null);
        }
    }

    private BufferedImage getImage(String modelName) {
        switch (modelName) {
            case "Volvo240":
                return volvoImage;
            case "Saab95":
                return saabImage;
            case "Scania":
                return scaniaImage;
        }
        return null;
    }

    @Override
    public void update() {
        repaint();
    }
}
