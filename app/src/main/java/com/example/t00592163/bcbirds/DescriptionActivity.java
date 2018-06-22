package com.example.t00592163.bcbirds;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DescriptionActivity extends AppCompatActivity {

    private int position = 0;
    private TextView commonText;
    private TextView scientificText;
    private TextView descriptionText;
    private ImageView bigImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        Intent intent = getIntent();
        if (intent != null)
        {
            position = intent.getExtras().getInt("position");
        }

        commonText = findViewById(R.id.commonText);
        scientificText = findViewById(R.id.scientificText);
        descriptionText = findViewById(R.id.descriptionText);
        bigImage = findViewById(R.id.imageView);


        Bird bird = MainActivity.birdArrayList.get(position);

        commonText.setText(bird.commonName);
        scientificText.setText(bird.scientficName);
        descriptionText.setText(bird.description);
        bigImage.setImageResource(bird.largeImage);
    }
}
