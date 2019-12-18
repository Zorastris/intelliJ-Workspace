package com.avarice.engine;

import javax.swing.*;
import java.awt.*;

public class Asteroid extends GameObject {
    private Handler handler;
    private ImageIcon icon = new ImageIcon("asteroid.jpg");
    private int height, width;
    double locationX = icon.getIconWidth() / 2;
    double locationY = icon.getIconHeight() / 2;
    private double rotationRequired = Math.toRadians (45);

    public Asteroid(int x, int y, ID id, Handler handler, int height, int width) {
        super(x, y, id);
        this.handler = handler;
        this.height = height;
        this.width = width;
    }

    public void tick() {

    }

    @Override
    public void render(Graphics g) {S
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
}
