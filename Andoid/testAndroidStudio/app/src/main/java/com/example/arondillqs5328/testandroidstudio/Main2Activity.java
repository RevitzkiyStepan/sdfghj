package com.example.arondillqs5328.testandroidstudio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private static double sA = 0.0,
            sB = 0.0,
            sC = 0.0,
            sD = 0.0,
            sPerimeter = 0.0,
            sArea = 0.0;

    private Intent valueFromIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        updateItem();
    }

    private void updateItem() {
        valueFromIntent = getIntent();
        if (newParams()) {
            setParam(sA, sB, sC, sD, sPerimeter, sArea);
            setNewParam();
        } else {
            setParam(sA, sB, sC, sD, sPerimeter, sArea);
            setNewParam();
        }
    }

    private void setNewParam() {
        Double a = 0.0,
                b = 0.0,
                c = 0.0,
                d = 0.0,
                perimeter = 0.0,
                area = 0.0;
        try {
            a = Double.parseDouble(valueFromIntent.getStringExtra("valueA"));
            b = Double.parseDouble(valueFromIntent.getStringExtra("valueB"));
            c = Double.parseDouble(valueFromIntent.getStringExtra("valueC"));
            d = Double.parseDouble(valueFromIntent.getStringExtra("valueD"));
            perimeter = a + b + c + d;
            area = (a + b) / 2.0;
        } catch (Exception ex) {

        }
        String str = "a: " + a + " b: " + b + " c: " + c + " d: " + d
                + "\n" + "Perimeter: " + perimeter
                + "\n" + "Area: " + area;

        TextView textView = findViewById(R.id.new_value);
        textView.setText(str);

    }

    private void setParam(double a, double b, double c, double d, double perimeter, double area) {
        String str = "a: " + a + " b: " + b + " c: " + c + " d: " + d
                + "\n" + "Perimeter: " + perimeter
                + "\n" + "Area: " + area;

        TextView textView = findViewById(R.id.last_max_value);
        textView.setText(str);
    }

    private boolean newParams() {
        Double a = 0.0,
                b = 0.0,
                c = 0.0,
                d = 0.0,
                perimeter = 0.0,
                area = 0.0;
        try {
            a = Double.parseDouble(valueFromIntent.getStringExtra("valueA"));
            b = Double.parseDouble(valueFromIntent.getStringExtra("valueB"));
            c = Double.parseDouble(valueFromIntent.getStringExtra("valueC"));
            d = Double.parseDouble(valueFromIntent.getStringExtra("valueD"));
            perimeter = a + b + c + d;
            area = (a + b) / 2.0;
        } catch (Exception ex) {

        }

        if (perimeter > sPerimeter || area > sArea) {
            sA = a;
            sB = b;
            sC = c;
            sD = d;
            sPerimeter = perimeter;
            sArea = area;
            return true;
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_res_2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        final Intent intent;
        switch (item.getItemId()) {
            case R.id.first:
                intent = new Intent(this, Main1Activity.class);
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
