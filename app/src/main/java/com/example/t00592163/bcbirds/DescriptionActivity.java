package com.example.t00592163.bcbirds;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DescriptionActivity extends AppCompatActivity {

    private int count = 0;
    private TextView Number;

    public final static String COUNT = "Bird";
    public final static  String MY_PREFERENCE_FILE ="MY_PREFERENCE_FILE";

    SharedPreferences sharedPreferences;

    private int position = 0;
    private TextView commonText;
    private TextView scientificText;
    private TextView descriptionText;
    private ImageView bigImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        sharedPreferences = getApplicationContext().getSharedPreferences(MY_PREFERENCE_FILE, MODE_PRIVATE);

        Number = findViewById(R.id.Number);

        if (sharedPreferences != null) {
            count = sharedPreferences.getInt(COUNT, 0);
            Number.setText(count + "");
        }

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



    public void birdIncrease(View view)
    {
        count = Integer.parseInt(Number.getText().toString()) + 1;
        Number.setText(count + "");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Toast.makeText(getApplicationContext(), "Starting", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "Resuming", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(COUNT, count);
        editor.apply();

        Toast.makeText(getApplicationContext(), "Paused", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();

        Toast.makeText(getApplicationContext(), "Stopped", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "Destroyed", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "RESTARTED", Toast.LENGTH_SHORT).show();
    }
}
