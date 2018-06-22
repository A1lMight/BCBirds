package com.example.t00592163.bcbirds;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private int count = 0;
    //private TextView Number;
    public final static String COUNT = "Bird";
    public final static  String MY_PREFERENCE_FILE ="MY_PREFERENCE_FILE";
    //SharedPreferences sharedPreferences;
    public static ArrayList<Bird> birdArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BirdAdapter birdAdapter;
        birdArrayList = new ArrayList<Bird>();
        GridView gridView = findViewById(R.id.birdGrid);

        //sharedPreferences = getApplicationContext().getSharedPreferences(MY_PREFERENCE_FILE, MODE_PRIVATE);

        /*if (sharedPreferences != null) {
            count = sharedPreferences.getInt(COUNT, 0);
            Number.setText(count + "");
        }*/

        try
        {
            JSONObject birds = new JSONObject(loadJSONFromAsset("birds"));
            JSONArray birdArray = birds.getJSONArray("birds");

            if (birdArray == null)
            {
                Log.v("potato","can not intialise ");
            }
            else
            {

                for (int i = 0; i < birdArray.length(); i++)
                {
                    JSONObject bird = birdArray.getJSONObject(i);
                    Log.v("potato", "got tree: " + bird.getString("common_name"));
                    Bird singleBird = new Bird();
                    singleBird.commonName = bird.getString("common_name");
                    singleBird.scientficName = bird.getString("scientific_name");
                    singleBird.description = bird.getString("description");


                    singleBird.largeImage = getApplicationContext().getResources()
                            .getIdentifier(bird.getString("image") + "_large",
                                    "drawable", getApplicationContext().getPackageName() );
                    singleBird.smallImage = getApplicationContext().getResources()
                            .getIdentifier(bird.getString("image") + "_small",
                                    "drawable", getApplicationContext().getPackageName() );


                    birdArrayList.add(singleBird);

                }
            }
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }

        Log.v("patato", "Size of bird array list is: " + birdArrayList.size());
        birdAdapter = new BirdAdapter(birdArrayList, getApplicationContext());

        gridView.setAdapter(birdAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {



                Toast.makeText(getApplicationContext(), "I am " + birdArrayList.get(position).scientficName, Toast.LENGTH_LONG).show();


                Intent intent = new Intent(MainActivity.this, DescriptionActivity.class);
                intent.putExtra("position", position);
                startActivity(intent);

            }
        });

    }

    /*public void BirdIncrease(View view)
    {
        count = Integer.parseInt(Number.getText().toString()) + 1;
        Number.setText(count + "");
    }*/

    public String loadJSONFromAsset(String filename)
    {
        String json = "";
        try {
            InputStream is = getAssets().open(filename + ".json");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        }
        catch (IOException ex)
        {
            ex.printStackTrace();
            return null;
        }
        return json;

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

        //SharedPreferences.Editor editor = sharedPreferences.edit();
        //editor.putInt(COUNT, count);
        //editor.apply();



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
