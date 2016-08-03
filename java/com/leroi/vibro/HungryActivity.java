package com.leroi.vibro;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class HungryActivity extends Activity {
    Button start_button;
    Button stop_button;
    Vibrator myVib;
    //Make the rhythms a little bit more interesting
    long[] pattern = {2000,4000,8000};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hungry);
        start_button = (Button) findViewById(R.id.start_btn);
        stop_button =  (Button) findViewById(R.id.stop_btn);
        myVib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myVib.vibrate(pattern,1);

            }
        });
        stop_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myVib.cancel();
            }
        });
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       
        int id = item.getItemId();

      
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    //I Believe that private is a better option
    private void onStop(){
        myVib.cancel();
       this.onStart();
    }


}
