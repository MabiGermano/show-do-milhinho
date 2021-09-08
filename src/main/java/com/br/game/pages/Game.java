package com.br.game.pages;

import com.br.game.models.stagestate.Stage;
import com.br.game.util.CircleButton;
import com.google.common.io.Resources;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Set;

public class Game extends JFrame {
    private JPanel contentPane;
    private JLabel labelTitle;
    private JLabel labelIcon;
    private GridBagConstraints constraints;
    private Stage stage;

    public Game(Stage stage){
        this.stage = stage;
        //Inicializando o constraint
        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        //Adicionando informações do JPanel
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0,0,1024,720);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(new GridBagLayout());
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        add(contentPane);
        setUndecorated(true);
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


    private void generateIcon(){
        ImageIcon img = new ImageIcon(new ImageIcon(Resources.getResource("images/show-do-milhinho.png")).getImage().getScaledInstance(352,58,Image.SCALE_DEFAULT));
        labelIcon = new JLabel();
        labelIcon.setIcon(img);
        labelIcon.setPreferredSize(new Dimension(1200,720));

        constraints.gridwidth = 8;
        constraints.gridx = 2;
        constraints.gridy = 0;
        contentPane.add(labelIcon, constraints);
    }

    public void generateButton(Color color, String text){
        CircleButton button = new CircleButton(text, color, Color.WHITE, this.stage);
        button.setBackground(color);
        button.setPreferredSize(new Dimension(296, 21));
        button.setBackground(color);
        button.setPreferredSize(new Dimension(296, 21));

        constraints.insets = new Insets(10, 0,0 ,0);
        constraints.gridwidth = 8;
        constraints.gridx = 2;
        constraints.gridy = constraints.gridy + 1;
        contentPane.add(button, constraints);
    }

    private void generateAnswers(Set<String> answers){
        Iterator<String> answersAsIterator = answers.iterator();
        while (answersAsIterator.hasNext()){
            generateButton(Color.decode("#9F9F9F"), answersAsIterator.next());
        }
    }

    public void refreshGame(){
        if(!this.isVisible()){
            this.setVisible(true);
        }
        this.contentPane.removeAll();
        if(this.stage.getCurrentQuestion() != null){
            generateIcon();
            generateTitle(this.stage.getCurrentQuestion().getTitle());
            generateAnswers(this.stage.getCurrentQuestion().getWrongAnswers());
        }
    }
}
