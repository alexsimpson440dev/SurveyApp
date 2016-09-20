package com.example.me5013zu.surveyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ConfigurationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);

        Button saveChanges = (Button) findViewById(R.id.save_changes_button);

        saveChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView question = (TextView) findViewById(R.id.textView);
                TextView response1 = (TextView) findViewById(R.id.textView2);
                TextView response2 = (TextView) findViewById(R.id.textView3);

                EditText editQuestion = (EditText) findViewById(R.id.edit_question);
                EditText editResponse1 = (EditText) findViewById(R.id.edit_response1);
                EditText editResponse2 = (EditText) findViewById(R.id.edit_response2);

                question.setText(editQuestion.getText());
                //response1.setText(editResponse1.getText());
                //response2.setText(editResponse2.getText());

            }
        });
    }
}
