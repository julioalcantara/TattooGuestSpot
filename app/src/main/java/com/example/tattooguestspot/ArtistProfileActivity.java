package com.example.tattooguestspot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ArtistProfileActivity extends AppCompatActivity {

    private Button goBackBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_profile);

        goBackBtn = findViewById(R.id.artist_profile_back_btn);

        goBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToSearchScreen();
            }
        });
    }

    public void backToSearchScreen(){
        Intent intent = new Intent(this, SearchScreenActivity.class);
        startActivity(intent);
    }
}
