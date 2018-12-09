package com.kodilla.donotgetangy;

import java.util.Random;

public class DiceRoll {
    public static int rollTheDice() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
}
