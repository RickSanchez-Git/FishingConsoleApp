package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Game game = new Game();
        while (true) {
            game.startMenu();
            game.processInput();
            game.processGame();
        }
    }
}

class Game {
    private int input;
    private Scanner inputScanner = new Scanner(System.in);
    private Bag bag = new Bag();

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_MAGENTA = "\u001b[35m";
    public static final String ANSI_WHITE = "\u001b[37;1m";

    void startMenu () {
        System.out.println("Print number to select");
        System.out.println("1 - Start fishing");
        System.out.println("2 - Bag");
    }
    void processInput() {
        try {
            input = Integer.parseInt(inputScanner.nextLine());
        } catch (Exception e) {
            System.out.println("Error! Enter right input!");
            input = -1;
        }
    }
    void processGame () {
        if (input == 1) {
            startFishing();
            return;
        }
        if (input == 2) {
            showBag();
            return;
        }
        if (input == 0) {
            System.exit(0);
        }
    }
    void startFishing() {
        String keyWord, inputWord;
        double number = 0.0;
        double diff = 0.0;

        while (number < 0.7) {
            System.out.println(ANSI_BLUE + "Catching fish..." + ANSI_RESET);
            diff += 0.05;
            number = Math.random() + diff;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        keyWord = generateKeyWord();

        System.out.println(ANSI_YELLOW + "Fish is trembling! Enter " + keyWord + " to catch!" + ANSI_RESET);

        TimerThread timer = new TimerThread();
        timer.start();

        inputWord = inputScanner.nextLine();

        if (keyWord.equals(inputWord)) {
            if (timer.isAlive()) {
                System.out.println(ANSI_GREEN + "Caught!" + ANSI_RESET);
                bag.addFish(new Fish());
            } else {
                System.out.println(ANSI_RED + "Fish slipped away..." + ANSI_RESET);
            }
            return;
        }
        System.out.println(ANSI_RED + "Wrong word!" + ANSI_RESET);
    }

    String generateKeyWord () {
        String output = "";
        for (int i = 0; i < 3; i++) {
            output += (char)(((int)((Math.random() * 26) + 49)) + '0');
        }
        return output;
    }

    void showBag () {
        bag.printBag();
    }
}

class TimerThread extends Thread {
    public void run() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            System.out.println("Error during timer thread: " + e);
        };
    }
}
