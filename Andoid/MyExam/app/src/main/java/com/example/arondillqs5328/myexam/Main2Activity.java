package com.example.arondillqs5328.myexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    EditText editTextC;
    Double valueA;
    Double valueB;
    static Double valueC = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        valueA = Double.valueOf(intent.getStringExtra("valueA"));
        valueB = Double.valueOf(intent.getStringExtra("valueB"));

        editTextC = findViewById(R.id.valueC);

        valueC = (valueA + valueB) / 2;
        editTextC.setText(String.valueOf(valueC));

    }

    public void onClickRun(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
