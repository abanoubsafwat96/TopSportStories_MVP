package com.example.abanoub.topsportstories_MVP.detailed;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.abanoub.topsportstories_MVP.R;

public class DetailedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle bundle = getIntent().getExtras();
        DetailedActivityFragment detailedActivityFragment=new DetailedActivityFragment();
        detailedActivityFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout1, detailedActivityFragment).commit();
    }
}
