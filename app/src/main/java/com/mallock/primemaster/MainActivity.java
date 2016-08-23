package com.mallock.primemaster;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static final String EXTRA_HINT = "HINT";
    private final static int MIN_VALUE = 1;
    private final static int MAX_VALUE = 1000;
    private static final String NUMBER_GENERATOR = "NUMBER_GENERATOR";
    private static final String SCORE = "score";
    private boolean hintUsed = false;
    private boolean cheatUsed = false;

    private int score;
    private TextView primeNumberTV;
    private TextView scoreTV;
    private NumberGenerator numberGenerator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        primeNumberTV = (TextView) findViewById(R.id.textView);
        scoreTV = (TextView) findViewById(R.id.scoreText);
        if (savedInstanceState == null) {
            numberGenerator = new NumberGenerator(MIN_VALUE, MAX_VALUE);
            loadNewNumber(null);
        } else {
            numberGenerator = (NumberGenerator) savedInstanceState.get(NUMBER_GENERATOR);
            score = savedInstanceState.getInt(SCORE);
            primeNumberTV.setText(String.format(getString(R.string.prime_number_text), numberGenerator.getCurrentNumber()));
        }
        updateScore();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelable(NUMBER_GENERATOR, numberGenerator);
        outState.putInt(SCORE, score);
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

    private void updateScore() {
        scoreTV.setText(String.format(getString(R.string.score_string), score));
    }

    public void loadNewNumber(@Nullable View view) {
        primeNumberTV.setText(String.format(getString(R.string.prime_number_text), numberGenerator.generateNew()));
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
            score -= 5;
        } else {
            score += 10;
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        loadNewNumber(null);
        updateScore();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.hint:
                Intent hintActivityIntent = new Intent(MainActivity.this, HintActivity.class);
                String hintText = getHint(numberGenerator.getCurrentNumber());
                hintActivityIntent.putExtra(EXTRA_HINT, hintText);
                startActivity(hintActivityIntent);
                return true;
            case R.id.cheat:
                // TODO: 24-08-2016 add cheat code here
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private String getHint(int currentNumber) {
        int returnValue = NumberChecker.getFirstFactor(currentNumber);
        if (returnValue == 0) {
            return currentNumber + " has no factors.";
        } else {
            return currentNumber + " is divisible by " + returnValue;
        }
    }


}
