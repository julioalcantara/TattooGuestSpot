package com.example.tattooguestspot;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.tattooguestspot.dao.UserDAO;
import com.example.tattooguestspot.model.User;

public class SearchScreenActivity extends AppCompatActivity {

    private Button searchBtn;
    private Button profileBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchBtn = findViewById(R.id.search_screen_button);
        profileBtn = findViewById(R.id.search_screen_profile_btn);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListOfStudios();
            }
        });

        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openArtistProfile();
            }
        });
    }

    public void openListOfStudios(){
        Intent intent = new Intent(this, ListOfStudiosActivity.class);
        startActivity(intent);
    }

    public void openArtistProfile(){
        Intent profileIntent = new Intent(this, ArtistProfileActivity.class);
        startActivity(profileIntent);
    }
}
