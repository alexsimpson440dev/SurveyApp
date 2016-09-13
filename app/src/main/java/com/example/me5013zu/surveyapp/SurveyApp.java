package com.example.me5013zu.surveyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SurveyApp extends AppCompatActivity {

    //private int counters for each button.
    //will count the number of times the yes/no buttons were clicked
    private int yesButtonCounter = 0;
    private int noButtonCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey_app);

        //button variable that read from xml file to access the button clicks
        Button mYesButton = (Button) findViewById(R.id.yes_button);
        Button mNoButton = (Button) findViewById(R.id.no_button);
        Button mResultsButton = (Button) findViewById(R.id.results_button);

        //button click method that adds one to the yes counter
        mYesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yesButtonCounter = (yesButtonCounter + 1);
            }
        });

        //button click method that adds one to the no counter
        mNoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noButtonCounter = (noButtonCounter + 1);
            }
        });

        //button click method that shows a toast of the yes and no results
        mResultsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SurveyApp.this, "Yes Total: " + yesButtonCounter + ", No Total: " + noButtonCounter, Toast.LENGTH_LONG).show();
            }
        });
    }
}
