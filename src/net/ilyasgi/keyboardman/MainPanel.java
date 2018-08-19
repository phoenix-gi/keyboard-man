package net.ilyasgi.keyboardman;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

final class MainPanel {
    private static MainPanel instance;

    private JPanel panel;
    private Screen screen;

    private MainPanel() {
        buildPanel();
    }

    private void buildPanel() {
        assert panel == null;
        panel = new JPanel() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, getWidth(), getHeight());
                if (screen != null) {
                    screen.paint((Graphics2D) g);
                }
            }
        };
    }

    static JPanel getPanel() {
        if (instance == null) {
            instance = new MainPanel();
        }
        return instance.panel;
    }

    static void setScreen(Screen screen) {
        instance.screen = screen;
        instance.panel.repaint();
    }
}
