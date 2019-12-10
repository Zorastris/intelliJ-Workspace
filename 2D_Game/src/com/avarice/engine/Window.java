package com.avarice.engine;

import javax.swing.*;
import java.awt.*;

public class Window extends Canvas {
    JFrame f;

    public Window(int width, int height, String title, Avarice A){
        f = new JFrame(title);
        f.setPreferredSize(new Dimension(width,height));
        f.setMaximumSize(new Dimension(width,height));
        f.setMinimumSize(new Dimension(width,height));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.add(A);
        f.setVisible(true);
        A.start();
    }

    private void init(){





    }


}
