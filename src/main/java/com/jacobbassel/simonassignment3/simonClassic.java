package com.jacobbassel.simonassignment3;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.widgets.Helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class simonClassic extends AppCompatActivity {

    boolean thing2 = true;
    simonClassic listen = new simonClassic();
    Timer timer = new Timer();
    MyTimer myTimer = new MyTimer();
    private MediaPlayer mediaplayer;
    View view;
    private static int buttons[] = {R.id.button2, R.id.button4, R.id.button5, R.id.button6};
    int i = 0;
    List<Integer> arrlist = new ArrayList<Integer>();
    List<Integer> arrlist2 = new ArrayList<Integer>();
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

        button2.setBackgroundColor(Color.BLUE);
        button3.setBackgroundColor(Color.RED);
        button4.setBackgroundColor(Color.GREEN);
        button5.setBackgroundColor(Color.YELLOW);
    }

    class StartListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            Button button5 = (Button) findViewById(R.id.button7);
            int thing = 0;
            if (view.getId() == R.id.button7) {
                timer.schedule(myTimer, 2000, 2000);

                Button button = (Button) findViewById(R.id.button2);
                Button button2 = (Button) findViewById(R.id.button4);
                Button button3 = (Button) findViewById(R.id.button5);
                Button button4 = (Button) findViewById(R.id.button6);

                findViewById(R.id.button2).setOnClickListener(new StartListener());
                findViewById(R.id.button4).setOnClickListener(new StartListener());
                findViewById(R.id.button5).setOnClickListener(new StartListener());
                findViewById(R.id.button6).setOnClickListener(new StartListener());
                TextView text = (TextView) findViewById(R.id.textView);


                if (i == 4) {
                        text.setText("Nice");
                }

                else if (view.getId() == buttons[1]) {
                    arrlist2.add(1);
                    Log.i("This is the array: ", String.valueOf(arrlist2.indexOf(1)));

                    if (arrlist.indexOf(0) == arrlist2.indexOf(0)) {
                        text.setText("Nice");
                    }
                }
                else if (view.getId() == buttons[2]) {
                    arrlist2.add(2);
                    Log.i("This is the array: ", String.valueOf(arrlist2.indexOf(2)));

                    if (arrlist.indexOf(0) == arrlist2.indexOf(0)) {
                        text.setText("Nice");
                    }
                }
                else if (view.getId() == buttons[3]) {
                    arrlist2.add(3);
                    Log.i("This is the array: ", String.valueOf(arrlist2.indexOf(3)));

                    if (arrlist.indexOf(0) == arrlist2.indexOf(0)) {
                        text.setText("Nice");
                    }
                }


            }
        }

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
                    TextView text = (TextView) findViewById(R.id.textView);

                    Random rand = new Random();
                    int picker = rand.nextInt(4);
                    i++;
                    if (i == 4) {
                        button.setBackgroundColor(Color.BLUE);
                        button2.setBackgroundColor(Color.RED);
                        button3.setBackgroundColor(Color.GREEN);
                        button4.setBackgroundColor(Color.YELLOW);
                        text.setText("Your Turn");
                        timer.cancel();
                        timer.purge();
                    }

                    else if (picker == 0) {
                        mediaplayer = MediaPlayer.create(getApplicationContext(), sounds[0]);
                        button.setBackgroundColor(getResources().getColor(R.color.black));
                        text.setText(buttonCols[0]);

                        arrlist.add(picker);

                        button2.setBackgroundColor(Color.RED);
                        button4.setBackgroundColor(Color.YELLOW);
                        button3.setBackgroundColor(Color.GREEN);
                    }
                    else if (picker == 1) {
                        mediaplayer = MediaPlayer.create(getApplicationContext(), sounds[3]);
                        button2.setBackgroundColor(getResources().getColor(R.color.black));
                        text.setText(buttonCols[1]);

                        arrlist.add(picker);

                        button.setBackgroundColor(Color.BLUE);
                        button3.setBackgroundColor(Color.GREEN);
                        button4.setBackgroundColor(Color.YELLOW);
                    }
                    else if (picker == 2) {
                        mediaplayer = MediaPlayer.create(getApplicationContext(), sounds[1]);
                        button3.setBackgroundColor(getResources().getColor(R.color.black));
                        text.setText(buttonCols[2]);

                        arrlist.add(picker);

                        button.setBackgroundColor(Color.BLUE);
                        button2.setBackgroundColor(Color.RED);
                        button4.setBackgroundColor(Color.YELLOW);

                    }
                    else if (picker == 3) {
                        mediaplayer = MediaPlayer.create(getApplicationContext(), sounds[2]);
                        button4.setBackgroundColor(getResources().getColor(R.color.black));
                        text.setText(buttonCols[3]);

                        arrlist.add(picker);

                        button.setBackgroundColor(Color.BLUE);
                        button2.setBackgroundColor(Color.RED);
                        button3.setBackgroundColor(Color.GREEN);

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
    }


}
