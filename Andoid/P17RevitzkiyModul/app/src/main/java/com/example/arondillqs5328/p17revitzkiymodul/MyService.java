package com.example.arondillqs5328.p17revitzkiymodul;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by aronDillQs5328 on 21.12.2017.
 */

public class MyService extends Service {

    final String LOG_TAG = "myLog";
    private int valueA = 0;
    private int valueB = 0;
    private int valueC = 0;
    private int k = 0;
    private ArrayList<Integer> arrayList = new ArrayList<>();

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(LOG_TAG, "onCreateService");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(LOG_TAG, "onDestroyService");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(LOG_TAG, "onBind");
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(LOG_TAG, "onStartService");

       valueA = Integer.parseInt(intent.getStringExtra("valueA"));
       valueB = Integer.parseInt(intent.getStringExtra("valueB"));
       valueC = Integer.parseInt(intent.getStringExtra("valueC"));
        Log.d(LOG_TAG, String.valueOf(valueA));
        Log.d(LOG_TAG, String.valueOf(valueB));
        Log.d(LOG_TAG, String.valueOf(valueC));

        calcResult();
        Toast toast = Toast.makeText(this, "result = " + String.valueOf(k), Toast.LENGTH_LONG);
        toast.show();
        return super.onStartCommand(intent, flags, startId);
    }

    public void calcResult() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                arrayList.add(valueA);
                arrayList.add(valueB);

                int i = 2;
                while (true) {
                    if (arrayList.get(i - 1) + arrayList.get(i - 2) < valueC) {
                        arrayList.add(arrayList.get(i - 1) + arrayList.get(i - 2));
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
