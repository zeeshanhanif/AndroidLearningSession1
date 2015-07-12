package com.demo.demofirebase;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends ActionBarActivity {
    Firebase myFirebaseRef;
    Button updateBtn;
    EditText firstName;
    EditText lastName;
    EditText age;
    EditText userId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);
        myFirebaseRef = new Firebase("https://demoandroid1.firebaseio.com/");
        updateBtn = (Button)findViewById(R.id.updateBtn);
        firstName = (EditText)findViewById(R.id.firstName);
        lastName = (EditText)findViewById(R.id.lastName);
        age = (EditText)findViewById(R.id.age);
        userId = (EditText)findViewById(R.id.userid);
        //addListeners();
        //addListenersForUserIds();
        addListenersForArray();
    }


    public void addListeners(){

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HashMap<String,Object> data = new HashMap<String, Object>();
                data.put("firstName",firstName.getText().toString());
                data.put("lastName",lastName.getText().toString());
                data.put("age",age.getText().toString());

                myFirebaseRef.child("users").setValue(data, new Firebase.CompletionListener() {
                    @Override
                    public void onComplete(FirebaseError firebaseError, Firebase firebase) {
                        Toast.makeText(MainActivity.this,"Data saved",Toast.LENGTH_SHORT);
                    }
                });
            }
        });


        myFirebaseRef.child("message").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                //System.out.println(snapshot.getValue());  //prints "Do you have data? You'll love Firebase."
                //message.setText(snapshot.getValue().toString());
            }
            @Override public void onCancelled(FirebaseError error) { }
        });
    }

    public void addListenersForUserIds(){

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HashMap<String,Object> data = new HashMap<String, Object>();
                data.put("firstName",firstName.getText().toString());
                data.put("lastName",lastName.getText().toString());
                data.put("age",age.getText().toString());

                myFirebaseRef.child("users").child(userId.getText().toString()).setValue(data, new Firebase.CompletionListener() {
                    @Override
                    public void onComplete(FirebaseError firebaseError, Firebase firebase) {
                        Toast.makeText(MainActivity.this,"Data saved",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });



    }

    public void addListenersForArray(){

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HashMap<String,Object> data = new HashMap<String, Object>();
                data.put("firstName",firstName.getText().toString());
                data.put("lastName",lastName.getText().toString());
                data.put("age",age.getText().toString());

                myFirebaseRef.child("usersArray").push().setValue(data, new Firebase.CompletionListener() {
                    @Override
                    public void onComplete(FirebaseError firebaseError, Firebase firebase) {
                        Toast.makeText(MainActivity.this,"Data saved",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
