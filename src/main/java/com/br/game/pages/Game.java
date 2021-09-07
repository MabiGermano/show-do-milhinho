package com.br.game.pages;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Game extends JFrame {
    private JPanel contentPane;
    private JLabel labelTitle;
    private GridBagConstraints constraints;

    public Game(String text){
        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450,100,450,331);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(new GridBagLayout());
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        System.out.println(text);
        generateTitle(text);

        add(contentPane);
    }

    public void generateTitle(String text){
        labelTitle = new JLabel();
        labelTitle.setText(text);

        constraints.insets = new Insets(50, 0,20 ,0);
        constraints.gridwidth = 3;
        constraints.gridx = 6;
        constraints.gridy = constraints.gridy + 1;
        contentPane.add(labelTitle, constraints);
    }
}
