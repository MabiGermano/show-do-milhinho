package com.br.game.util;

import com.br.game.models.Question;
import com.br.game.models.gamemode.GameMode;
import com.br.game.models.stagestate.Stage;
import com.br.game.pages.Finish;
import com.br.game.pages.Game;

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
    private Game pageNext;

    public CircleButton(String text, Color bg, Color fg, Stage stage) {
        super(text);

        this.bg = bg;
        this.fg = fg;
        this.stage = stage;

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
        if(pageNow != null && pageNext != null){
            this.stage.setGameMode(this.gameMode);
            this.stage.getState().onChoose();

            this.pageNext.refreshGame();
            this.pageNow.dispose();
        }
        else{
            this.stage.setCurrentAnswer(e.getActionCommand());
            this.stage.getState().onChoose();
            Game game = (Game) this.pageNow;
            if (this.stage.isPlaying()){
                game.refreshGame();
            }else{
                Finish finish = new Finish(this.stage);
                finish.setVisible(true);
                game.dispose();
            }
        }
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
    }

    public JFrame getPageNow() {
        return pageNow;
    }

    public void setPageNow(JFrame pageNow) {
        this.pageNow = pageNow;
    }

    public JFrame getPageNext() {
        return pageNext;
    }

    public void setPageNext(Game pageNext) {
        this.pageNext = pageNext;
    }
}
         
