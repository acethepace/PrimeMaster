package com.mallock.primemaster;

/**
 * Created by Mallock on 14-08-2016.
 */
class NumberChecker {
    public static boolean isPrime(int number) {
        for (int i = 2; i - 1 < number; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    public static int getFirstFactor(int number) {
        for (int i = 2; i - 1 < number; i++) {
            if (number % i == 0)
                return i;
        }
        return 0;
    }
}
