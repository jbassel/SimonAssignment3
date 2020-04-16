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
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        TextView text = (TextView) findViewById(R.id.textView2);
    }

    @Override
    public void onClick(View view) {
        Button button = (Button) findViewById(R.id.button);
        Button button2 = (Button) findViewById(R.id.button8);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);

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
