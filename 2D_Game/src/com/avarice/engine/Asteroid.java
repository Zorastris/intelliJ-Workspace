package com.avarice.engine;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Asteroid extends GameObject {
    private Handler handler;
    private ImageIcon icon = new ImageIcon("asteroid.jpg");
    private int height, width;
    private BufferedImage image;
    double locationX = icon.getIconWidth() / 2;
    double locationY = icon.getIconHeight() / 2;
    private double rotationRequired = Math.toRadians (45);

    public Asteroid(int x, int y, ID id, Handler handler, int height, int width) {
        super(x, y, id);
        this.handler = handler;
        this.height = height;
        this.width = width;
    }

    public void loadOriginalImage(File file) {
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void tick() {

    }

    public void render(Graphics g) {
        g.drawImage(image, 0, 0, (ImageObserver) this);
    }

    public Rectangle getBounds() {
        return null;
    }
}
