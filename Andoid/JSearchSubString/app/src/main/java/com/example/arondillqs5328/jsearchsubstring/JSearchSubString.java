package com.example.arondillqs5328.jsearchsubstring;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import java.util.HashMap;

public class JSearchSubString extends AppCompatActivity {
    Button runButton;
    EditText editString;
    EditText editSubString;
    TextView resultTextView;

    RadioButton radio1;
    RadioButton radio2;
    RadioButton radio3;
    RadioButton radio4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsearch_sub_string);

        runButton = (Button) findViewById(R.id.runButton);
        editString = (EditText) findViewById(R.id.editString);
        editSubString = (EditText) findViewById(R.id.editSubString);
        resultTextView = (TextView) findViewById(R.id.resultTextView);

        radio1 = (RadioButton) findViewById(R.id.radioButton1);
        radio2 = (RadioButton) findViewById(R.id.radioButton2);
        radio3 = (RadioButton) findViewById(R.id.radioButton3);
        radio4 = (RadioButton) findViewById(R.id.radioButton4);

        runButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstString = editString.getText().toString();
                String subString = editSubString.getText().toString();

                //TODO: пронцип: ЩО_ШУКАЄМ, ДЕ_ШУКАЄМ
                if (radio1.isChecked() && firstString.length() > 0 && subString.length() > 0) {
                    resultTextView.setText(lineSearch(subString, firstString));
                }
                if (radio2.isChecked() && firstString.length() > 0 && subString.length() > 0) {
                    resultTextView.setText(rabinSearch(subString, firstString));
                }
                if (radio3.isChecked() && firstString.length() > 0 && subString.length() > 0) {
                    resultTextView.setText(morisSearch(subString, firstString));
                }
                if (radio4.isChecked() && firstString.length() > 0 && subString.length() > 0) {
                    resultTextView.setText(muraSearch(subString, firstString));
                }
            }
        });
    }

    //Алгоритм послідовного(прямого) пошуку
    private String lineSearch(String subStr, String str) {
        int i = 0;
        while (i <= str.length() - subStr.length()) {
            if (str.substring(i, i + subStr.length()).equals(subStr)) {
                return "Знайдено";
            } else {
                i++;
            }
        }
        return "Не знайдено";
    }

    //Алгоритм Рабина-Карпа
    private String rabinSearch(String subStr, String str) {
        int strHCode = str.substring(0, subStr.length()).hashCode();
        int subStrHCode = subStr.hashCode();
        for (int i = 0; i + subStr.length() < str.length(); i++) {
            if (strHCode == subStrHCode) {
                if (str.substring(i, i + subStr.length()).equals(subStr)) {
                    return "Знайдено";
                }
            } else {
                strHCode = str.substring(i + 1, i + 1 + subStr.length()).hashCode();
                System.out.println(strHCode);
            }
        }
        if (strHCode == subStrHCode) {
            if (str.substring(str.length() - subStr.length(), str.length()).equals(subStr)) {
                return "Знайдено";
            }
        }
        return "Не знайдено";
    }

    //підметод алгоритма кнута-морріса-пратта
    private int[] prefix(String s) {
        int[] res = new int[s.length() + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = 0;
        }
        for (int i = 1; i < s.length() + 1; i++) {
            int k = res[i - 1];
            while (k > 0 && s.charAt(k) != s.charAt(i - 1)) {
                k = res[k - 1];
            }
            if (s.charAt(k) == s.charAt(i - 1)) {
                k++;
            }
            res[i] = k;
        }
        return res;
    }

    //Алгоритм Кнута-Морріса-Пратта
    private String morisSearch(String subStr, String str) {
        int index = -1;
        int[] f = prefix(subStr);
        int k = 0;
        for (int i = 0; i < str.length(); i++) {
            while (k > 0 && subStr.charAt(k) != str.charAt(i)) {
                k = f[k - 1];
            }
            if (subStr.charAt(k) == str.charAt(i)) {
                k = k + 1;
            }
            if (k == subStr.length()) {
                index = i - subStr.length() + 1;
                break;
            }
        }
        if (index > -1) {
            return "Знайдено";
        }
        return "Не знайдено";
    }

    //Алгоритм Бойєра-Мура
    private String muraSearch(String subStr, String str) {
        HashMap<Character, Integer> offsetTable = new HashMap<>();
        for (int i = 0; i < 256; i++) {
            offsetTable.put((char) i, subStr.length());
        }
        for (int i = 0; i < subStr.length() - 1; i++) {
            offsetTable.put(subStr.charAt(i), subStr.length() - i - 1);
        }
        int i = subStr.length() - 1;
        int j = i;
        int k = i;
        while (j >= 0 && i <= str.length() - 1) {
            j = subStr.length() - 1;
            k = i;
            while (j >= 0 && str.charAt(k) == subStr.charAt(j)) {
                k--;
                j--;
            }
            i += offsetTable.get(str.charAt(i));
        }
        if (k >= str.length() - subStr.length()) {
            return "Не знайдено";
        } else {
            return "Знайдено";
        }
    }
}
