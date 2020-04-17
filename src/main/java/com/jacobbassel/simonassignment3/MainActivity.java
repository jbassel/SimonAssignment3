package com.jacobbassel.simonassignment3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        Button button2 = (Button) findViewById(R.id.button8);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button10);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        TextView text = (TextView) findViewById(R.id.textView2);
        TextView text3 = (TextView) findViewById(R.id.textView5);
    }

    @Override
    public void onClick(View view) {
        Button button = (Button) findViewById(R.id.button);
        Button button2 = (Button) findViewById(R.id.button8);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button10);
        TextView text3 = (TextView) findViewById(R.id.textView5);

        if (view.getId() == R.id.button3) {
            text3.setText("This game requires that you pay attention to the color pattern.  You must then click the buttons in the order that simon said to earn points.  You have colors and sounds to coordinate the buttons.  Good Luck!");
        }

        if (view.getId() == R.id.button10) {
            text3.setText("This game requires that you pay attention to the positions that simon says to press.  All colors are the same, so you only have the sounds and positions to know what to press.  Good Luck!");
        }

        if (view.getId() == R.id.button) {
            Intent intent = new Intent(getApplicationContext(), simonClassic.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.button8) {
            Intent intent = new Intent(getApplicationContext(), simonSuper.class);
            startActivity(intent);
        }
    }
}
