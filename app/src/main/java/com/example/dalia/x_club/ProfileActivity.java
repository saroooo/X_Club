package com.example.dalia.x_club;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {

    //private ImageView profilePic;
    private TextView profileName, profileAge, profileEmail,profileAddress,profilePhone;
    private Button profileUpdate,button12,activities,events;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profileName = (TextView)findViewById(R.id.textView);
        profileAge = (TextView)findViewById(R.id.textView7);
        profileEmail = (TextView)findViewById(R.id.textView6);
        profileAddress= (TextView)findViewById(R.id.textView8);
        profilePhone= (TextView)findViewById(R.id.textView10);
        profileUpdate = (Button)findViewById(R.id.button8);
        button12= (Button)findViewById(R.id.button12);
        activities = (Button)findViewById(R.id.button16);
        events = (Button)findViewById(R.id.button17);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        DatabaseReference databaseReference = firebaseDatabase.getReference("User");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                UserProfile userProfile = dataSnapshot.getValue(UserProfile.class);
                profileName.setText("Name: " + userProfile.getUserName());
                profileEmail.setText("Email: " + userProfile.getUserEmail());
                profileAge.setText("Age: " + userProfile.getUserAge());
                profileAddress.setText("Address:"+userProfile.getUserAddress() );
                profilePhone.setText("Phone: "+ userProfile.getUserPhone());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(ProfileActivity.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();
            }
        });
        profileUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this,UpdateProfile.class));
            }
        });
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this,UpdatePassword.class));
            }
        });
        activities.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(ProfileActivity.this,activitiesProfileActivity.class));
            }
        });
        events.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(ProfileActivity.this,eventsProfileActivity.class));
            }
        });
    }
    public boolean onOptionsItemsSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}