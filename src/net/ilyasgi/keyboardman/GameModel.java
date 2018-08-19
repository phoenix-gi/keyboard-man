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

    GameModel() {
        start = false;
        rnd = new Random();
    }

    void start() {
        start = true;
        startTime = System.nanoTime();
        trueTypes = 0;
        allTypes = 0;
        currentSymbol = getRandomChar();
    }

    boolean isStart() {
        return start;
    }

    void handleKey(KeyEvent keyEvent) {
        if (keyEvent.getKeyChar() == currentSymbol) {
            trueTypes++;
        }
        allTypes++;
        currentSymbol = getRandomChar();
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
}
