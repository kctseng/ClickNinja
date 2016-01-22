package com.kctseng.clickninja;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class GameOverActivity extends Activity
{

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover);

        Bundle extra = getIntent().getExtras();
        if(extra != null)
        {
            score = extra.getInt("score");
        }

        TextView view = (TextView) findViewById(R.id.finalscore);
        view.setText(Integer.toString(score));
    }

    public void backToMainMenu(View btn)
    {
        Intent intent = new Intent(GameOverActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
