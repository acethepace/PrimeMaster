package com.mallock.primemaster;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final static int MIN_VALUE = 1;
    private final static int MAX_VALUE = 1000;
    private static final String NUMBER_GENERATOR = "NUMBER_GENERATOR";

    private TextView primeNumberTV;
    private NumberGenerator numberGenerator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        primeNumberTV = (TextView) findViewById(R.id.textView);
        if (savedInstanceState == null) {
            numberGenerator = new NumberGenerator(MIN_VALUE, MAX_VALUE);
            loadNewNumber(null);
        } else {
            numberGenerator = (NumberGenerator) savedInstanceState.get(NUMBER_GENERATOR);
            primeNumberTV.setText(numberGenerator.getCurrentNumber()+"");
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelable(NUMBER_GENERATOR, numberGenerator);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    public void loadNewNumber(@Nullable View view) {
        primeNumberTV.setText(numberGenerator.generateNew() + "");
    }

    public void answerNo(View view) {
        checkAnswer(false);
    }

    public void answerYes(View view) {
        checkAnswer(true);
    }

    private void checkAnswer(boolean b) {
        String message = "Correct answer!";
        if (b != NumberChecker.isPrime(numberGenerator.getCurrentNumber())) {
            message = "Wrong answer :(";
        }
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        loadNewNumber(null);
    }
}
