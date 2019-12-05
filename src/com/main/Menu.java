package com.main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements Runnable, ActionListener {
    JFrame f;
    JTextField seats,agents,wait;
    JButton create,book;
    JPanel pan;



    public Menu(){
        f = new JFrame();
        init();

        f.setSize(500,500);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible(true);
        f.setResizable(false);

    }




    public void init(){
        seats = new JTextField();
        seats.setSize(100,50);
        seats.setLocation(100,50);
        seats.setText("No of Seats");
        f.add(seats);

        agents = new JTextField();
        agents.setSize(100,50);
        agents.setLocation(250,50);
        agents.setText("No of Agents");
        f.add(agents);

        wait = new JTextField();
        wait.setSize(100,50);
        wait.setLocation(400,50);
        wait.setText("Max wait time");
        f.add(wait);


    }





    public static void main(String[] args) {

        new Menu();
    }







    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void run() {

    }
}
