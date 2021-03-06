package com.br.game.pages;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.br.game.models.gamemode.EasyMode;
import com.br.game.models.gamemode.GameMode;
import com.br.game.models.gamemode.HardMode;
import com.br.game.models.gamemode.IntermediateMode;
import com.br.game.models.stagestate.ReadyToPlay;
import com.br.game.models.stagestate.Stage;
import com.br.game.util.CircleButton;
import com.google.common.io.Resources;

public class Home extends JFrame{

    private JPanel contentPane;
    private JLabel labelIcon;
    private JLabel labelPontuacao;
    private JLabel title;
    private GridBagConstraints constraints;
    private Stage stage;

    public Home(Stage stage){
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
        //Adicionando o Label de pontuação
        generatePoints();
        generateTitle();
        generateButton(Color.GREEN, "Facil");
        generateButton(Color.BLUE, "Intermediario");
        generateButton(Color.MAGENTA, "Dificil");
        add(contentPane);
//        setUndecorated(true);
        ReadyToPlay readyToPlayState = new ReadyToPlay(this.stage);
        this.stage.changeState(readyToPlayState);
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

    public void generatePoints(){
        labelPontuacao = new JLabel();
        int points = this.stage.getQuestionsAnswered() != null ? this.stage.getQuestionsAnswered().size() : 0;
        labelPontuacao.setText("Melhor sequencia: "+ points);
        labelPontuacao.setBounds(10,100,117,14);
        constraints.gridwidth = 1;
        constraints.gridx = 2;
        constraints.gridy = 1;
        contentPane.add(labelPontuacao, constraints);
    }

    public void generateButton(Color color, String text){
        CircleButton button = new CircleButton(text, color, Color.WHITE, this.stage);
        button.setGameMode(getGameMode(text));
        button.setPageNow(this);
        button.setPageNext(new Game(this.stage));
        button.setBackground(color);
        button.setPreferredSize(new Dimension(296, 21));

        constraints.insets = new Insets(10, 0,0 ,0);
        constraints.gridwidth = 8;
        constraints.gridx = 2;
        constraints.gridy = constraints.gridy + 1;
        contentPane.add(button, constraints);
    }

    public void generateTitle(){
        title = new JLabel();
        title.setText("Modo do jogo");
        title.setForeground(Color.decode("#E7A131"));
        constraints.insets = new Insets(50, 0,20 ,0);
        constraints.gridwidth = 3;
        constraints.gridx = 6;
        constraints.gridy = constraints.gridy + 1;
        contentPane.add(title, constraints);
    }

    private GameMode getGameMode(String mode){
        switch (mode){
            case "Facil":
                return new EasyMode();
            case "Intermediario":
                return new IntermediateMode();
            case "Dificil":
                return new HardMode();
        }
        return null;
    }

}
