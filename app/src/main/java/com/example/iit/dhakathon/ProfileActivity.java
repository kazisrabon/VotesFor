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

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends ActionBarActivity {

    TextView tvName, tvArea;
    RatingBar ratingbar1;
    Button buttonOk;
    String name, location;
    ImageButton imageButtonMap;
    CircleImageView imageView;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        init();
        loadData();
    }

    private void loadData() {
        name = null;
        location = "";
        name = getIntent().getStringExtra("name");
        location = getIntent().getStringExtra("location");
        url = getIntent().getStringExtra("url");
        Log.e("Location", location);
        Toast.makeText(ProfileActivity.this, "Location " + location, Toast.LENGTH_SHORT).show();


        tvName.setText(name);
        tvArea.setText(location);
        Log.e("XXXXXXXXXXXXXXXXXXXXXX", "URL " + url);
        Picasso.with(this).load("http://citycorpelections.org/images/candidate_image/"+url).into(imageView);

    }

    private void init() {
        tvName = (TextView) findViewById(R.id.textViewName);
        tvArea = (TextView) findViewById(R.id.textViewArea);
        ratingbar1 = (RatingBar) findViewById(R.id.ratingBar1);
        buttonOk = (Button) findViewById(R.id.ok);
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rating = String.valueOf(ratingbar1.getRating());
                Toast.makeText(getApplicationContext(), rating, Toast.LENGTH_LONG).show();
            }
        });
        imageView= (CircleImageView) findViewById(R.id.circleView);
        imageButtonMap = (ImageButton) findViewById(R.id.imageButtonMap);
        imageButtonMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, MapRatingActivity.class));
            }
        });
        Log.e("XXXXXXXXXXXXXXXXXXXXXX", "URL " + url);


    }
}
