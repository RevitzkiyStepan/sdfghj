package com.example.arondillqs5328.laboratorna_3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_1, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.calculation:
                calculate();
                return true;
            case R.id.info:
                Intent intent = new Intent(this, InfoActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void calculationValue(View view) {
        calculate();
    }

    private void calculate() {
        EditText mEditTextA = findViewById(R.id.edit_text_A);
        EditText mEditTextB = findViewById(R.id.edit_text_B);
        EditText mEditTextC = findViewById(R.id.edit_text_C);
        EditText mEditTextD = findViewById(R.id.edit_text_D);
        if (isFieldEmpty(mEditTextA, mEditTextB, mEditTextC, mEditTextD) && isFieldNumber(mEditTextA, mEditTextB, mEditTextC, mEditTextD)) {
            startCalculation(mEditTextA, mEditTextB, mEditTextC, mEditTextD);
        }
    }

    private boolean isFieldNumber(EditText mEditTextA, EditText mEditTextB, EditText mEditTextC, EditText mEditTextD) {
        try {
            double a = Double.parseDouble(mEditTextA.getText().toString());
            double b = Double.parseDouble(mEditTextB.getText().toString());
            double c = Double.parseDouble(mEditTextC.getText().toString());
            double d = Double.parseDouble(mEditTextD.getText().toString());
        }catch (Exception ex) {
            return false;
        }
        return true;
    }

    private void startCalculation(EditText editTextA, EditText editTextB, EditText editTextC, EditText editTextD) {
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("valueA", editTextA.getText().toString());
        intent.putExtra("valueB", editTextB.getText().toString());
        intent.putExtra("valueC", editTextC.getText().toString());
        intent.putExtra("valueD", editTextD.getText().toString());
        startActivity(intent);
    }

    private boolean isFieldEmpty(EditText editTextA, EditText editTextB, EditText editTextC, EditText editTextD) {
        if (editTextA.getText().toString().equals("") ||
                editTextB.getText().toString().equals("") ||
                editTextC.getText().toString().equals("") ||
                editTextD.getText().toString().equals("")) {
            return false;
        }
        return true;
    }
}
