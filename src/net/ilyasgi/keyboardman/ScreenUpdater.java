package net.ilyasgi.keyboardman;

public class ScreenUpdater implements Runnable {

    @Override
    public void run() {
        do {
            MainPanel.getPanel().repaint();
            try {
                Thread.sleep(5L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (true);
    }
}
