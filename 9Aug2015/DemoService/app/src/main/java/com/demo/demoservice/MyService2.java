package com.demo.demoservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

import java.io.FileDescriptor;

public class MyService2 extends Service {

    MyBinder binder = new MyBinder();
    public  class MyBinder extends Binder {
        public MyService2 getService(){
            return MyService2.this;
        }
    }

    public MyService2() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return binder;
    }

    public String doSomething(){
        return "studying";
    }
}
