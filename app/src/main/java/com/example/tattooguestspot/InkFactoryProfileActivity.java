package com.example.tattooguestspot;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class InkFactoryProfileActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton intagramBtn;
    private ImageButton facebookBtn;
    private ImageButton websiteBtn;
    private Button bookBtn;
    private ImageButton mapsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ink_factory_profile);

        intagramBtn = findViewById(R.id.inkFactory_instagramBtn);
        facebookBtn = findViewById(R.id.inkFactory_facebookBtn);
        websiteBtn = findViewById(R.id.inkFactory_websitebtn);
        mapsBtn = findViewById(R.id.inkFactory_imageMapBtn);
        bookBtn = findViewById(R.id.inkFactory_bookBtn);

        intagramBtn.setOnClickListener(this);
        facebookBtn.setOnClickListener(this);
        websiteBtn.setOnClickListener(this);
        mapsBtn.setOnClickListener(this);
        bookBtn. setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.inkFactory_instagramBtn:
                Intent instagramInkIntent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.instagram.com/theinkfactory/?hl=en"));
                startActivity(instagramInkIntent);
                break;

            case R.id.inkFactory_facebookBtn:
                Intent facebookInkIntent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.facebook.com/theinkfactoryireland/"));
                startActivity(facebookInkIntent);
                break;

            case R.id.inkFactory_websitebtn:
                Intent websiteInkIntent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.theinkfactory.ie/"));
                startActivity(websiteInkIntent);
                break;

            case R.id.inkFactory_imageMapBtn:
                Intent mapIntent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.google.com/maps/place/Apartment+1,+Wellington+Hall,+15+Wellington+Quay,+Temple+Bar,+Dublin+2,+D02+DE42/@53.3454382,-6.2681441,17z/data=!3m1!4b1!4m5!3m4!1s0x48670e82cc466b61:0x6ae0e17dedb9df9a!8m2!3d53.345435!4d-6.2659554"));
                startActivity(mapIntent);
                break;

            case R.id.inkFactory_bookBtn:
                Intent bookBtnIntent = new Intent(
                        this,InkFactoryPaymentActivity.class);
                startActivity(bookBtnIntent);
                break;
        }

    }
}
