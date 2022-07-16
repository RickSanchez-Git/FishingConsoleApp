package com.company;

import java.util.ArrayList;

public class Bag {
    ArrayList<Fish> fishesContainer = new ArrayList<Fish>();

    void addFish(Fish fish) {
        fishesContainer.add(fish);
    }
    void printBag() {
        System.out.println();
        for(int i = 0; i < fishesContainer.size(); i++) {
            fishesContainer.get(i).print();
        }
        System.out.println();
    }
}
