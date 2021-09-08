package com.br.game.pages;

import com.br.game.models.stagestate.Stage;
import com.br.game.util.CircleButton;
import com.google.common.io.Resources;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Finish extends JFrame implements ActionListener {
    private JPanel contentPane;
    private JLabel title;
    private JLabel labelIcon;
    private GridBagConstraints constraints;
    private Stage stage;

    public Finish(Stage stage){
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
        //Adicionando o icone
        generateIcon();
        add(contentPane);
//        setUndecorated(true);
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

    public void generateTitle(){
        title = new JLabel();
        int points = this.stage.getQuestionsAnswered().size();
        title.setText("Final de jogo, você acertou: " + points);
        title.setForeground(Color.decode("#E7A131"));
        constraints.insets = new Insets(50, 0,20 ,0);
        constraints.gridwidth = 3;
        constraints.gridx = 6;
        constraints.gridy = constraints.gridy + 1;
        contentPane.add(title, constraints);
    }

    public void generateButton(Color color, String text){
        Button button = new Button();
        button.setLabel(text);
        button.setBackground(color);
        button.setPreferredSize(new Dimension(296, 21));
        button.addActionListener(this);

        constraints.insets = new Insets(10, 0,0 ,0);
        constraints.gridwidth = 8;
        constraints.gridx = 2;
        constraints.gridy = constraints.gridy + 1;
        contentPane.add(button, constraints);
    }

    public void finalizaJogo(){
        this.setVisible(true);

        generateTitle();
        generateButton(Color.CYAN, "Sair");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Home home = new Home(this.stage);
        home.setVisible(true);
        this.dispose();
    }
}
