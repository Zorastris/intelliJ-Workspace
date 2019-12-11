package com.avarice.engine;

import java.awt.*;

public class HUD {

    public static int Health = 100;

    public void tick() {
        Health = Avarice.clamp(Health,0,100);
    }

    public void render(Graphics g) {
        g.drawString(Health+"%", 15, 15);
        g.setColor(Color.gray);
        g.fillRect(15, 15, 200, 32);
        g.setColor(Color.green);
        g.fillRect(15, 15, Health * 2, 32);
        g.setColor(Color.white);
        g.drawRect(15, 15, 200, 32);
    }
}
