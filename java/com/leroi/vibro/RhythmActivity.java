package com.leroi.vibro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class RhythmActivity extends ActionBarActivity {
    //Menu for selecting various vibration capabilities. The names are quite elusive ;}
    Button lonely_button;
    Button bored_button;
    Button hungry_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rhythm);
        //May change names allowing users to set the names that they want
        lonely_button = (Button) findViewById(R.id.lonely_btn);
        bored_button = (Button) findViewById(R.id.bored_btn);
      hungry_button = (Button) findViewById(R.id.hungry_btn);

        lonely_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startLonelyActivity();
            }

        });
        bored_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              startBoredActivity();
            }
        });
        hungry_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startHungryActivity();
            }
        });
    }

    public void startLonelyActivity(){
        Intent launchLonelyActivity = new Intent(this, LonelyActivity.class);
        startActivity(launchLonelyActivity);
    }

    public void startBoredActivity(){
        Intent launchBoredActivity = new Intent(this, BoredActivity.class);
        startActivity(launchBoredActivity);

    }
    public void startHungryActivity(){
        Intent launchHungryActivity = new Intent(this,HungryActivity.class);
        startActivity(launchHungryActivity);
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
