package com.example.dalia.x_club;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;

public class addeventActivity extends AppCompatActivity
{
    private EditText eventName,eventDescribtion,startsIn,endsIn;
    private TextClock startsat,endsat;
    private Button addevent;
    private TextView start,end,at;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addevent);
        eventName= (EditText)findViewById(R.id.editText37);
        eventDescribtion = (EditText)findViewById(R.id.editText42);
        startsIn = (EditText)findViewById(R.id.editText45);
        endsIn = (EditText)findViewById(R.id.editText46);

        startsat = (TextClock)findViewById(R.id.textClock15);
        endsat = (TextClock)findViewById(R.id.textClock16);

        addevent= (Button)findViewById(R.id.button22);

        addevent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //add event whith name , picture and  dayes of it
                startActivity(new Intent(addeventActivity.this,eventsProfileActivity.class));
            }
        });


    }
}
