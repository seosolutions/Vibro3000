package com.leroi.vibro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class MainActivity extends ActionBarActivity {

    Button rhythm_button;
    Button about_button;
    Button share_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_screen);
        //Adding Static Adverts. Not really functional, just for learning purposes
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        
        rhythm_button = (Button) findViewById(R.id.rhythms_btn);
        about_button = (Button) findViewById(R.id.about_btn);
        //not sure if i really want this button. I'll deal with it later.....
        share_button = (Button) findViewById(R.id.share_btn);

        about_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAboutActivity();
            }
        });

        rhythm_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRhythmActivity();
            }
        });
    }

    public void startRhythmActivity() {
        Intent launchRhythmActivity = new Intent(this, RhythmActivity.class);
        startActivity(launchRhythmActivity);

    }
    public void startAboutActivity(){

        Intent launchAboutActivity = new Intent(this, AboutActivity.class);
        startActivity(launchAboutActivity);
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
