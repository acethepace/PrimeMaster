package com.mallock.primemaster;

/**
 * Created by Mallock on 14-08-2016.
 */
class NumberGenerator {
    private int currentNumber;
    private final double maxNumber;
    private final double minNumber;

    public NumberGenerator(int minNumber, int maxNumber) {
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
    }

    public int getCurrentNumber() {
        return currentNumber;
    }

    public int generateNew() {
        int newNumber = currentNumber;
        while (newNumber == currentNumber)
            newNumber = (int) (Math.random() * (maxNumber - minNumber));
        this.currentNumber = newNumber;
        return newNumber;
    }
}
