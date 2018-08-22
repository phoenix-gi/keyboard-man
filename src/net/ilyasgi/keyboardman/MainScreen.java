package net.ilyasgi.keyboardman;

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.BasicStroke;
import java.awt.FontMetrics;
import java.awt.Font;

public class MainScreen implements Screen {
    private GameModel model;

    MainScreen() {
        model = new GameModel();
        MainInput input = new MainInput(model);
        MainPanel.getPanel().addKeyListener(input);
    }

    @Override
    public void paint(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(10));
        Font font = new Font("Arial", Font.ITALIC, 64);
        g2d.setFont(font);

        FontMetrics metrics = g2d.getFontMetrics();
        final String title = "Keyboard man";
        int x = MainPanel.getPanel().getWidth() / 2 - metrics.stringWidth(title) / 2;
        int y = 80;
        g2d.drawString(title, x, y);
        g2d.setColor(Color.BLUE);
        if (model.isStart()) {
            g2d.setColor(Color.LIGHT_GRAY);
            g2d.drawString(String.valueOf(model.getNextSymbol()), 140 + metrics.stringWidth("Type "), 300 - metrics.getHeight());
            g2d.setColor(Color.BLACK);
            String currentType = "Type " + String.valueOf(model.getCurrentSymbol());
            g2d.drawString(currentType, 140, 300);
            g2d.setColor(Color.GREEN);
            String success = "";
            for (char c : model.getSuccess()) {
                success += " " + c;
            }
            g2d.drawString(success, 140 + metrics.stringWidth(currentType), 300);

            g2d.setColor(Color.RED);

            for (int i = 0; i < model.getFailed().length; i++) {
                g2d.drawString(String.valueOf(model.getFailed()[i]), 140 + metrics.stringWidth("Type "), 300 + metrics.getHeight() * (i + 1));
            }

            g2d.setFont(new Font("Arial", Font.PLAIN, 16));
            metrics = g2d.getFontMetrics();

            g2d.setColor(Color.RED);
            g2d.drawString("Fail count: " + model.getFalseTypes(), 30, MainPanel.getPanel().getHeight() - metrics.getHeight() - 32);
            g2d.setColor(Color.BLUE);
            g2d.drawString("All count: " + model.getAllTypes(), 30, MainPanel.getPanel().getHeight() - metrics.getHeight() - 48);

            long currentTime = System.nanoTime();
            float delta = (currentTime - model.getStartTime()) / 1000000000f;
            g2d.drawString("Time:" + String.format("%.2f", delta), 30, MainPanel.getPanel().getHeight() - metrics.getHeight() - 64);

            float accuracy = (float) model.getTrueTypes() / model.getAllTypes();
            if (!Float.isNaN(accuracy)) {
                g2d.drawString("Accuracy:" + String.format("%.2f", accuracy), 30, MainPanel.getPanel().getHeight() - metrics.getHeight() - 80);
            }

            float speed = (float) model.getTrueTypes() / delta;
            if (!Float.isNaN(speed)) {
                g2d.drawString("Average speed:" + String.format("%.2f", speed) + " sym/sec", 30, MainPanel.getPanel().getHeight() - metrics.getHeight() - 96);
            }


            g2d.setColor(Color.BLACK);
            g2d.drawString("Try type 5 symbols in second!", 30, MainPanel.getPanel().getHeight() - metrics.getHeight());
            String resetString = "Press ESC to reset";
            g2d.drawString(resetString, MainPanel.getPanel().getWidth() - metrics.stringWidth(resetString) - 20, MainPanel.getPanel().getHeight() - metrics.getHeight());
        } else {
            final String startString = "Press space to start";
            x = MainPanel.getPanel().getWidth() / 2 - metrics.stringWidth(startString) / 2;
            g2d.drawString(startString, x, 300);
        }
    }
}
