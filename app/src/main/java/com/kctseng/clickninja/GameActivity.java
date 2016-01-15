package com.kctseng.clickninja;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class GameActivity extends Activity
{
    Button red;
    Button blue;
    Button green;
    Button yellow;

    ArrayList<Button> buttonList = new ArrayList<>();

    int currentScore;



    boolean positive = true;

    String[] colors = {"red", "blue", "green", "yellow"};
    String[] dos = {"", "Don't "};

    ArrayList<Button> acceptableSet = new ArrayList<>();


    TextView question;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        red = (Button) findViewById(R.id.red);
        blue = (Button) findViewById(R.id.blue);
        green = (Button) findViewById(R.id.green);
        yellow = (Button) findViewById(R.id.yellow);

        question = (TextView) findViewById(R.id.question);

        currentScore = 0;

        buttonList.add(red);
        buttonList.add(blue);
        buttonList.add(green);
        buttonList.add(yellow);

        generateQuestion();

    }

    public void generateQuestion()
    {
        Random r = new Random();
        int dosdont = r.nextInt(2);

        String q = "";
        q += dos[dosdont] + "Tap on ";

        int color = r.nextInt(4);
        q += colors[color];

        acceptableSet.add(red);
        acceptableSet.add(blue);
        acceptableSet.add(green);
        acceptableSet.add(yellow);


        if(dosdont == 1)
        {
            acceptableSet.remove(color);
        }
        else
        {
            acceptableSet.clear();
            acceptableSet.add(buttonList.get(color));
        }

        question.setText(q);

    }

    public void checkAnswer(View btn)
    {
        if(acceptableSet.contains(btn))
        {
            currentScore++;
        }

        TextView score = (TextView) findViewById(R.id.score);
        score.setText(Integer.toString(currentScore));

        generateQuestion();
    }






}
