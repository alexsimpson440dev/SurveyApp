package com.example.me5013zu.surveyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ConfigurationActivity extends AppCompatActivity {

    public static final String EXTRA_QUESTION_TEXT = "com.example.me5013zu.surveyapp.quesitonText";
    public static final String EXTRA_RESPONSE1_TEXT = "com.example.me5013zu.surveyapp.response1Text";
    public static final String EXTRA_RESPONSE2_TEXT = "com.example.me5013zu.surveyapp.response2Text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);

        //Intent launchIntent = getIntent();

        //final String question = launchIntent.getStringExtra(SurveyApp.EXTRA_QUESTION);
        //final String response1 = launchIntent.getStringExtra(SurveyApp.EXTRA_RESPONSE1);
        //final String response2 = launchIntent.getStringExtra(SurveyApp.EXTRA_RESPONSE2);

        Button saveChanges = (Button) findViewById(R.id.save_changes_button);
        saveChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText editQuestion = (EditText) findViewById(R.id.edit_question);
                EditText editResponse1 = (EditText) findViewById(R.id.edit_response1);
                EditText editResponse2 = (EditText) findViewById(R.id.edit_response2);

                String question = editQuestion.getText().toString();
                String response1 = editResponse1.getText().toString();
                String response2 = editResponse2.getText().toString();

                Intent resultsIntent = new Intent();
                resultsIntent.putExtra(EXTRA_QUESTION_TEXT, question);
                resultsIntent.putExtra(EXTRA_RESPONSE1_TEXT, response1);
                resultsIntent.putExtra(EXTRA_RESPONSE2_TEXT, response2);
                setResult(RESULT_OK, resultsIntent);
                finish();

            }
        });
    }
}
