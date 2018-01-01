package com.example.arondillqs5328.laboratorna_7_kopcha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class Zav_1_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zav_1_);

        createResult();
    }

    private void createResult() {
        Intent intent = getIntent();

        ArrayList<String> upArrayList = new ArrayList<>();
        ArrayList<String> downArrayList = new ArrayList<>();


        char[] upLineArray = intent.getStringExtra("up").toCharArray();
        char[] downLineArray = intent.getStringExtra("down").toCharArray();

        for (int i = 0; i < upLineArray.length; i++) {
            upArrayList.add(String.valueOf(upLineArray[i]));
            downArrayList.add(String.valueOf(downLineArray[i]));
        }

        buildCircle(upArrayList, downArrayList);
    }

    private void buildCircle(ArrayList<String> upArrayList, ArrayList<String> downArrayList) {
        String upResultString = "";
        String downResultString = "";
        String upline = upArrayList.get(0) + downArrayList.get(downArrayList.indexOf(upArrayList.get(0)));

        while (upline.charAt(0) != upline.charAt(upline.length()-1)) {
            upline +=
        }
    }
}
