package com.example.arondillqs5328.laboratorna_7_kopcha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void runZ12(View view) {
        EditText editText1 = findViewById(R.id.upLine);
        EditText editText2 = findViewById(R.id.downLine);

        if (!isEmpthy()) {
            intent = new Intent(this, Zav_1_Activity.class);
            intent.putExtra("up", editText1.getText().toString());
            intent.putExtra("down", editText2.getText().toString());
            startActivity(intent);
        }
    }

    public void runZ3(View view) {
        EditText editText1 = findViewById(R.id.upLine);
        EditText editText2 = findViewById(R.id.downLine);

        if (!isEmpthy()) {
            intent = new Intent(this, Zav_1_Activity.class);
            intent.putExtra("up", editText1.getText().toString());
            intent.putExtra("down", editText2.getText().toString());
            startActivity(intent);
        }
    }

    private boolean isEmpthy() {
        EditText editText1 = findViewById(R.id.upLine);
        EditText editText2 = findViewById(R.id.downLine);

        if (!editText1.getText().toString().equals("") && !editText2.getText().toString().equals("")
                && editText1.getText().toString().length() == editText2.getText().toString().length()) {
            return false;
        } else {
            Toast toast = Toast.makeText(getApplicationContext(), "Введіть привильні данні!!!", Toast.LENGTH_LONG);
            toast.show();
        }
        return true;
    }
}
