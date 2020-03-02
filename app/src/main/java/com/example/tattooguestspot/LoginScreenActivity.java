package com.example.tattooguestspot;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tattooguestspot.dao.UserDAO;
import com.example.tattooguestspot.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginScreenActivity extends Activity {


    private Button createAccount;
    private EditText userEmailView;
    private EditText passwordView;
    private Button loginButton;

    FirebaseAuth mAuth;
    FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        userEmailView = findViewById(R.id.activity_login_screen_login_field);
        passwordView = findViewById(R.id.activity_login_screen_password_field);

        loginButton = findViewById(R.id.activity_login_screen_login_button);

        mAuth = FirebaseAuth.getInstance();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    final String emailLog = userEmailView.getText().toString();
                final String passLog = passwordView.getText().toString();

                if(emailLog.isEmpty() || passLog.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Enter email or Password!!!", Toast.LENGTH_SHORT).show();
                } else {
                    signIn(emailLog, passLog);
                }
            }
        });

        createAccountScreen();
    }

    private void signIn (String userEmailView, String passwordView){
        mAuth.signInWithEmailAndPassword(userEmailView, passwordView).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    updateUI();
                } else{
                    Toast.makeText(getApplicationContext(), "Wrong email or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void updateUI(){
        Intent searchScreen = new Intent(this,SearchScreenActivity.class);
        startActivity(searchScreen);
        finish();
    }

    private void createAccountScreen() {
        createAccount = findViewById(R.id.activity_login_screen_create_account);

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CreateAccountActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
