package com.demo.demofragments;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements
        DemoFragment.OnFragmentInteractionListener {

    private Button frag1;
    private Button frag2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frag1 = (Button)findViewById(R.id.frag1);
        frag2 = (Button) findViewById(R.id.frag2);


        frag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager();
                getFragmentManager().beginTransaction()
                        .add(R.id.fragmentContainer, new DemoFragment())
                        .commit();
            }
        });
        frag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer, Demo2Fragment.newInstance("Fragment with Bundle"))
                        .commit();

            }
        });

    }

    @Override
    public void changeFragment() {
        Toast.makeText(this,"From Fragment",Toast.LENGTH_SHORT).show();
        getFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, Demo2Fragment.newInstance("Fragment with Bundle"))
                .commit();
    }
}
