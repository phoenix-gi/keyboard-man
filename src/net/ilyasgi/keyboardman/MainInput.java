package net.ilyasgi.keyboardman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainInput implements KeyListener {

    private GameModel model;

    MainInput(GameModel model) {
        this.model = model;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        if (model.isStart()) {
            model.handleKey(keyEvent);
        }
        MainPanel.getPanel().repaint();
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if (!model.isStart()) {
            if (keyEvent.getKeyCode() == KeyEvent.VK_SPACE) {
                model.start();
            }
        } else {
            if (keyEvent.getKeyCode() == KeyEvent.VK_ESCAPE) {
                model.stop();
            }
        }
        MainPanel.getPanel().repaint();
    }
}
