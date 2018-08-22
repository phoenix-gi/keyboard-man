package net.ilyasgi.keyboardman;

import java.awt.event.KeyEvent;
import java.util.Random;

class GameModel {
    private static final String ENG_SYMBOLS = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
    private static final String RUS_SYMBOLS = "йцукенгшщзхъфывапролджэячсмитьбюЙЦУКЕНГШЩЗХЪФЫВАПРОЛДЖЭЯЧСМИТЬБЮ";
    private boolean start;
    private long startTime;
    private char currentSymbol;
    private int trueTypes;
    private int allTypes;
    private Random rnd;
    private char nextSymbol;
    private char[] failed;
    private char[] success;

    GameModel() {
        start = false;
        rnd = new Random();
        failed = new char[10];
        success = new char[10];
        for (int i = 0; i < 10; i++) {
            failed[i] = ' ';
            success[i] = ' ';
        }
    }

    void start() {
        start = true;
        startTime = System.nanoTime();
        trueTypes = 0;
        allTypes = 0;
        currentSymbol = getRandomChar();
        nextSymbol = getRandomChar();
    }

    void stop() {
        start = false;
    }

    boolean isStart() {
        return start;
    }

    void handleKey(KeyEvent keyEvent) {
        if (keyEvent.getKeyChar() == currentSymbol) {
            trueTypes++;
            for (int i = success.length - 1; i > 0; i--) {
                success[i] = success[i - 1];
            }
            success[0] = currentSymbol;
            for (char c : success) {
                System.out.print(c + " ");
            }
            System.out.println();
        } else {
            for (int i = failed.length - 1; i > 0; i--) {
                failed[i] = failed[i - 1];
            }
            failed[0] = currentSymbol;
            for (char c : failed) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
        allTypes++;
        currentSymbol = nextSymbol;
        nextSymbol = getRandomChar();
    }

    char getCurrentSymbol() {
        return currentSymbol;
    }

    int getTrueTypes() {
        return trueTypes;
    }

    int getFalseTypes() {
        return allTypes - trueTypes;
    }

    int getAllTypes() {
        return allTypes;
    }

    long getStartTime() {
        return startTime;
    }

    private char getRandomChar() {
        return ENG_SYMBOLS.charAt(rnd.nextInt(ENG_SYMBOLS.length()));
    }

    char[] getSuccess() {
        return success;
    }

    char[] getFailed() {
        return failed;
    }

    char getNextSymbol() {
        return nextSymbol;
    }
}
