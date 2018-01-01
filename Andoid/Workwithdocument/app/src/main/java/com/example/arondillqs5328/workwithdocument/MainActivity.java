package com.example.arondillqs5328.workwithdocument;

import android.content.res.Resources;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    Button btn2;
    TextView textView1;
    private static final String TAG = "Error";
    String[][] str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // arrayStringsLists = new ArrayList<>();

        btn1 = (Button) findViewById(R.id.button);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String line = "";
                    InputStream inputStream = getResources().openRawResource(R.raw.one);
                    textView1 = (TextView) findViewById(R.id.textView1);

                    if (inputStream != null) {
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                        int j = 0;
                        str = new String[5][5];
                        while ((line = bufferedReader.readLine()) != null) {
                            String[] strs = line.split(" ");
                            for (int i = 0; i < strs.length; i++) {
                                str[j][i] = strs[i];
                            }
                            j++;
                        }
//                        line = bufferedReader.readLine();
                        textView1.setText(str[0][0]);
                    }else{
                        textView1.setText("djsl");
                    }


                    inputStream.close();
                } catch (IOException e) {
                    Log.e(TAG, "Error" + e);
                }
            }
        });


//        btn2 = (Button) findViewById(R.id.button2);
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                try {
//                    update(getResources().openRawResource(R.raw.one));
//                } catch (IOException e) {
//                    Log.e(TAG, "ERROR" + e);
//                }
//            }
//        });
    }

//    public void update(OutputStream outputStream) {
//        textView1
//    }
}
