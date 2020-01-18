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

public class OProfileActivity extends AppCompatActivity {

    //private ImageView profilePic;
    private TextView profileName, profileAge, profileEmail,profileAddress,profilePhone,profileCAddress,profileCName;
    private Button profileUpdate,button14;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oprofile);

        profileName = findViewById(R.id.editText23);
        profileAge = findViewById(R.id.editText29);
        profileEmail = findViewById(R.id.editText25);
        profileAddress=findViewById(R.id.editText27);
        profilePhone=findViewById(R.id.editText26);
        profileUpdate = findViewById(R.id.button4);
        profileCName=findViewById(R.id.editText24);
        profileCAddress=findViewById(R.id.editText28);
        button14=findViewById(R.id.button14);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        DatabaseReference databaseReference = firebaseDatabase.getReference("Owner");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                OwnerProfile ownerProfile = dataSnapshot.getValue(OwnerProfile.class);
                profileName.setText("Name: " + ownerProfile.getOwnerName());
                profileCName.setText("Club Name: "+ ownerProfile.getClubAddress());
                profileEmail.setText("Email: " + ownerProfile.getOwnerEmail());
                profileAge.setText("Age: " + ownerProfile.getOwnerAge());
                profilePhone.setText("Phone: "+ ownerProfile.getOwnerPhone());
                profileAddress.setText("Address:"+ownerProfile.getOwnerAddress() );


                profileCAddress.setText("Club Address: "+ ownerProfile.getClubAddress());


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(OProfileActivity.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();
            }
        });
        profileUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OProfileActivity.this,UpdateOProfile.class));
            }
        });
        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OProfileActivity.this,UpdatePassword.class));
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