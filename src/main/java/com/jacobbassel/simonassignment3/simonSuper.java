package com.jacobbassel.simonassignment3;

import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.widgets.Helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class simonSuper extends AppCompatActivity {

    Timer timer = new Timer();
    MyTimer myTimer = new MyTimer();
    int thing2 = 0;
    private MediaPlayer mediaplayer;
    int count2 = 0;
    int count3 = 0;
    int j = 0;
    View view;
    private static int buttons[] = {R.id.button2, R.id.button4, R.id.button5, R.id.button6};
    int count = 0;
    int i = 0;
    List<Integer> arrlist = new ArrayList<Integer>();
    List<Integer> arrlist2 = new ArrayList<Integer>();
    private static int colCount[] = {};
    private static String buttonCols[] = {"Top Left!", "Top Right!", "Bottom Left!", "Bottom Right"};
    private static int sounds[] = {R.raw.beep, R.raw.beeps, R.raw.alarm, R.raw.turret};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        j = 0;

        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button4);
        Button button4 = (Button) findViewById(R.id.button5);
        Button button5 = (Button) findViewById(R.id.button6);
        Button button6 = (Button) findViewById(R.id.button7);
        TextView text = (TextView) findViewById(R.id.textView);
        TextView text2 = (TextView) findViewById(R.id.textView4);

        findViewById(R.id.button2).setOnClickListener(new MyTimer());
        findViewById(R.id.button4).setOnClickListener(new MyTimer());
        findViewById(R.id.button5).setOnClickListener(new MyTimer());
        findViewById(R.id.button6).setOnClickListener(new MyTimer());
        findViewById(R.id.button7).setOnClickListener(new MyTimer());
        findViewById(R.id.button9).setOnClickListener(new MyTimer());

        button2.setBackgroundColor(Color.YELLOW);
        button3.setBackgroundColor(Color.YELLOW);
        button4.setBackgroundColor(Color.YELLOW);
        button5.setBackgroundColor(Color.YELLOW);


        timer = new Timer();
        timer.schedule(myTimer, 2000, 2000);

        count = GameState3.INSTANCE.getScore();
        count3 = GameState4.INSTANCE.getScore();
        text2.setText(String.valueOf(count3));
    }

    private class MyTimer extends TimerTask implements View.OnClickListener{
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Button button = (Button) findViewById(R.id.button2);
                    Button button2 = (Button) findViewById(R.id.button4);
                    Button button3 = (Button) findViewById(R.id.button5);
                    Button button4 = (Button) findViewById(R.id.button6);
                    Button button7 = (Button) findViewById(R.id.button7);
                    Button button9 = (Button) findViewById(R.id.button9);
                    TextView text = (TextView) findViewById(R.id.textView);

                    button.setEnabled(false);
                    button2.setEnabled(false);
                    button3.setEnabled(false);
                    button4.setEnabled(false);
                    button7.setEnabled(false);
                    button9.setEnabled(false);

                    Random rand = new Random();
                    int picker = rand.nextInt(4);

                    if (i == count) {
                        button.setBackgroundColor(Color.YELLOW);
                        button2.setBackgroundColor(Color.YELLOW);
                        button3.setBackgroundColor(Color.YELLOW);
                        button4.setBackgroundColor(Color.YELLOW);
                        text.setText("Your Turn");

                        button.setEnabled(true);
                        button2.setEnabled(true);
                        button3.setEnabled(true);
                        button4.setEnabled(true);
                        button7.setEnabled(true);
                        button9.setEnabled(true);

                        mediaplayer.release();
                        timer.cancel();

                    } else if (picker == 0) {
                        mediaplayer = MediaPlayer.create(getApplicationContext(), sounds[0]);
                        button.setBackgroundColor(getResources().getColor(R.color.DarkYellow));
                        text.setText(buttonCols[0]);
                        i++;

                        arrlist.add(0);

                        button2.setBackgroundColor(Color.YELLOW);
                        button4.setBackgroundColor(Color.YELLOW);
                        button3.setBackgroundColor(Color.YELLOW);
                    } else if (picker == 1) {
                        mediaplayer = MediaPlayer.create(getApplicationContext(), sounds[3]);
                        button2.setBackgroundColor(getResources().getColor(R.color.DarkYellow));
                        text.setText(buttonCols[1]);
                        i++;

                        arrlist.add(1);

                        button.setBackgroundColor(Color.YELLOW);
                        button3.setBackgroundColor(Color.YELLOW);
                        button4.setBackgroundColor(Color.YELLOW);
                    } else if (picker == 2) {
                        mediaplayer = MediaPlayer.create(getApplicationContext(), sounds[1]);
                        button3.setBackgroundColor(getResources().getColor(R.color.DarkYellow));
                        text.setText(buttonCols[2]);
                        i++;

                        arrlist.add(2);

                        button.setBackgroundColor(Color.YELLOW);
                        button2.setBackgroundColor(Color.YELLOW);
                        button4.setBackgroundColor(Color.YELLOW);

                    } else if (picker == 3) {
                        mediaplayer = MediaPlayer.create(getApplicationContext(), sounds[2]);
                        button4.setBackgroundColor(getResources().getColor(R.color.DarkYellow));
                        text.setText(buttonCols[3]);
                        i++;
                        arrlist.add(3);

                        button.setBackgroundColor(Color.YELLOW);
                        button2.setBackgroundColor(Color.YELLOW);
                        button3.setBackgroundColor(Color.YELLOW);

                    }

                    mediaplayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            mediaplayer.start();
                        }
                    });




                }
            });

        }
        @Override
        public void onClick(View view) {

            Button button5 = (Button) findViewById(R.id.button7);
            int thing = 0;

            Button button = (Button) findViewById(R.id.button2);
            Button button2 = (Button) findViewById(R.id.button4);
            Button button3 = (Button) findViewById(R.id.button5);
            Button button4 = (Button) findViewById(R.id.button6);

            findViewById(R.id.button2).setOnClickListener(new MyTimer());
            findViewById(R.id.button4).setOnClickListener(new MyTimer());
            findViewById(R.id.button5).setOnClickListener(new MyTimer());
            findViewById(R.id.button6).setOnClickListener(new MyTimer());
            TextView text = (TextView) findViewById(R.id.textView);
            TextView text2 = (TextView) findViewById(R.id.textView4);

            if (view.getId() == R.id.button7) {
                count = 1;
                GameState3.INSTANCE.addScore(count);
                count2 = 0;
                mediaplayer.release();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                finish();
                startActivity(intent);
            }
            if (view.getId() == R.id.button9) {
                count = 1;
                GameState3.INSTANCE.addScore(count);
                count2 = 0;
                mediaplayer.release();
                Intent intent = new Intent(getApplicationContext(), simonSuper.class);
                finish();
                startActivity(intent);
            }


            if (view.getId() == R.id.button2) {
                arrlist2.add(0);
                mediaplayer = MediaPlayer.create(getApplicationContext(), sounds[0]);
                j++;
                thing2++;
                count2++;
            } if (view.getId() == R.id.button4) {
                arrlist2.add(1);
                mediaplayer = MediaPlayer.create(getApplicationContext(), sounds[3]);
                j++;
                thing2++;
                count2++;
            } if (view.getId() == R.id.button5) {
                arrlist2.add(2);
                mediaplayer = MediaPlayer.create(getApplicationContext(), sounds[1]);
                j++;
                thing2++;
                count2++;
            } if (view.getId() == R.id.button6) {
                arrlist2.add(3);
                mediaplayer = MediaPlayer.create(getApplicationContext(), sounds[2]);
                j++;
                thing2++;
                count2++;
            }


            if (j == count) {
                if (arrlist.indexOf(0) == arrlist2.indexOf(0) && arrlist.indexOf(1) == arrlist2.indexOf(1) && arrlist.indexOf(2) == arrlist2.indexOf(2) && arrlist.indexOf(3) == arrlist2.indexOf(3)
                        && arrlist.indexOf(4) == arrlist2.indexOf(4) && arrlist.indexOf(5) == arrlist2.indexOf(5) && arrlist.indexOf(6) == arrlist2.indexOf(6) && arrlist.indexOf(7) == arrlist2.indexOf(7)
                        && arrlist.indexOf(8) == arrlist2.indexOf(8) && arrlist.indexOf(9) == arrlist2.indexOf(9) && arrlist.indexOf(10) == arrlist2.indexOf(10) && arrlist.indexOf(11) == arrlist2.indexOf(11)
                        && arrlist.indexOf(12) == arrlist2.indexOf(12) && arrlist.indexOf(13) == arrlist2.indexOf(13) && arrlist.indexOf(14) == arrlist2.indexOf(14) && arrlist.indexOf(15) == arrlist2.indexOf(15)
                        && arrlist.indexOf(16) == arrlist2.indexOf(16) && arrlist.indexOf(17) == arrlist2.indexOf(17) && arrlist.indexOf(17) == arrlist2.indexOf(17) && arrlist.indexOf(17) == arrlist2.indexOf(17)
                        && arrlist.indexOf(18) == arrlist2.indexOf(18) && arrlist.indexOf(19) == arrlist2.indexOf(19) && arrlist.indexOf(20) == arrlist2.indexOf(20) && arrlist.indexOf(21) == arrlist2.indexOf(21)) {

                    if (thing2 == GameState3.INSTANCE.getScore()) {
                        count++;
                        GameState3.INSTANCE.addScore(count);

                        if (count2 > GameState4.INSTANCE.getScore()) {
                            GameState4.INSTANCE.addScore(count2);
                        }
                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);
                    }

                } else {
                    text.setText("You lose!");
                    GameState3.INSTANCE.addScore(1);



                }
            }

            mediaplayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mediaplayer.start();
                }

            });




        }

    }

    public enum GameState3{
        INSTANCE;

        private int score;
        private GameState3(){
            score = 1;
        }

        public int getScore(){
            return score;
        }
        public void addScore(int score){
            this.score = score;
        }

    }
    public enum GameState4{
        INSTANCE;

        private int score;
        private GameState4(){
            score = 0;
        }

        public int getScore(){
            return score;
        }
        public void addScore(int score){
            this.score = score;
        }

    }

    @Override
    public void onPause(){
        super.onPause();
        SharedPreferences sp = getSharedPreferences("MyPref2", 0);
        SharedPreferences.Editor editor = sp.edit();

        TextView tv = findViewById(R.id.textView4);

        editor.putInt("count3", GameState3.INSTANCE.getScore());
        editor.commit();
    }

    @Override
    public void onResume(){
        super.onResume();
        SharedPreferences sp = getSharedPreferences("MyPref2", 0);
        int thing = sp.getInt("count3", count3);

        count3 = count3;

    }




}
