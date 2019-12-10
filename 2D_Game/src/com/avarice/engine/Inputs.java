package com.avarice.engine;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Inputs extends KeyAdapter {

    private Handler handler;

    public Inputs(Handler handler){
        this.handler=handler;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for(int i= 0;i < handler.gameObjects.size();i++){
            GameObject tempObject = handler.gameObjects.get(i);

            if(tempObject.getId()== ID.Player){
                //key events for Player1

                if(key == KeyEvent.VK_W)tempObject.setVelY(-5);
                if(key == KeyEvent.VK_S)tempObject.setVelY(+5);
                if(key == KeyEvent.VK_D)tempObject.setVelX(+5);
                if(key == KeyEvent.VK_A)tempObject.setVelX(-5);

            }
            if(tempObject.getId() == ID.Player2){

                if(key == KeyEvent.VK_UP)tempObject.setVelY(-5);
                if(key == KeyEvent.VK_DOWN)tempObject.setVelY(5);
                if(key == KeyEvent.VK_RIGHT)tempObject.setVelX(5);
                if(key == KeyEvent.VK_LEFT)tempObject.setVelX(-5);

            }
        }

        if(key == KeyEvent.VK_ESCAPE )  System.exit(0);

    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();


    }
}
