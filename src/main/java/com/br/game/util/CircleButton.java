package com.br.game.util;

import com.br.game.models.gamemode.GameMode;
import com.br.game.models.stagestate.Stage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CircleButton extends JButton implements ActionListener {
    private Color bg;
    private Color fg;
    private Stage stage;
    private GameMode gameMode;
    private JFrame pageNow;
    private JFrame pageNext;

    public CircleButton(String text, Color bg, Color fg, Stage stage, GameMode gameMode, JFrame pageNow, JFrame pageNext) {
        super(text);

        this.bg = bg;
        this.fg = fg;
        this.stage = stage;
        this.gameMode = gameMode;
        this.pageNow = pageNow;
        this.pageNext = pageNext;

        Dimension size = getPreferredSize();
        size.width = size.height = Math.max(size.width, size.height);
        setPreferredSize(size);

        setContentAreaFilled(false);
        this.addActionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(this.bg);
            setForeground(this.fg);
        } else {
            g.setColor(getBackground());
            setForeground(this.fg);
        }
        g.fillRoundRect(0, 0, getSize().width - 1, getSize().height - 1, 13, 13);

        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawRoundRect(0, 0, getSize().width - 1, getSize().height - 1, 13,13);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.stage.setGameMode(this.gameMode);
        this.stage.getState().onChoose();

        this.pageNext.setVisible(true);
        this.pageNow.dispose();
    }
}
         
