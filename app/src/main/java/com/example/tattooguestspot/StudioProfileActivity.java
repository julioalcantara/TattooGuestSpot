package com.example.tattooguestspot;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class StudioProfileActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton intagramBtn;
    private ImageButton facebookBtn;
    private ImageButton websiteBtn;
    private Button bookBtn;
    private ImageButton mapsBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studio_profile);

        intagramBtn = findViewById(R.id.studio_profile_instagram);
        facebookBtn = findViewById(R.id.studio_profile_facebook);
        websiteBtn = findViewById(R.id.studio_profile_website);
        mapsBtn = findViewById(R.id.list_studios_imageButton);
        bookBtn = findViewById(R.id.studio_profile_book);

        intagramBtn.setOnClickListener(this);
        facebookBtn.setOnClickListener(this);
        websiteBtn.setOnClickListener(this);
        mapsBtn.setOnClickListener(this);
        bookBtn. setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.studio_profile_instagram:
                Intent instagramInkIntent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.instagram.com/dublinink/?hl=en"));
                startActivity(instagramInkIntent);
                break;

            case R.id.studio_profile_facebook:
                Intent facebookInkIntent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.facebook.com/dublininktattoo/"));
                startActivity(facebookInkIntent);
                break;

            case R.id.studio_profile_website:
                Intent websiteInkIntent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("http://dublininktattoo.com/?gclid=CjwKCAjwk7rmBRAaEiwAhDGhxKg-bNQnHE1g4YQ13ZJZ7_YHybaXFmKYQU2KO36SU6VAoytGNIMtJRoCY1YQAvD_BwE"));
                startActivity(websiteInkIntent);
                break;

            case R.id.list_studios_imageButton:
                Intent mapIntent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.google.com/maps/place/Dublin+Ink/@53.3443615,-6.2708861,17z/data=!3m1!4b1!4m5!3m4!1s0x48670c27f1a279c3:0xfd26d772171abf6!8m2!3d53.3443583!4d-6.2686974"));
                startActivity(mapIntent);
                break;

            case R.id.studio_profile_book:
                Intent bookBtnIntent = new Intent(
                        this,paymentActivity.class);
                startActivity(bookBtnIntent);
                break;
        }

    }
}
