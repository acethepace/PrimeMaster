package com.mallock.primemaster;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Mallock on 14-08-2016.
 */
class NumberGenerator implements Parcelable {
    public static final Creator<NumberGenerator> CREATOR = new Creator<NumberGenerator>() {
        @Override
        public NumberGenerator createFromParcel(Parcel in) {
            return new NumberGenerator(in);
        }

        @Override
        public NumberGenerator[] newArray(int size) {
            return new NumberGenerator[size];
        }
    };
    private final double maxNumber;
    private final double minNumber;
    private int currentNumber;

    public NumberGenerator(int minNumber, int maxNumber) {
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
    }

    protected NumberGenerator(Parcel in) {
        currentNumber = in.readInt();
        maxNumber = in.readDouble();
        minNumber = in.readDouble();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(currentNumber);
        parcel.writeDouble(maxNumber);
        parcel.writeDouble(minNumber);
    }
}
