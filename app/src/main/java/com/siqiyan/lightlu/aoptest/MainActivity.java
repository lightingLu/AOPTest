package com.siqiyan.lightlu.aoptest;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "AOPDemo";
    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    @BehaviorTimeTrace("摇一摇")
    public void shake(View view){
        SystemClock.sleep(3000);
        Log.i(TAG,"摇到一个妹子，距离500公里");

    }
//    @BehaviorTimeTrace("发语音")
    public void sendvoice(View view){
        Log.i(TAG,"不使用AOP:摇一摇 使用时间：   "+simpleDateFormat.format(new Date()));
        long beagin=System.currentTimeMillis();

        SystemClock.sleep(3000);
        Log.i(TAG,"摇到一个妹子，距离500公里");
        Log.i(TAG,"消耗时间：  "+(System.currentTimeMillis()-beagin)+"ms");


    }

    @BehaviorTimeTrace("发图片")
    public void sendphoto(View view){
        SystemClock.sleep(2000);
        Log.i(TAG,"毫无PS的一个照片");

    }
}
