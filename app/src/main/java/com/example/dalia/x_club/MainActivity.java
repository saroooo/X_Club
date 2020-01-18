 package com.example.dalia.x_club;


import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private EditText Name;
    private EditText Password;
    private Button Login;
    private TextView userRegistration;
    private RadioButton rdButton1;
    private RadioButton rdButton2;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    private TextView forgotPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name = (EditText)findViewById(R.id.editText11);
        Password = (EditText)findViewById(R.id.editText12);
        Login = (Button)findViewById(R.id.button3);
        userRegistration = (TextView)findViewById(R.id.textView3);
        forgotPassword = (TextView)findViewById(R.id.textView9);
        rdButton1=(RadioButton)findViewById(R.id.radioButton);
        rdButton2=(RadioButton)findViewById(R.id.radioButton2);


        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        FirebaseUser user = firebaseAuth.getCurrentUser();

        if(user != null  ){

            if(rdButton1.isChecked()) {
                finish();
                startActivity(new Intent(MainActivity.this,UserSecondActivity.class));
            }else if(rdButton2.isChecked()){
                finish();
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        }





        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });
        userRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Reg.class));
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PasswordActivity.class));
            }

        });
    }
    private void validate(String userName, String userPassword) {

        progressDialog.setMessage("Loading,Please Wait!");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(userName, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    progressDialog.dismiss();
                    if(rdButton1.isChecked()) {
                        finish();
                        startActivity(new Intent(MainActivity.this,UserSecondActivity.class));
                    }else if(rdButton2.isChecked()){
                        finish();
                        startActivity(new Intent(MainActivity.this, SecondActivity.class));
                    }

                } else {
                    Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();


                }
            }
        });
    }
}
