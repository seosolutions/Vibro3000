package com.leroi.vibro;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class BoredActivity extends Activity {

    Button start_button;
    Button stop_button;
    Vibrator myVib;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bored);
        start_button = (Button) findViewById(R.id.start_btn);
        stop_button =  (Button) findViewById(R.id.stop_btn);
        myVib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Bored people may need something that last a while longer
                //TODO: ALLOW USERS TO SET THEIR OWN VIBRATION PARAMETERS
                myVib.vibrate(200000);

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
    @Override
    /*
    * This prevents the app from crashing when the back button is clicked. Also stops the vibrator.
    * */
    public void onStop(){
        myVib.cancel();
        this.onStart();
    }
}
