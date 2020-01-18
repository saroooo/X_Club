package com.example.dalia.x_club;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UpdatePassword extends AppCompatActivity {
private EditText editText22;
private Button button13;
    private FirebaseUser firebaseUser;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_password);
        editText22=findViewById(R.id.editText22);
        button13=findViewById(R.id.button13);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pass=editText22.getText().toString();

        firebaseUser.updatePassword(pass).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(UpdatePassword.this,"Password Changed",Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    Toast.makeText(UpdatePassword.this,"Password Update Failed",Toast.LENGTH_SHORT).show();
                }
            }
        });
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
