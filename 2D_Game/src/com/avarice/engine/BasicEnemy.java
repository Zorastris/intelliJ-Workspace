package com.avarice.engine;

import java.awt.*;

public class BasicEnemy extends GameObject {

    public BasicEnemy(int x, int y, ID id) {
        super(x, y, id);

        velX = 5;
        velY = 5;

    }


    public void tick() {
        x += velX;
        y += velY;
        /*x = Avarice.clamp(x,0,Avarice.W-48);
        y = Avarice.clamp(y,0,Avarice.H-72);*/
        if (y <= 0 || y >= Avarice.H - 32) {
            velY *= -1;
        }
        if (x <= 0 || x >= Avarice.W - 16) {
            velX *= -1;
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, 16, 16);
    }

    public Rectangle getBounds() {

        return new Rectangle(x,y,16,16);
    }
}
