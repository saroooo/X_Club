package com.example.dalia.x_club;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextClock;
import android.widget.TextView;

public class trainingdatesActivity extends AppCompatActivity
{
    private RadioButton saturday,sunday,monday,tuesday,wednesday,thursday,friday;
    private TextClock satstr,satend,sunstr,sunend,monstr,monend,tuestr,tueend,wedstr,wedend,thurstr,thursend,fristr,friend;
    private TextView StartsAt,EndsAt;
    private Button update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainingdates);
        saturday = (RadioButton)findViewById(R.id.radioButton3);
        sunday = (RadioButton)findViewById(R.id.radioButton7);
        monday = (RadioButton)findViewById(R.id.radioButton9);
        tuesday = (RadioButton)findViewById(R.id.radioButton8);
        wednesday = (RadioButton)findViewById(R.id.radioButton6);
        thursday = (RadioButton)findViewById(R.id.radioButton5);
        friday = (RadioButton)findViewById(R.id.radioButton4);

        satstr = (TextClock)findViewById(R.id.textClock);
        satend = (TextClock)findViewById(R.id.textClock2);
        sunstr = (TextClock)findViewById(R.id.textClock3);
        sunend = (TextClock)findViewById(R.id.textClock4);
        monstr = (TextClock)findViewById(R.id.textClock5);
        monend = (TextClock)findViewById(R.id.textClock6);
        tuestr = (TextClock)findViewById(R.id.textClock7);
        tueend = (TextClock)findViewById(R.id.textClock8);
        wedstr = (TextClock)findViewById(R.id.textClock9);
        wedend = (TextClock)findViewById(R.id.textClock10);
        thurstr = (TextClock)findViewById(R.id.textClock11);
        thursend = (TextClock)findViewById(R.id.textClock12);
        fristr = (TextClock)findViewById(R.id.textClock13);
        friend = (TextClock)findViewById(R.id.textClock14);
        update = (Button)findViewById(R.id.button23);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // update the data

            }
        });

    }
}
