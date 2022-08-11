package com.example.buildflavours;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BuildCompat;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

public class SampleActivity extends AppCompatActivity {

    ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        layout=(ConstraintLayout) findViewById(R.id.layConstraintMain);

        // BuildConfig.BASE_URL
        Snackbar.make(this,layout,"URL: "+ BuildConfig.BASE_URL,Snackbar.LENGTH_LONG).show();


        // do something depending whether this is a productive build
        if (BuildConfig.IS_PRODUCTION) {
            //connectToProductionApiEndpoint();
        } else {
            //connectToStagingApiEndpoint();
        }
    }
}