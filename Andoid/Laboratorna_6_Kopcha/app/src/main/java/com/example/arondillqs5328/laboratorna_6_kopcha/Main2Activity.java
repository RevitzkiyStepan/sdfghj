package com.example.arondillqs5328.laboratorna_6_kopcha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class Main2Activity extends AppCompatActivity {

    private ArrayList<String> arrayListResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        createResult();
        setListItem();
    }

    private void setListItem() {
        ListView listView = findViewById(R.id.listViewResult);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayListResult);
        listView.setAdapter(adapter);
    }

    private void createResult() {
        Intent intent = getIntent();

        int valN = Integer.valueOf(intent.getStringExtra("valueN"));
        int valR = Integer.valueOf(intent.getStringExtra("valueR"));

        arrayListResult = new ArrayList<>();
        arrayListResult.add(getFirstElem(valR));


        while (isNextCombination(arrayListResult.get(arrayListResult.size() - 1), valN, valR)) {
            getNextCombination(arrayListResult.get(arrayListResult.size() - 1), valN, valR);
        }
    }

    private void getNextCombination(String s, int valN, int valR) {
        String[] chars = s.split(" ");
        int pos = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (Integer.valueOf(chars[i]) != valN - valR + i + 1) {
                pos = i;
                break;
            }
        }

        chars[pos] = String.valueOf(Integer.valueOf(chars[pos]) + 1);

        for (int i = pos + 1; i < chars.length; i++) {
            chars[i] = String.valueOf(Integer.valueOf(chars[i - 1]) + 1);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            stringBuilder.append(chars[i]).append(" ");
        }

        arrayListResult.add(String.valueOf(stringBuilder));
    }

    private boolean isNextCombination(String s, int valN, int valR) {
        String[] chars = s.split(" ");
        for (int i = chars.length - 1; i >= 0; i--) {
            if (Integer.valueOf(chars[i]) != valN - valR + i + 1) {
                return true;
            }
        }
        return false;
    }

    private String getFirstElem(int n) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++) {
            str.append(i + 1).append(" ");
        }
        return str.toString();
    }
}
