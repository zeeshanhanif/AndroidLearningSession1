package demo.com.quizapplication;

import android.app.ActionBar;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class QuizActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Button bt1 = (Button)findViewById(R.id.btn1);
        bt1.setText("From Code");

        MyListener myListener = new MyListener();

        //bt1.setOnClickListener(myListener);
        //bt1.setOnClickListener(new MyListener());
        /*bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Activity","This is click listener in method");
            }
        });*/
        bt1.setOnClickListener(new MyListener() {
            @Override
            public void onClick(View v){
                Log.d("Activity","This is click listener in method MyLister");
            }
        });




//

    }
}
class MyListener implements View.OnClickListener {
    @Override
    public void onClick(View v){
        Log.d("Activity","This is click listener");
    }
}