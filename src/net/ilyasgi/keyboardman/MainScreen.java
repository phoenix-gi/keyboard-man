package net.ilyasgi.keyboardman;

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.BasicStroke;
import java.awt.FontMetrics;
import java.awt.Font;

public class MainScreen implements Screen {
    @Override
    public void paint(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(10));
        Font font = new Font("Arial", Font.ITALIC, 64);
        g2d.setFont(font);

        FontMetrics metrics = g2d.getFontMetrics(font);
        final String title = "Keyboard man";
        int x = MainPanel.getPanel().getWidth()/2 - metrics.stringWidth(title) / 2;
        int y = 80;
        g2d.drawString(title, x, y);
    }
}
