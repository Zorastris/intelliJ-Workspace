package com.avarice.engine;

import java.awt.*;
import java.util.LinkedList;

public class Handler {
    LinkedList<GameObject> gameObjects = new LinkedList<GameObject>();

    public void tick() {

        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject tempObject = gameObjects.get(i);

            tempObject.tick();

        }

    }

    public void render(Graphics g) {

        for (int i = 0; i < gameObjects.size(); i++) {

            GameObject tempObject = gameObjects.get(i);

            tempObject.render(g);

        }
    }

    public void addObject(GameObject object) {
        this.gameObjects.add(object);
    }

    public void removeObject(GameObject object) {
        this.gameObjects.remove(object);
    }


}
