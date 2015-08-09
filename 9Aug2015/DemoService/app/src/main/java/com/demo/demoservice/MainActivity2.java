package com.demo.demoservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity2 extends ActionBarActivity {

    MyService2 mMyService2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);


        ((Button)findViewById(R.id.button3)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this,MyService2.class);
                bindService(intent,mServiceConnection, Context.BIND_AUTO_CREATE);
            }
        });

        ((Button)findViewById(R.id.button5)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity2.this,mMyService2.doSomething(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    public ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            mMyService2 = ((MyService2.MyBinder)iBinder).getService();
            Toast.makeText(MainActivity2.this,"onServiceConnected",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
}
