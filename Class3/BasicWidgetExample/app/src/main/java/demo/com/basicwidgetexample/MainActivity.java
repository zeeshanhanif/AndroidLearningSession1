package demo.com.basicwidgetexample;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;


public class MainActivity extends ActionBarActivity {
TextView mTextView;
    Button mButton;
    RadioButton mRadioButton;
    CheckBox mCheckBox;
    ToggleButton mToggleButton;
    RatingBar mRatingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.textView);
        mButton = (Button) findViewById(R.id.button);
        mRadioButton = (RadioButton) findViewById(R.id.radioButton);
        mCheckBox = (CheckBox) findViewById(R.id.checkBox);
        mToggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        mRatingBar = (RatingBar) findViewById(R.id.ratingBar);


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setText("this is plain textViw");
            }
        });
         mRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 Toast.makeText(MainActivity.this, "State"+ isChecked,Toast.LENGTH_SHORT).show();
             }
         });
         mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if(isChecked){
                     Toast.makeText(MainActivity.this, "State"+ isChecked,Toast.LENGTH_SHORT).show();
                 }
                 else {
                     Toast.makeText(MainActivity.this, "State"+ isChecked,Toast.LENGTH_SHORT).show();
                 }
             }
         });

        mToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean on = ((ToggleButton)v).isChecked();
                if(on){
                    Toast.makeText(MainActivity.this, "State: "+ on,Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "State: "+ on,Toast.LENGTH_SHORT).show();
                }
            }
        });

        mRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                mTextView.setText(""+rating);
            }
        });
    }
}
