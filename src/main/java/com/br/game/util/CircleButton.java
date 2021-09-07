package com.br.game.util;

import javax.swing.*;
import java.awt.*;

public class CircleButton extends JButton {
    private Color bg;
    private Color fg;

    public CircleButton(String text, Color bg, Color fg) {
        super(text);

        this.bg = bg;
        this.fg = fg;

        Dimension size = getPreferredSize();
        size.width = size.height = Math.max(size.width, size.height);
        setPreferredSize(size);

        setContentAreaFilled(false);
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
}
         
