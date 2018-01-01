package com.example.arondillqs5328.identifyimage;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    final String LOG_TAG = "loooog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickTVUpdate(View view) {
        if (((TextView) view).getText().toString().equals("0")) {
            view.setBackgroundColor(Color.rgb(0, 0, 0));
            ((TextView) view).setTextColor(Color.rgb(255, 255, 255));
            ((TextView) view).setText("1");
        } else {
            view.setBackgroundColor(Color.rgb(255, 255, 255));
            ((TextView) view).setTextColor(Color.rgb(0,0,0));
            ((TextView) view).setText("0");
        }
    }

    public void onClickRun(View view) {
        int[][] tv_1 = {{0, 0, 0, 0, 0, 0, 0, 0},
                {0, R.id.tv_1_11, R.id.tv_1_12, R.id.tv_1_13, R.id.tv_1_14, R.id.tv_1_15, R.id.tv_1_16, 0},
                {0, R.id.tv_1_21, R.id.tv_1_22, R.id.tv_1_23, R.id.tv_1_24, R.id.tv_1_25, R.id.tv_1_26, 0},
                {0, R.id.tv_1_31, R.id.tv_1_32, R.id.tv_1_33, R.id.tv_1_34, R.id.tv_1_35, R.id.tv_1_36, 0},
                {0, R.id.tv_1_41, R.id.tv_1_42, R.id.tv_1_43, R.id.tv_1_44, R.id.tv_1_45, R.id.tv_1_46, 0},
                {0, R.id.tv_1_51, R.id.tv_1_52, R.id.tv_1_53, R.id.tv_1_54, R.id.tv_1_55, R.id.tv_1_56, 0},
                {0, R.id.tv_1_61, R.id.tv_1_62, R.id.tv_1_63, R.id.tv_1_64, R.id.tv_1_65, R.id.tv_1_66, 0},
                {0, R.id.tv_1_71, R.id.tv_1_72, R.id.tv_1_73, R.id.tv_1_74, R.id.tv_1_75, R.id.tv_1_76, 0},
                {0, R.id.tv_1_81, R.id.tv_1_82, R.id.tv_1_83, R.id.tv_1_84, R.id.tv_1_85, R.id.tv_1_86, 0},
                {0, R.id.tv_1_91, R.id.tv_1_92, R.id.tv_1_93, R.id.tv_1_94, R.id.tv_1_95, R.id.tv_1_96, 0},
                {0, R.id.tv_1_101, R.id.tv_1_102, R.id.tv_1_103, R.id.tv_1_104, R.id.tv_1_105, R.id.tv_1_106, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}};

        int[][] tv_2 = {{0, 0, 0, 0, 0, 0, 0, 0},
                {0, R.id.tv_2_11, R.id.tv_2_12, R.id.tv_2_13, R.id.tv_2_14, R.id.tv_2_15, R.id.tv_2_16, 0},
                {0, R.id.tv_2_21, R.id.tv_2_22, R.id.tv_2_23, R.id.tv_2_24, R.id.tv_2_25, R.id.tv_2_26, 0},
                {0, R.id.tv_2_31, R.id.tv_2_32, R.id.tv_2_33, R.id.tv_2_34, R.id.tv_2_35, R.id.tv_2_36, 0},
                {0, R.id.tv_2_41, R.id.tv_2_42, R.id.tv_2_43, R.id.tv_2_44, R.id.tv_2_45, R.id.tv_2_46, 0},
                {0, R.id.tv_2_51, R.id.tv_2_52, R.id.tv_2_53, R.id.tv_2_54, R.id.tv_2_55, R.id.tv_2_56, 0},
                {0, R.id.tv_2_61, R.id.tv_2_62, R.id.tv_2_63, R.id.tv_2_64, R.id.tv_2_65, R.id.tv_2_66, 0},
                {0, R.id.tv_2_71, R.id.tv_2_72, R.id.tv_2_73, R.id.tv_2_74, R.id.tv_2_75, R.id.tv_2_76, 0},
                {0, R.id.tv_2_81, R.id.tv_2_82, R.id.tv_2_83, R.id.tv_2_84, R.id.tv_2_85, R.id.tv_2_86, 0},
                {0, R.id.tv_2_91, R.id.tv_2_92, R.id.tv_2_93, R.id.tv_2_94, R.id.tv_2_95, R.id.tv_2_96, 0},
                {0, R.id.tv_2_101, R.id.tv_2_102, R.id.tv_2_103, R.id.tv_2_104, R.id.tv_2_105, R.id.tv_2_106, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}};

        int[][] arrayImage_1 = new int[12][8];
        int[][] arrayImage_2 = new int[12][8];

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 8; j++) {
                arrayImage_1[i][j] = 0;
                arrayImage_2[i][j] = 0;
            }
        }

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 6; j++) {
                TextView textView_1 = findViewById(tv_1[i][j]);
                arrayImage_1[i][j] = Integer.valueOf(textView_1.getText().toString());

                TextView textView_2 = findViewById(tv_2[i][j]);
                arrayImage_2[i][j] = Integer.valueOf(textView_2.getText().toString());
            }
        }

        calc_evklid(arrayImage_1, arrayImage_2);
    }

    private void calc_evklid(int[][] arrayImage_1, int[][] arrayImage_2) {
        double evklid = 0.0;
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 6; j++) {
                evklid += Math.pow(arrayImage_1[i][j] - arrayImage_2[i][j], 2);
            }
        }

        Log.d(LOG_TAG, String.valueOf(evklid));
        setResult(Math.pow(evklid, 0.5));
    }

    private void setResult(double evklid) {
        TextView textView = findViewById(R.id.resultEvklid);
        textView.setText(String.valueOf(evklid));
    }

}
