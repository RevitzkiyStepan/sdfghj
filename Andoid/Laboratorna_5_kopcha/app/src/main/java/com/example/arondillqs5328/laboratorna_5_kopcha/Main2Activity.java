package com.example.arondillqs5328.laboratorna_5_kopcha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Arrays;

public class Main2Activity extends AppCompatActivity {

    private ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        createResult();
    }

    private void createResult() {
        Intent intent = getIntent();
        arrayList = new ArrayList<>();

        if (intent.getStringExtra("all").equals("all")) {
            char[] str = intent.getStringExtra("NextTransposition").toCharArray();
            Arrays.sort(str);
            arrayList.add(String.valueOf(str));

            while (isNext(arrayList.get(arrayList.size()-1))) {
                getNextTransposition(arrayList.get(arrayList.size()-1));
            }
        } else {
            arrayList.add(intent.getStringExtra("NextTransposition"));
            getNextTransposition(arrayList.get(arrayList.size()-1));
        }

        setListView();
    }

    private void setListView() {
        ListView listView = findViewById(R.id.listViewResult);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(adapter);
    }

    private boolean isNext(String str) {
        char[] chars = str.toCharArray();
        for (int i = chars.length - 1; i > 0; i--) {
            if (chars[i] > chars[i-1]) {
                return true;
            }
        }
        return false;
    }

    private void getNextTransposition(String str) {
        char[] chars = str.toCharArray();
        int pos = 0;
        for (int i = chars.length - 1; i > 0; i--) {
            if (chars[i] > chars[i-1]) {
                pos = i;
                break;
            }
        }

        char minE = Character.MAX_VALUE;
        int pos2 = 0;
        for(int i = pos - 1; i < chars.length; i++) {
            for (int j = i; j < chars.length; j++) {
                if (chars[j] > chars[i] && chars[j] < minE) {
                    minE = chars[j];
                    pos2 = j;
                }
            }
        }
        char k = chars[pos-1];
        chars[pos-1] = chars[pos2];
        chars[pos2] = k;

        Arrays.sort(chars, pos, chars.length);

        arrayList.add(String.valueOf(chars));
    }

}
