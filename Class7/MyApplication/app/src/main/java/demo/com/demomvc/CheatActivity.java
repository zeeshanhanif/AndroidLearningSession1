package demo.com.demomvc;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class CheatActivity extends ActionBarActivity {

    public static final String EXTRA_ANSWER_IS_TRUE = "demo.com.demomvc.answer_is_true";
    private static final String TAG = "CheatActivity";
    public static final String EXTRA_ANSWER_SHOWN = "demo.com.demomvc.answer_shown";

    private boolean answer;
    private Button showAnswerBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        resultShown(false);
        answer = getIntent().getBooleanExtra(CheatActivity.EXTRA_ANSWER_IS_TRUE,false);
        Log.d(TAG,"Answer is = "+answer);
        showAnswerBtn = (Button)findViewById(R.id.showAnswerBtn);
        showAnswerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CheatActivity.this, "Answer Shown", Toast.LENGTH_SHORT).show();
                resultShown(true);
            }
        });


    }

    private void resultShown(boolean isAnswerShown){
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK, data);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cheat, menu);
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
