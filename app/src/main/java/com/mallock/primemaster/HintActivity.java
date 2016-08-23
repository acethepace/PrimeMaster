package com.mallock.primemaster;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class HintActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);
        TextView hintText = (TextView) findViewById(R.id.tv_hint);
        String hint = getIntent().getStringExtra(MainActivity.EXTRA_HINT);
        hintText.setText(hint);
    }

    public void backButtonAction(View view) {
        finish();
    }
}
