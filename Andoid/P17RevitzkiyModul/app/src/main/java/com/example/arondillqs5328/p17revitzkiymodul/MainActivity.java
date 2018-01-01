package com.example.arondillqs5328.p17revitzkiymodul;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = new Intent(this, MyService.class);
    }

    public void onClickRunService(View view) {
        EditText editTextA = findViewById(R.id.editTextA);
        EditText editTextB = findViewById(R.id.editTextB);
        EditText editTextC = findViewById(R.id.editTextC);

        intent.putExtra("valueA", editTextA.getText().toString());
        intent.putExtra("valueB", editTextB.getText().toString());
        intent.putExtra("valueC", editTextC.getText().toString());

        startService(intent);

    }
}
