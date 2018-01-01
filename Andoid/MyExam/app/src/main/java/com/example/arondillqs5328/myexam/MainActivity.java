package com.example.arondillqs5328.myexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextA;
    EditText editTextB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Main2Activity.valueC != 0.0) {
            editTextA = findViewById(R.id.valueA);
            editTextB = findViewById(R.id.valueB);
            editTextA.setText(String.valueOf(Main2Activity.valueC - 1.0));
            editTextB.setText(String.valueOf(Main2Activity.valueC + 1.0));
        }
    }


    public void onClickRunCalc(View view) {
        editTextA = findViewById(R.id.valueA);
        editTextB = findViewById(R.id.valueB);
        Toast toast = Toast.makeText(getApplicationContext(), "Enter values!!!", Toast.LENGTH_LONG);

        if (editTextA.getText().toString().equals("") || editTextB.getText().toString().equals("")) {
            toast.show();
        } else {
            Intent intent = new Intent(this, Main2Activity.class);

            try {
                double a = Double.valueOf(editTextA.getText().toString());
                double b = Double.valueOf(editTextB.getText().toString());

                intent.putExtra("valueA", editTextA.getText().toString());
                intent.putExtra("valueB", editTextB.getText().toString());
                startActivity(intent);
            } catch (Exception e) {
                toast.show();
            }
        }
    }
}
