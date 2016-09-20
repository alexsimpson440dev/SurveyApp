package com.example.me5013zu.surveyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Intent lauchIntent = getIntent();

        int yesCounter = lauchIntent.getIntExtra(SurveyApp.EXTRA_SHOW_RESULTS_YES, 0);
        int noCounter = lauchIntent.getIntExtra(SurveyApp.EXTRA_SHOW_RESULTS_NO, 0);

        TextView yesText = (TextView) findViewById(R.id.yes_results);
        TextView noText = (TextView) findViewById(R.id.no_results);

        yesText.setText("Yes: " + yesCounter);
        noText.setText("No: " + noCounter);
    }
}
