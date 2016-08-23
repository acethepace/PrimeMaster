package com.mallock.primemaster;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        TextView cheatTV = (TextView) findViewById(R.id.tv_cheat);
        String cheat = getIntent().getStringExtra(MainActivity.EXTRA_CHEAT);
        cheatTV.setText(cheat);
    }

    public void backButtonAction(View view) {
        finish();
    }
}
