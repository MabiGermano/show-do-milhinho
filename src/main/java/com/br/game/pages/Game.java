package com.br.game.pages;

import com.br.game.models.stagestate.Stage;
import com.br.game.util.CircleButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame implements ActionListener {
    private JPanel contentPane;
    private JLabel labelTitle;
    private GridBagConstraints constraints;
    private Button button;
    private Stage stage;

    public Game(Stage stage){
        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        this.stage = stage;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450,100,450,331);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(new GridBagLayout());
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        generateTitle("Teste");
        generateButton(Color.BLACK, "Clique");
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

    public void generateButton(Color color, String text){
        this.button = new Button();
        this.button.setLabel(text);
        this.button.setBackground(color);
        this.button.setPreferredSize(new Dimension(296, 21));

        this.button.addActionListener(this);
        constraints.insets = new Insets(10, 0,0 ,0);
        constraints.gridwidth = 8;
        constraints.gridx = 2;
        constraints.gridy = constraints.gridy + 1;
        contentPane.add(this.button, constraints);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(this.stage.getGameMode());
    }
}
