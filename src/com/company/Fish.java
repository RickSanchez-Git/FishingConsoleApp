package com.company;


import java.util.Random;

public class Fish {
    private String fishName;
    private String quality;
    private String color;

    Fish () {
        Random random = new Random();
        final String fishNames[] = {"Tilapia", "Bass", "Sturgeon"};
        final String qualities[] = {"Common", "Rare", "Legendary"};

        fishName = fishNames[random.nextInt(fishNames.length)];
        quality = qualities[random.nextInt(qualities.length)];
        switch (quality) {
            case "Common":
                color = Game.ANSI_WHITE;
                break;
            case "Rare":
                color = Game.ANSI_BLUE;
                break;
            case "Legendary":
                color = Game.ANSI_MAGENTA;
                break;
        }
    }

    void print() {
        System.out.println(fishName + " ".repeat(8 - fishName.length()) + " | "
                + color + quality + Game.ANSI_RESET);
    }
}
