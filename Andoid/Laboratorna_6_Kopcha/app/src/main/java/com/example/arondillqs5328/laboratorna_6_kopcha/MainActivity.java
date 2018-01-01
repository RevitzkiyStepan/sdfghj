package com.example.arondillqs5328.laboratorna_6_kopcha;

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

    public void onClickRun(View view) {
        EditText editTextValueN = findViewById(R.id.valueN);
        EditText editTextValueR = findViewById(R.id.valueR);

        if (!editTextValueN.getText().toString().equals("") && !editTextValueR.getText().toString().equals("")) {
            Intent intent = new Intent(this, Main2Activity.class);
            intent.putExtra("valueN", editTextValueN.getText().toString());
            intent.putExtra("valueR", editTextValueR.getText().toString());
            startActivity(intent);
        } else {
            Toast toast = Toast.makeText(getApplicationContext(), "Enter value in fields !!!", Toast.LENGTH_LONG);
            toast.show();
        }
    }

}
