package com.br.game.pages;

import com.br.game.util.CircleButton;
import com.br.game.util.RoundedBorder;
import com.google.common.io.Resources;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JLabel labelIcon;
    private JLabel labelPontuacao;
    private JButton buttonFacil;
    private JLabel title;
    private GridBagConstraints constraints;

    public Home(){
        //Inicializando o constraint
        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        //Adicionando informações do JPanel
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450,100,450,331);
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
        setUndecorated(true);
    }

    public static void main(String[] args) {
        Home home = new Home();

        home.setVisible(true);
    }

    private void generateIcon(){
        ImageIcon img = new ImageIcon(new ImageIcon(Resources.getResource("images/show-do-milhinho.png")).getImage().getScaledInstance(352,58,Image.SCALE_DEFAULT));
        labelIcon = new JLabel();
        labelIcon.setIcon(img);
        labelIcon.setPreferredSize(new Dimension(352,58));

        constraints.gridwidth = 8;
        constraints.gridx = 2;
        constraints.gridy = 0;
        contentPane.add(labelIcon, constraints);
    }

    public void generatePoints(){
        labelPontuacao = new JLabel();
        labelPontuacao.setText("Melhor sequencia: ");
        labelPontuacao.setBounds(10,100,117,14);
        constraints.gridwidth = 1;
        constraints.gridx = 2;
        constraints.gridy = 1;
        contentPane.add(labelPontuacao, constraints);
    }

    public void generateButton(Color color, String text){
        CircleButton button = new CircleButton(text, color, Color.WHITE);
        button.setBackground(color);
        button.setPreferredSize(new Dimension(296, 21));

        button.addActionListener(this);

        constraints.insets = new Insets(10, 0,0 ,0);
        constraints.gridwidth = 8;
        constraints.gridx = 2;
        constraints.gridy = constraints.gridy + 1;
        contentPane.add(button, constraints);
    }

    public void generateTitle(){
        title = new JLabel();
        title.setText("Modo do jogo");

        constraints.insets = new Insets(50, 0,20 ,0);
        constraints.gridwidth = 3;
        constraints.gridx = 6;
        constraints.gridy = constraints.gridy + 1;
        contentPane.add(title, constraints);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Game novaJanela = new Game(e.getActionCommand());
        novaJanela.setVisible(true);

        this.dispose();
    }

}
