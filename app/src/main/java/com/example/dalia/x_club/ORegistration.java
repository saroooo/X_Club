package com.example.dalia.x_club;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.nio.Buffer;

public class ORegistration extends AppCompatActivity {
    private EditText editText2,editText15,editText3,editText9,editText10,editText14,editText13,editText16;
    private Button button7;
    private TextView textView5;
    private FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;
    String email, name, age, pass,address,phoneNo,clubName,clubAddress;
    String type="Owner";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oregistration);
        setupUIViews();
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(this);

        button7.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if(validate()){
                    //database
                    String user_email = editText3.getText().toString().trim();
                    String user_password = editText9.getText().toString().trim();
                    firebaseAuth.createUserWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {
                                //sendEmailVerification();
                                sendOData();
                                firebaseAuth.signOut();
                                Toast.makeText(ORegistration.this, "Successfully Registered, Upload complete!", Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(ORegistration.this, MainActivity.class));
                            } else {
                                Toast.makeText(ORegistration.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }
            }
        });

        textView5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ORegistration.this,MainActivity.class));

            }
        });

    }
    private void setupUIViews(){
        editText2=(EditText)findViewById(R.id.editText2);
        editText15=(EditText)findViewById(R.id.editText15);
        editText16=(EditText)findViewById(R.id.editText16);
        editText14=(EditText)findViewById(R.id.editText14);
        editText13=(EditText)findViewById(R.id.editText13);
        editText3=(EditText)findViewById(R.id.editText3);
        editText9=(EditText)findViewById(R.id.editText9);
        editText10=(EditText)findViewById(R.id.editText10);
        button7=(Button)findViewById(R.id.button7);
        textView5=(TextView)findViewById(R.id.textView5);

    }
    private Boolean validate(){
        Boolean result = false;
         name = editText2.getText().toString();
         pass = editText9.getText().toString();
         email = editText3.getText().toString();
         age=editText14.getText().toString();
         phoneNo=editText10.getText().toString();
         address=editText13.getText().toString();
        clubAddress=editText16.getText().toString();
        clubName=editText15.getText().toString();
        if(name.isEmpty() || pass.isEmpty() || email.isEmpty() || age.isEmpty() || address.isEmpty() || phoneNo.isEmpty() || clubAddress.isEmpty() || clubName.isEmpty()){
            Toast.makeText(this,"Please enter all the details",Toast.LENGTH_SHORT).show();
        }else{
            result=true;
        }
        return result;
    }
     private void sendOData(){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
     DatabaseReference myRef = firebaseDatabase.getReference("Owner");
     OwnerProfile oProfile = new OwnerProfile(age, email, name,address,phoneNo,clubName,clubAddress);
     FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
         myRef.child(firebaseUser.getUid()).setValue(oProfile);
      }
}
