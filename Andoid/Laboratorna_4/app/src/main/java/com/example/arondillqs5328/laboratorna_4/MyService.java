package com.example.arondillqs5328.laboratorna_4;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class MyService extends Service {

    final String LOG_TAG = "myLog";
    private int maxValue = 0;
    private int determinant = 0;
    private int aValue = 0;
    public static boolean runnable = false;
    private int k = 2;
    private ArrayList<Integer> arrayList = new ArrayList<>();


    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(LOG_TAG, "onCreateService");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast toast = Toast.makeText(this, "result = " + String.valueOf(k), Toast.LENGTH_LONG);
        toast.show();
        Log.d(LOG_TAG, "onDestroyService");
        Log.d(LOG_TAG, String.valueOf(k));
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(LOG_TAG, "onBind");
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(LOG_TAG, "onStartService");

        maxValue = Integer.parseInt(intent.getStringExtra("maxValue"));
        determinant = Integer.parseInt(intent.getStringExtra("determValue"));
        aValue = Integer.parseInt(intent.getStringExtra("aValue"));
        Log.d(LOG_TAG, String.valueOf(maxValue));
        Log.d(LOG_TAG, String.valueOf(determinant));
        Log.d(LOG_TAG, String.valueOf(aValue));
        calcMatrix();
        return super.onStartCommand(intent, flags, startId);
    }

    public void calcMatrix() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                arrayList.add(maxValue);
                arrayList.add(determinant);

                int i = 2;
                while (true) {
                    if (arrayList.get(i - 1) + arrayList.get(i - 2) < aValue) {
                        arrayList.add(arrayList.get(i - 1) + arrayList.get(i - 2));
                        Log.d(LOG_TAG, String.valueOf(arrayList.get(i)));
                        i++;
                        k++;
                    } else {
                        break;
                    }
                }
            }
        }).start();
    }
}
