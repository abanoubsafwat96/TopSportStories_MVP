package com.example.abanoub.topsportstories_MVP.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.example.abanoub.topsportstories_MVP.Communicator;
import com.example.abanoub.topsportstories_MVP.detailed.DetailedActivity;
import com.example.abanoub.topsportstories_MVP.detailed.DetailedActivityFragment;
import com.example.abanoub.topsportstories_MVP.R;
import com.example.abanoub.topsportstories_MVP.Story;

public class MainActivity extends AppCompatActivity implements Communicator {

    boolean twopane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FrameLayout frameLayout2 = (FrameLayout) findViewById(R.id.framelayout2);
        if (frameLayout2 == null)
            twopane = false;
        else
            twopane = true;

        MainActivityFragment mainActivityFragment = new MainActivityFragment();
        mainActivityFragment.setActivityReference(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout1, mainActivityFragment).commit();

    }

    @Override
    public void sendStory(Story story) {

        if (twopane) {
            DetailedActivityFragment detailedActivityFragment = new DetailedActivityFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("story", story);
            detailedActivityFragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout2, detailedActivityFragment).commit();
        } else {
            Intent i = new Intent(this, DetailedActivity.class);
            i.putExtra("story", story);
            startActivity(i);
        }
    }
}
