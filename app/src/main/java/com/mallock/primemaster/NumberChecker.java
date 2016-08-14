package com.mallock.primemaster;

/**
 * Created by Mallock on 14-08-2016.
 */
class NumberChecker {
    public static boolean isPrime(int number) {
        for (int i = 2; 2 * i < number; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }
}
