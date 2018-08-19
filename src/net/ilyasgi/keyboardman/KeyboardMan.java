package net.ilyasgi.keyboardman;

public class KeyboardMan {
    public static void main(String[] args) {
        MainWindow window = MainWindow.getInstance();
        window.show();
        MainScreen screen = new MainScreen();
        MainPanel.setScreen(screen);
        Thread updater = new Thread(new ScreenUpdater());
        updater.start();
    }
}
