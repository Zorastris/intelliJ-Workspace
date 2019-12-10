package com.avarice.engine;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject {

    Random r = new Random();

    public Player(int x, int y, ID id) {
        super(x, y, id);


    }


    public void tick() {
        x += velX;
        y += velY;

        x = Avarice.clamp(x,0,Avarice.W-48);
        y = Avarice.clamp(y,0,Avarice.H-72);
    }



    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g.setColor(Color.green);
        g.drawRect();

       /* g.setColor(Color.white);
        g.fillRect(x,y,32,32);*/
    }

    public Rectangle getBounds() {

        return new Rectangle(x,y,32,32);
    }
}