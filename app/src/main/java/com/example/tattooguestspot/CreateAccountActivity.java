package com.example.tattooguestspot;

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
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateAccountActivity extends AppCompatActivity {

    private EditText firstNameView;
    private EditText surnameView;
    private EditText emailView;
    private EditText passwordView;
    private EditText userNameView;
    private EditText confirmPassworView;
    private Button buttonCreateAccount;

    private static final String TAG = "Account information";

    DatabaseReference mFirebaseData;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        firstNameView = findViewById(R.id.create_field_first_name);
        surnameView = findViewById(R.id.create_field_surname);
        emailView = findViewById(R.id.create_field_email);
        passwordView = findViewById(R.id.create_field_password);
        confirmPassworView = findViewById(R.id.create_field_confirm_password);
        userNameView = findViewById(R.id.create_field_username);
        buttonCreateAccount = findViewById(R.id.activity_button_create_acount);

        mAuth = FirebaseAuth.getInstance();
        mFirebaseData = FirebaseDatabase.getInstance().getReference();

        // call userDao
        final User user1 = new User(userNameView.getText().toString(), firstNameView.getText().toString(), surnameView.getText().toString(), emailView.getText().toString(), passwordView.getText().toString());

        buttonCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String userName = userNameView.getText().toString();
                final String firstName = firstNameView.getText().toString();
                final String surname = surnameView.getText().toString();
                final String email = emailView.getText().toString();
                final String password = passwordView.getText().toString();
                final String confirmPassword = confirmPassworView.getText().toString();

                if(userName.isEmpty() || firstName.isEmpty() || surname.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()){
                    Toast.makeText(CreateAccountActivity.this, "Fill in all fields", Toast.LENGTH_SHORT).show();
                } else {

                   createUserAccount(email, password, userName);
                }

            }
        });
    }

    public void createUserAccount(final String email, final String password, final String name){
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    updateUserInfo(mAuth.getCurrentUser(), name);
                } else{
                    Toast.makeText(CreateAccountActivity.this, "Operation Failed", Toast.LENGTH_SHORT).show();
                }

            }

        });
    }

    public void updateUserInfo(final FirebaseUser currentUser, final String name){
        UserProfileChangeRequest profileChangeRequest = new UserProfileChangeRequest.Builder().setDisplayName(name).build();
        currentUser.updateProfile(profileChangeRequest).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    User user1 = new User(userNameView.getText().toString(), firstNameView.getText().toString(), surnameView.getText().toString(), emailView.getText().toString(), passwordView.getText().toString());

                    addNewUser(user1);
                }
            }
        });
    }

    public boolean processPassword(String password, String confirmPassword) {
        if (password.equals(confirmPassword)) {
            return true;
        }
        return false;
    }

    private void addNewUser(User createUser){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference("users").push();

        databaseReference.setValue(createUser).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(CreateAccountActivity.this, "Operation Complited", Toast.LENGTH_SHORT).show();
                updateUI();
            }
        });
    }

    private void updateUI(){
        Intent logIntent = new Intent(getApplicationContext(),LoginScreenActivity.class);
        startActivity(logIntent);
        finish();
    }
}
