package com.example.tripplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Date;

public class StartTripActivity extends AppCompatActivity {

    private LinearLayout mainLayout; // The vertical layout that's used to hold the DT entries
    private Trip newTrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_trip);

        // Get references to UI elements and store them in data members
        mainLayout = findViewById(R.id.dtItemsPanel);
        Button addDTBtn = findViewById(R.id.addDTBtn);
        Button startTripBtn = findViewById(R.id.startTripBtn);

        // Create the Trip (must add DT objects to it as they get created)
        Date defaultDate = new Date(2020, 2, 6); // tmp Date used for testing
        newTrip = new Trip("Default Trip name", defaultDate, defaultDate); // tmp Trip using for testing

        /* -------------- CREATE LISTENERS -------------- */
        // Create the click listener for the Add button
        addDTBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create the DT object and add Trip List
                DT newDT = DT.CreateDestinationTransit(StartTripActivity.this, mainLayout, getString(R.string.dt_msg));
                newTrip.addDestination(newDT);
            }
        });

        // Create the click listener for the Start Trip buttons
        startTripBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               // Navigate to the tripReview page
               startActivity(new Intent(StartTripActivity.this, tripReview.class));
           }
        });
    }
}
