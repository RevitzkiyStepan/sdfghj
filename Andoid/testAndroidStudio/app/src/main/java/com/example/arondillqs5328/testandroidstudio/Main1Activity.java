package com.example.arondillqs5328.testandroidstudio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class Main1Activity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_res_1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.calc:
                runCalcIntent();
                return true;
            case R.id.info:
                 final Intent intent = new Intent(this, InfoActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void runCalcIntent() {
        final Intent intent;
        if (!emptyFields()) {
           EditText enterA = findViewById(R.id.enter_param_a_field);
             EditText enterB = findViewById(R.id.enter_param_b_field);
             EditText enterC = findViewById(R.id.enter_param_c_field);
             EditText enterD = findViewById(R.id.enter_param_d_field);
            intent = new Intent(this, Main2Activity.class);
            intent.putExtra("valueA", enterA.getText().toString());
            intent.putExtra("valueB", enterB.getText().toString());
            intent.putExtra("valueC", enterC.getText().toString());
            intent.putExtra("valueD", enterD.getText().toString());
            startActivity(intent);
        }
    }

    private boolean emptyFields() {
        EditText enterA = findViewById(R.id.enter_param_a_field);
         EditText enterB = findViewById(R.id.enter_param_b_field);
         EditText enterC = findViewById(R.id.enter_param_c_field);
         EditText enterD = findViewById(R.id.enter_param_d_field);
        if (enterA.getText().toString().equals("")
                || enterB.getText().toString().equals("")
                || enterC.getText().toString().equals("")
                || enterD.getText().toString().equals("")
                ) {
            return true;
        }
        return false;
    }

    public void runCalculation(View view) {
        runCalcIntent();
    }
}
