package com.example.dalia.x_club;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class addactivityActivity extends AppCompatActivity {
    private EditText activityName,trainerName,trainerPhoneNumber,trainerEmail,startAt,endAt;
    private Button trainingdays,addactivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addactivity);
        activityName = (EditText)findViewById(R.id.editText38);
        trainerName = (EditText)findViewById(R.id.editText39);
        trainerPhoneNumber = (EditText)findViewById(R.id.editText40);
        trainerEmail = (EditText)findViewById(R.id.editText41);
        startAt = (EditText)findViewById(R.id.editText43);
        endAt = (EditText)findViewById(R.id.editText44);
        trainingdays = (Button)findViewById(R.id.button21);
        addactivity = (Button)findViewById(R.id.button20);

        trainingdays.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(addactivityActivity.this,trainingdatesActivity.class));
            }
        });
        addactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //add activity whith name , picture and trainer name
                startActivity(new Intent(addactivityActivity.this,activitiesProfileActivity.class));
            }
        });
    }
}
