package net.ilyasgi.keyboardman;

import javax.swing.JFrame;
import java.awt.Toolkit;

final class MainWindow {
    private static MainWindow instance;

    private static JFrame frame;

    private MainWindow() {
        buildWindow();
    }

    private void buildWindow() {
        frame = new JFrame("Keyboard man");
        Toolkit tlk = Toolkit.getDefaultToolkit();
        final int frameWidth = 800;
        final int frameHeight = 600;
        final int screenWidth = tlk.getScreenSize().width;
        final int screenHeight = tlk.getScreenSize().height;
        final int x = (screenWidth - frameWidth) / 2;
        final int y = (screenHeight - frameHeight) / 2;
        frame.setBounds(x, y, frameWidth, frameHeight);
        frame.setResizable(false);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void show() {
        frame.setVisible(true);
    }

    static MainWindow getInstance() {
        if (instance == null) {
            instance = new MainWindow();
        }
        return instance;
    }
}
