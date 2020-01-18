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

public class UpdateOProfile extends AppCompatActivity {
    private EditText editText30,editText31,editText32,editText33,editText34,editText35,editText36;
    private Button button15;

    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    String type="Owner";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_oprofile);
        editText30=findViewById(R.id.editText30);
        editText31=findViewById(R.id.editText31);
        editText32=findViewById(R.id.editText32);
        editText33=findViewById(R.id.editText33);
        editText34=findViewById(R.id.editText34);
        editText35=findViewById(R.id.editText35);
        editText36=findViewById(R.id.editText36);

        button15=findViewById(R.id.button15);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final DatabaseReference databaseReference = firebaseDatabase.getReference("Owner");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                OwnerProfile oProfile = dataSnapshot.getValue(OwnerProfile.class);
                editText30.setText(oProfile.getOwnerName());
                editText32.setText( oProfile.getOwnerEmail());
                editText34.setText( oProfile.getOwnerAge());
                editText35.setText(oProfile.getOwnerAddress() );
                editText33.setText( oProfile.getOwnerPhone());
                editText31.setText(oProfile.getClubName());
                editText36.setText(oProfile.getClubAddress());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(UpdateOProfile.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();
            }
        });
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name =editText30.getText().toString();
                String email=editText32.getText().toString();
                String age=editText34.getText().toString();
                String phone=editText33.getText().toString();
                String address=editText35.getText().toString();
                String cname=editText31.getText().toString();
                String caddress=editText36.getText().toString();
                OwnerProfile oProfile=new OwnerProfile(age,email,name,address,phone,cname,caddress);
                databaseReference.setValue(oProfile);
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
