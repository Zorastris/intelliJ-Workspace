package com.avarice.engine;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Avarice extends Canvas implements Runnable {
    public static final int W = 640, H = W / 12 * 9;
    private Thread t1;
    private boolean running = false;
    private Random ran;
    private Handler handler;
    private HUD hud;

    public Avarice() {
        handler = new Handler();
        this.addKeyListener(new Inputs(handler));
        new Window(W, H, "Avarice", this);

        hud = new HUD();

        ran = new Random();

        handler.gameObjects.add(new Player(100, 100, ID.Player, handler));
        handler.gameObjects.add(new BasicEnemy(ran.nextInt(W), H / 2 - 32, ID.BasicEnemy, handler));
        handler.gameObjects.add(new BasicEnemy(ran.nextInt(W), H / 2 - 32, ID.BasicEnemy, handler));
        handler.gameObjects.add(new BasicEnemy(ran.nextInt(W), H / 2 - 32, ID.BasicEnemy, handler));
        handler.gameObjects.add(new BasicEnemy(ran.nextInt(W), H / 2 - 32, ID.BasicEnemy, handler));
        handler.gameObjects.add(new Asteroid(ran.nextInt(W), H / 2 - 32, ID.Asteroid, handler,5,10));
    }

    public static int clamp(int var, int min, int max) {
        if (var >= max)
            return var = max;
        else if (var <= min)
            return var = min;
        else
            return var;

    }

    public static void main(String[] args) {
        new Avarice();
    }

    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running)
                render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0, 0, W, H);

        handler.render(g);
        hud.render(g);

        g.dispose();
        bs.show();
    }

    private void tick() {
        handler.tick();
        hud.tick();
    }

    public synchronized void start() {
        t1 = new Thread(this);
        t1.start();
        running = true;

    }

    public synchronized void stop() {
        try {
            t1.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
