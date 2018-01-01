package com.example.arondillqs5328.laboratorna_3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    public double mA;
    public double mB;
    public double mC;
    public double mD;
    public double mPerimeter;
    public double mArea;
    public Intent valueFromIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        if (savedInstanceState != null) {
//            if (newMaxValue(savedInstanceState.getDouble("value_mPerimeter"), savedInstanceState.getDouble("value_mArea"))) {
                mA = savedInstanceState.getDouble("value_mA");
                mB = savedInstanceState.getDouble("value_mB");
                mC = savedInstanceState.getDouble("value_mC");
                mD = savedInstanceState.getDouble("value_mD");
                mPerimeter = savedInstanceState.getDouble("value_mPerimeter");
                mArea = savedInstanceState.getDouble("value_mArea");
                setTextMaxValue(mA, mB, mC, mD, mPerimeter, mArea);
//            }
        }
        else {
            valueFromIntent = getIntent();
            mA = Double.parseDouble(valueFromIntent.getStringExtra("valueA"));
            mB = Double.parseDouble(valueFromIntent.getStringExtra("valueB"));
            mC = Double.parseDouble(valueFromIntent.getStringExtra("valueC"));
            mD = Double.parseDouble(valueFromIntent.getStringExtra("valueD"));
            mPerimeter = Double.parseDouble(valueFromIntent.getStringExtra("valueA")) +
                    Double.parseDouble(valueFromIntent.getStringExtra("valueB")) +
                    Double.parseDouble(valueFromIntent.getStringExtra("valueC")) +
                    Double.parseDouble(valueFromIntent.getStringExtra("valueD"));
            mArea = (Double.parseDouble(valueFromIntent.getStringExtra("valueA")) +
                    Double.parseDouble(valueFromIntent.getStringExtra("valueB"))) / 2;

            setTextMaxValue(mA, mB, mC, mD, mPerimeter, mArea);
        }
    }

    private void setTextMaxValue(double mA, double mB, double mC, double mD, double mPerimeter, double mArea) {
        String str = "Max Value:\n" + "a = " + mA + " b = " + mB + " c = " + mC + " d = " + mD + "\n" + "perimeter = " + mPerimeter + "\narea = " + mArea;
        TextView textView = findViewById(R.id.text_view_max_value);
        textView.setText(str);
    }

    private boolean newMaxValue(Double mPerimeter, Double mArea) {
        valueFromIntent = getIntent();

        if (mPerimeter > Double.parseDouble(valueFromIntent.getStringExtra("valueA")) +
                Double.parseDouble(valueFromIntent.getStringExtra("valueB")) +
                Double.parseDouble(valueFromIntent.getStringExtra("valueC")) +
                Double.parseDouble(valueFromIntent.getStringExtra("valueD")) ||
                mArea > (Double.parseDouble(valueFromIntent.getStringExtra("valueA")) +
                        Double.parseDouble(valueFromIntent.getStringExtra("valueB"))) / 2) {
            return true;
        }
        return false;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble("value_mA", mA);
        outState.putDouble("value_mB", mB);
        outState.putDouble("value_mC", mC);
        outState.putDouble("value_mD", mD);
        outState.putDouble("value_mPerimeter", mPerimeter);
        outState.putDouble("value_mArea", mArea);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_2, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.enter_value:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.info:
                intent = new Intent(this, InfoActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
