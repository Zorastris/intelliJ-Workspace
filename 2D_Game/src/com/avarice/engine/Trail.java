package com.avarice.engine;

import java.awt.*;

public class Trail extends GameObject {

    private float alpha = 1;
    private Handler handler;
    private Color color;
    private int width, height;
    private float life;// = 0.001 - 0.1

    public Trail(int x, int y, ID id, Color color, int height, int width, float life, Handler handler) {
        super(x, y, id);
        this.handler=handler;
        this.color = color;
        this.width = width;
        this.height = height;
        this.life = life;
    }

    public void tick() {
        if (alpha > life) {
            alpha -= life - 0.001f;
        } else handler.removeObject(this);
    }

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(makeTransparent(alpha));
        g.setColor(color);
        g.fillRect(x, y, width, height);
        g2d.setComposite(makeTransparent(1));
    }

    //Never used
    public Rectangle getBounds() {
        return null;
    }

    private AlphaComposite makeTransparent(float alpha) {
        int type = AlphaComposite.SRC_OVER;
        return (AlphaComposite.getInstance(type, alpha));
    }

}
