package com.example.me5013zu.surveyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SurveyApp extends AppCompatActivity {

    //extras to carry data to other activities
    //used for the results activity
    public static final String EXTRA_SHOW_RESULTS_YES = "com.example.me5013zu.surveyapp.showResultsYes";
    public static final String EXTRA_SHOW_RESULTS_NO = "com.example.me5013zu.surveyapp.showResultsNo";
    //used for the configuration activity
    public static final String EXTRA_QUESTION = "com.example.me5013zu.surveyapp.question";
    public static final String EXTRA_RESPONSE1 = "com.example.me5013zu.surveyapp.response1";
    public static final String EXTRA_RESPONSE2 = "com.example.me5013zu.surveyapp.response2";
    private static final int CONFIGURATION_REQUEST_CODE = 0;

    //tags for logging
    private static String TAG = "SurveyApp";
    private static String KEY_INDEX_YES = "indexY";
    private static String KEY_INDEX_NO = "indexN";

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
        Button mResetButton = (Button) findViewById(R.id.reset_button);
        Button mConfigureButton = (Button) findViewById(R.id.configure_button);
        TextView questionText = (TextView) findViewById(R.id.textView);

        //variables for the textviews and strings to edit for configuration
        final String question = questionText.getText().toString();
        final String response1 = mYesButton.getText().toString();
        final String response2 = mNoButton.getText().toString();

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

        //button click method that opens the result activity
        mResultsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchResultsActivity = new Intent(SurveyApp.this, ResultsActivity.class);
                launchResultsActivity.putExtra(EXTRA_SHOW_RESULTS_YES, yesButtonCounter);
                launchResultsActivity.putExtra(EXTRA_SHOW_RESULTS_NO, noButtonCounter);
                startActivity(launchResultsActivity);
            }
        });

        //button click method that resets the counters
        mResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yesButtonCounter = 0;
                noButtonCounter = 0;
            }
        });

        //button click method that opens the configure activity
        mConfigureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchConfigureActivity = new Intent(SurveyApp.this, ConfigurationActivity.class);
                launchConfigureActivity.putExtra(EXTRA_QUESTION, question);
                launchConfigureActivity.putExtra(EXTRA_RESPONSE1, response1);
                launchConfigureActivity.putExtra(EXTRA_RESPONSE2, response2);
                startActivityForResult(launchConfigureActivity, CONFIGURATION_REQUEST_CODE);
            }
        });

        if (savedInstanceState != null) {
            yesButtonCounter = savedInstanceState.getInt(KEY_INDEX_YES, 0);
            noButtonCounter = savedInstanceState.getInt(KEY_INDEX_NO, 0);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putInt(KEY_INDEX_YES, yesButtonCounter);
        savedInstanceState.putInt(KEY_INDEX_NO, noButtonCounter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        TextView question = (TextView) findViewById(R.id.textView);
        Button mYesButton = (Button) findViewById(R.id.yes_button);
        Button mNoButton = (Button) findViewById(R.id.no_button);

        question.setText(data.getStringExtra(ConfigurationActivity.EXTRA_QUESTION_TEXT));
        mYesButton.setText(data.getStringExtra(ConfigurationActivity.EXTRA_RESPONSE1_TEXT));
        mNoButton.setText(data.getStringExtra(ConfigurationActivity.EXTRA_RESPONSE2_TEXT));
    }
}
