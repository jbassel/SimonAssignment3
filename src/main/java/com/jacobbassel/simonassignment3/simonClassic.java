package com.jacobbassel.simonassignment3;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.widgets.Helper;

import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class simonClassic extends AppCompatActivity {

    private MediaPlayer mediaplayer;

    private static int buttons[] = {R.id.button2, R.id.button4, R.id.button5, R.id.button6};
    private static int colCount[] = {};
    private static String buttonCols[] = {"Blue!", "Red!", "Green!", "Yellow!"};
    private static int sounds[] = {R.raw.beep, R.raw.beeps, R.raw.alarm, R.raw.turret};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button4);
        Button button4 = (Button) findViewById(R.id.button5);
        Button button5 = (Button) findViewById(R.id.button6);
        Button button6 = (Button) findViewById(R.id.button7);
        TextView text = (TextView) findViewById(R.id.textView);

        findViewById(R.id.button2).setOnClickListener(new StartListener());
        findViewById(R.id.button4).setOnClickListener(new StartListener());
        findViewById(R.id.button5).setOnClickListener(new StartListener());
        findViewById(R.id.button6).setOnClickListener(new StartListener());
        findViewById(R.id.button7).setOnClickListener(new StartListener());

        Timer timer = new Timer();
        MyTimer myTimer = new MyTimer();
        timer.schedule(myTimer, 2000, 2000);

        button2.setBackgroundColor(Color.BLUE);
        button3.setBackgroundColor(Color.RED);
        button4.setBackgroundColor(Color.GREEN);
        button5.setBackgroundColor(Color.YELLOW);
    }

    private class MyTimer extends TimerTask {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Button button = (Button) findViewById(R.id.button2);
                    Button button2 = (Button) findViewById(R.id.button4);
                    Button button3 = (Button) findViewById(R.id.button5);
                    Button button4 = (Button) findViewById(R.id.button6);

                    Random random = new Random();
                    button.setBackgroundColor(Color.BLUE);
                    button2.setBackgroundColor(Color.RED);
                    button3.setBackgroundColor(Color.GREEN);
                    button4.setBackgroundColor(Color.YELLOW);
                }
            });
        }
    }

    class StartListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Button button = (Button) findViewById(R.id.button2);
            Button button2 = (Button) findViewById(R.id.button4);
            Button button3 = (Button) findViewById(R.id.button5);
            Button button4 = (Button) findViewById(R.id.button6);
            Button button5 = (Button) findViewById(R.id.button7);
            TextView text = (TextView) findViewById(R.id.textView);

            if (view.getId() == R.id.button7) {
                for (int i = 0; i < 3; i++) {

                    Random rand = new Random();

                    Button buttons2[] = {button, button2, button3, button4};
                    int k = 0;
                    int picker = rand.nextInt(4);



                    buttons2[picker].setBackgroundColor(Color.BLACK);
                    text.setText(buttonCols[picker]);

                    if (picker == 0) {
                        mediaplayer = MediaPlayer.create(getApplicationContext(), sounds[0]);
                        button.setBackgroundColor(getResources().getColor(R.color.black));
                        Timer timer = new Timer();
                        MyTimer myTimer = new MyTimer();
                        timer.schedule(myTimer, 20000, 20000);
                    }
                    else if (picker == 1) {
                        mediaplayer = MediaPlayer.create(getApplicationContext(), sounds[3]);
                        button2.setBackgroundColor(getResources().getColor(R.color.black));
                        Timer timer = new Timer();
                        MyTimer myTimer = new MyTimer();
                        timer.schedule(myTimer, 20000, 20000);
                    }
                    else if (picker == 2) {
                        mediaplayer = MediaPlayer.create(getApplicationContext(), sounds[1]);
                        button3.setBackgroundColor(getResources().getColor(R.color.black));
                        Timer timer = new Timer();
                        MyTimer myTimer = new MyTimer();
                        timer.schedule(myTimer, 20000, 20000);

                    }
                    else if (picker == 3) {
                        mediaplayer = MediaPlayer.create(getApplicationContext(), sounds[2]);
                        button4.setBackgroundColor(getResources().getColor(R.color.black));
                        Timer timer = new Timer();
                        MyTimer myTimer = new MyTimer();
                        timer.schedule(myTimer, 20000, 20000);

                    }

                    mediaplayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            mediaplayer.start();
                        }
                    });
                }
            }
        }
    }
}
