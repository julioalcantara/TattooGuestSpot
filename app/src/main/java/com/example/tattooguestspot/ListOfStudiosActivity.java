package com.example.tattooguestspot;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ListOfStudiosActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton dublininkBtn;
    private ImageButton inkfactoryBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_studios);

        dublininkBtn = findViewById(R.id.list_studios_imageButton);
        inkfactoryBtn = findViewById(R.id.list_studios_imageButton2);

        dublininkBtn.setOnClickListener(this);
        inkfactoryBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.list_studios_imageButton:
                Intent dublinIknIntent = new Intent(this, StudioProfileActivity.class);
                startActivity(dublinIknIntent);
                break;

            case R.id.list_studios_imageButton2:
                 Intent inkFactoryIntent = new Intent(this, InkFactoryProfileActivity.class);
                 startActivity(inkFactoryIntent);
                 break;
        }
    }

}
