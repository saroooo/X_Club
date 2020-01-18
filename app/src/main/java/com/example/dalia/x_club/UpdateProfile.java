package com.example.dalia.x_club;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UpdateProfile extends AppCompatActivity {
private EditText editText17,editText18,editText19,editText20,editText21;
private Button button11;

    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    String type="Member";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
        editText17=findViewById(R.id.editText17);
        editText18=findViewById(R.id.editText18);
        editText19=findViewById(R.id.editText19);
        editText20=findViewById(R.id.editText20);
        editText21=findViewById(R.id.editText21);
        button11=findViewById(R.id.button11);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final DatabaseReference databaseReference = firebaseDatabase.getReference("User");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                UserProfile userProfile = dataSnapshot.getValue(UserProfile.class);
                editText17.setText(userProfile.getUserName());
                editText18.setText( userProfile.getUserEmail());
                editText21.setText( userProfile.getUserAge());
                editText19.setText(userProfile.getUserAddress() );
                editText20.setText( userProfile.getUserPhone());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(UpdateProfile.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();
            }
        });
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name =editText17.getText().toString();
                String email=editText18.getText().toString();
                String age=editText19.getText().toString();
                String phone=editText20.getText().toString();
                String address=editText21.getText().toString();
                UserProfile userProfile=new UserProfile(age,email,name,address,phone);
                databaseReference.setValue(userProfile);
                finish();
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
