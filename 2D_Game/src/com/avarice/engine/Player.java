package com.avarice.engine;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject {

    private Handler handler;


    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

    }

    public void tick() {
        x += velX;
        y += velY;

        x = Avarice.clamp(x, 0, Avarice.W - 48);
        y = Avarice.clamp(y, 0, Avarice.H - 72);

        collision();
    }

    public void collision() {
        for (int i = 0; i < handler.gameObjects.size(); i++) {
            GameObject tempObject = handler.gameObjects.get(i);

            if (tempObject.getId() == ID.BasicEnemy) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    //collision code
                    HUD.Health -= 2;

                }


            }


        }
    }

    public void render(Graphics g) {

        /*Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.green);
        g2d.draw(getBounds());*/

        g.setColor(Color.white);
        g.fillRect(x, y, 32, 32);
    }

    public Rectangle getBounds() {

        return new Rectangle(x, y, 32, 32);
    }
}