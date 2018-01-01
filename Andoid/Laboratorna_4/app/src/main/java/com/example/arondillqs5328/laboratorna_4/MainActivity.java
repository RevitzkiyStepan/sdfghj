package com.example.arondillqs5328.laboratorna_4;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    final int TASK1 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = new Intent(this, MyService.class);
    }

    public void onClickStart(View v) {
        EditText maxElemValue = findViewById(R.id.max_elem_value);
        EditText determValue = findViewById(R.id.value_determ);
        EditText aValue = findViewById(R.id.a_determ);

        MyService.runnable = true;
//        Intent intent = new Intent(MainActivity.this, MyService.class);
        intent.putExtra("maxValue", maxElemValue.getText().toString());
        intent.putExtra("determValue", determValue.getText().toString());
        intent.putExtra("aValue", aValue.getText().toString());
        startService(intent);
    }

    public void onClickStop(View v) {
//        Intent intent = new Intent(MainActivity.this, MyService.class);
        MyService.runnable = false;
        stopService(intent);


    }
}

