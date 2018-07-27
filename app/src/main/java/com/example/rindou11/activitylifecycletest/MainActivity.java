package com.example.rindou11.activitylifecycletest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String TAG="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this,"On Create",Toast.LENGTH_LONG).show();
        Log.d(TAG,"On Create");

        if(savedInstanceState!=null){
            String resiveTempData=savedInstanceState.getString("data_temp_key");
            Toast.makeText(MainActivity.this,resiveTempData,Toast.LENGTH_LONG).show();
            Log.d(TAG,resiveTempData);
        }

        Button normalButton=(Button)findViewById(R.id.button_normail_activity);
        Button dialogButton=(Button)findViewById(R.id.button_dialog_activity);

        normalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent normalIntent=new Intent(MainActivity.this,NormalActivity.class);
                startActivity(normalIntent);
            }
        });

        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dialogIntent=new Intent(MainActivity.this,DialogActivity.class);
                startActivity(dialogIntent);
            }
        });
    }

    protected void onSaveInstanceState(Bundle tempOutState){
        String tempData="When the Activity is destory,save data in this method.";
        super.onSaveInstanceState(tempOutState);
        tempOutState.putString("date_temp_key",tempData);
    }

    protected void onStart(){
        super.onStart();
        Toast.makeText(MainActivity.this,"On Start",Toast.LENGTH_LONG).show();
        Log.d(TAG,"On Start");
    }

    protected void onPause(){
        super.onPause();
        Toast.makeText(MainActivity.this,"On Pause",Toast.LENGTH_LONG).show();
        Log.d(TAG,"On Pause");
    }

    protected void onResume(){
        super.onResume();
        Toast.makeText(MainActivity.this,"On Resume",Toast.LENGTH_LONG).show();
        Log.d(TAG,"On Resume");
    }

    protected void onStop(){
        super.onStop();
        Toast.makeText(MainActivity.this,"On Stop",Toast.LENGTH_LONG).show();
        Log.d(TAG,"On Stop");
    }

    protected void onDestroy(){
        super.onDestroy();
        Toast.makeText(MainActivity.this,"On Destroy",Toast.LENGTH_LONG).show();
        Log.d(TAG,"On Destroy");
    }

    protected void onRestart(){
        super.onRestart();
        Toast.makeText(MainActivity.this,"On Restart",Toast.LENGTH_LONG).show();
        Log.d(TAG,"On Restart");
    }

}
