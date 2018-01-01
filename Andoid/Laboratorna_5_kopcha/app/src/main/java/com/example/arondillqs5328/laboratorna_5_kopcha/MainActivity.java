package com.example.arondillqs5328.laboratorna_5_kopcha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickRunNextTransposition(View view) {
        runCalc(false);
    }

    public void onClickRunAllTransposition(View view) {
        runCalc(true);
    }

    private void runCalc(boolean isAll) {
        EditText editTextNextTranspisition = findViewById(R.id.nextTransposition);

        if (!editTextNextTranspisition.getText().toString().equals("")) {
            Intent intent = new Intent(this, Main2Activity.class);
            intent.putExtra("NextTransposition", editTextNextTranspisition.getText().toString());
            if (isAll) {
                intent.putExtra("all", "all");
            } else {
                intent.putExtra("all", "notAll");
            }
            startActivity(intent);
        } else {
            Toast toast = Toast.makeText(getApplicationContext(), "Enter something in one field!!!", Toast.LENGTH_LONG);
        }
    }
}
