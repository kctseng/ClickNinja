package com.kctseng.clickninja;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class GameActivity extends Activity
{
    Button red;
    Button blue;
    Button green;
    Button yellow;

    ArrayList<Button> buttonList = new ArrayList<>();

    int currentScore;

    int incorrect;



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
        incorrect = 0;

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
        System.out.println(dosdont);
        System.out.println(color);
        q += colors[color];

        acceptableSet.clear();
        acceptableSet.addAll(buttonList);

        if(dosdont == 1)
        {
            acceptableSet.remove(buttonList.get(color));
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
            TextView score = (TextView) findViewById(R.id.score);
            score.setText(Integer.toString(currentScore));
        }
        else
        {
            incorrect++;
            TextView wrong = (TextView) findViewById(R.id.incorrect);
            wrong.setText(Integer.toString(incorrect));
        }

        if(incorrect == 5)
        {
            Intent intent = new Intent(GameActivity.this, GameOverActivity.class);
            intent.putExtra("score", currentScore);
            startActivity(intent);
        }
        generateQuestion();
    }






}
