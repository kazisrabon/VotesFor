package com.example.iit.dhakathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends ActionBarActivity {

    TextView tvName, tvArea;
    RatingBar ratingbar1;
    Button buttonOk;
    String name, location;
    ImageButton imageButtonMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        init();
        loadData();
    }

    private void loadData() {
        name = null;
        location = null;
        name = getIntent().getStringExtra("name");
        location = getIntent().getStringExtra("location");
        Log.e("Location", location);
        if(name != null && location != null){
            tvName.setText(name);
            tvArea.setText(location);
        }
    }

    private void init() {
        tvName = (TextView)findViewById(R.id.textViewName);
        tvArea =  (TextView)findViewById(R.id.textViewArea);
        ratingbar1=(RatingBar)findViewById(R.id.ratingBar1);
        buttonOk = (Button)findViewById(R.id.ok);
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rating=String.valueOf(ratingbar1.getRating());
                Toast.makeText(getApplicationContext(), rating, Toast.LENGTH_LONG).show();
            }
        });
        imageButtonMap = (ImageButton)findViewById(R.id.imageButtonMap);
        imageButtonMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, MapRatingActivity.class));
            }
        });
    }
}
