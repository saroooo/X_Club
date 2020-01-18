package com.example.dalia.x_club;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.media.Image;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.BufferedReader;

public class Registration extends AppCompatActivity {
    private EditText editText4,editText5,editText6,editText7,editText8,editText;
    private Button button2;
    private TextView textView2;
    private FirebaseAuth firebaseAuth;
    String email, name, age, password,address,phoneNo;
    String type="Member";
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        setupUIViews();
        firebaseAuth = FirebaseAuth.getInstance();
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate()) {
                    //Upload data to the database
                    String user_email = editText5.getText().toString().trim();
                    String user_password = editText6.getText().toString().trim();
                    firebaseAuth.createUserWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {
                                //sendEmailVerification();
                                sendUserData();
                                firebaseAuth.signOut();
                                Toast.makeText(Registration.this, "Successfully Registered, Upload complete!", Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(Registration.this, MainActivity.class));
                            } else {
                                Toast.makeText(Registration.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        textView2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
              startActivity(new Intent(Registration.this,MainActivity.class));

            }
        });

    }
    private void setupUIViews(){
        editText4=(EditText)findViewById(R.id.editText4);
        editText5=(EditText)findViewById(R.id.editText5);
        editText6=(EditText)findViewById(R.id.editText6);
        editText7=(EditText)findViewById(R.id.editText7);
        editText8=(EditText)findViewById(R.id.editText8);
        editText=(EditText)findViewById(R.id.editText);
        button2=(Button)findViewById(R.id.button2);
        textView2=(TextView)findViewById(R.id.textView2);

    }
    private Boolean validate(){
        Boolean result = false;

        name = editText4.getText().toString();
        password = editText6.getText().toString();
        email = editText5.getText().toString();
        age = editText.getText().toString();
        address=editText8.getText().toString();
        phoneNo=editText7.getText().toString();


        if(name.isEmpty() || password.isEmpty() || email.isEmpty() || age.isEmpty() || address.isEmpty()|| phoneNo.isEmpty()){
            Toast.makeText(this, "Please enter all the details", Toast.LENGTH_SHORT).show();
        }else{
            result = true;
        }

        return result;


    }


    private void sendUserData(){
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
     DatabaseReference myRef = firebaseDatabase.getReference("User");
     UserProfile userProfile = new UserProfile(age, email, name,address,phoneNo);
       FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        myRef.child(firebaseUser.getUid()).setValue(userProfile);
      }

}
