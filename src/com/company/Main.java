package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
//Mariah McDonough
//Dice Roller Program
//April 25, 2022

public class Main extends JFrame implements ActionListener {
    static int action = 0;
    JButton roll;
    JButton quit;
    Container diceGame;

    Main() {
        diceGame = getContentPane();
        diceGame.setLayout(new FlowLayout());
        roll = new JButton("Click Here to Roll The Dice!");
        roll.addActionListener(this);
        diceGame.add(roll);
        quit = new JButton("Click Here to Quit");
        diceGame.add(quit);

        ArrayList<Integer> banking = new ArrayList<>();
        JLabel enter = new JLabel("Enter the Amount of Money You Want To Bet And Click Add: ");
        JTextField bank = new JTextField(10);
        JButton add = new JButton("Add");
        diceGame.add(add);

        add.addActionListener(this);
        bank.addActionListener(this);
        bank.setLocation(300, 300);

        diceGame.add(enter);
        diceGame.add(bank);
        JLabel display = new JLabel("Bank Amount: ");
        diceGame.add(display);

        JTextField showBank = new JTextField(20);
        diceGame.add(showBank);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer addToBank = Integer.valueOf(bank.getText().trim());
                banking.add(addToBank);
                int sum = 0;
                for (Integer integer : banking) sum += integer;
                showBank.setText(String.valueOf(sum));
            }
        });
        quit.addActionListener(e -> System.exit(0));
    }

    public void paint(Graphics g) {

//creating dice inside frame
        super.paint(g);
        final int WIDTH = 400, HEIGHT = 175;
        g.setColor(Color.BLACK);
        g.fill3DRect(30, 400, WIDTH, HEIGHT, true);

        Graphics2D diceX = (Graphics2D) g;
        diceX.drawRect(70, 430, 100, 100);
        diceX.setPaint(Color.WHITE);
        diceX.fillRect(70, 430, 100, 100);

        Graphics2D diceY = (Graphics2D) g;
        diceY.drawRect(275, 430, 100, 100);
        diceY.setPaint(Color.WHITE);
        diceY.fillRect(275, 430, 100, 100);

        if (action == 0) {

            //drawing left die with 3 eyes
            drawEye(g, 85, 455);
            drawEye(g, 130, 455);
            drawEye(g, 110, 490);

            //drawing right die with five eyes
            drawEye(g, 290, 445);
            drawEye(g, 340, 445);
            drawEye(g, 315, 470);
            drawEye(g, 290, 500);
            drawEye(g, 340, 500);

            action = 1;

        } else if (action == 1) {
            // drawing left eye with two eyes
            drawEye(g, 87, 465);
            drawEye(g, 129, 465);

            //drawing right die with six eyes
            drawEye(g, 280, 455);
            drawEye(g, 350, 455);
            drawEye(g, 315, 455);
            drawEye(g, 280, 490);
            drawEye(g, 315, 490);
            drawEye(g, 350, 490);

            JOptionPane.showMessageDialog(null, "Please roll again");
            action = 2;

        } else if (action == 2) {
            //drawing left die with one eye
            drawEye(g, 110, 462);
            drawEye(g, 110, 462);

            //drawing right die with three eyes
            drawEye(g, 290, 455);
            drawEye(g, 340, 455);
            drawEye(g, 315, 490);

            JOptionPane.showMessageDialog(null, "Congrats, you win double your bet! Press the Add button to to double your bank");
            action = 3;

        } else if (action == 3) {

            //drawing left die with four eyes
            drawEye(g, 85, 450);
            drawEye(g, 130, 450);
            drawEye(g, 85, 485);
            drawEye(g, 130, 485);


            //drawing right die with two eyes
            drawEye(g, 298, 465);
            drawEye(g, 330, 465);

            JOptionPane.showMessageDialog(null, "You win an extra $100! ");
            action = 4;

        } else if (action == 4) {

            //drawing left die with 5 eyes
            drawEye(g, 85, 445);
            drawEye(g, 130, 445);
            drawEye(g, 110, 470);
            drawEye(g, 85, 500);
            drawEye(g, 130, 500);

            //drawing die with one eye
            drawEye(g, 315, 462);

            JOptionPane.showMessageDialog(null, "Sorry, you lose your bank. Please play again.");
            action = 5;

        } else if (action == 5) {
            //drawing left eye with six eyes
            drawEye(g, 80, 455);
            drawEye(g, 140, 455);
            drawEye(g, 110, 455);
            drawEye(g, 80, 490);
            drawEye(g, 110, 490);
            drawEye(g, 140, 490);

            //drawing right die with four eyes
            drawEye(g, 290, 450);
            drawEye(g, 340, 450);
            drawEye(g, 290, 485);
            drawEye(g, 340, 485);

            JOptionPane.showMessageDialog(null, "Please roll again");

            action = 0;
        }
    }

    private void drawEye(Graphics g, int x, int y) {
        Graphics2D dice = (Graphics2D) g;
        dice.drawOval(x, y, 20, 20);
        dice.setPaint(Color.BLACK);
        dice.fillOval(x, y, 20, 20);
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public static void main(String[] args) {
        Main m1 = new Main();
        m1.setTitle("Dice Roller by Mariah McDonough");
        m1.setSize(500, 700);
        m1.setVisible(true);
        m1.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}