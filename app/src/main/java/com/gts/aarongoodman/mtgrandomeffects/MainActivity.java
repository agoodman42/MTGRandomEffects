package com.gts.aarongoodman.mtgrandomeffects;


import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import android.support.annotation.RequiresApi;
import android.view.View;

import android.widget.Button;
import android.widget.TextView;

import android.support.v7.app.AppCompatActivity;

import android.widget.Toast;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;




import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Random rand = new Random();

    TextView randomEffectTextView;
    TextView EffectTextView;
    TextView EffectTitleTextView;
    ArrayList<Effect> effectList;
    String jsonString;
    Gson gson;
    Effect currentEffect;
    String effectText;
    ArrayList<Effect> jsonList;





    public String loadJSONFromAsset() {
        String json;
        try {

            InputStream is = getAssets().open("chaos_for_the_app.json");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
            Toast.makeText(getApplicationContext(), "file not found, reader is not working",
                    Toast.LENGTH_SHORT).show();

            return null;
        }
        return json;

    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gson = new Gson();


        EffectTextView = (TextView) findViewById(R.id.EffectTextView);

        EffectTitleTextView = (TextView) findViewById(R.id.TitleTextView);

        Button showEffectButton = (Button) findViewById(R.id.showEffectButton);
        showEffectButton.setOnClickListener(this);

        Button DataRefreshButton = (Button) findViewById(R.id.dataRefreshButton);
        DataRefreshButton.setOnClickListener(this);

        Button WeightedRandomButton = (Button) findViewById(R.id.weightedRandomButton);
        WeightedRandomButton.setOnClickListener(this);

        jsonString = loadJSONFromAsset();

//        Effect testEffect = gson.fromJson(jsonString, Effect.class);

        Type type = new TypeToken<ArrayList<Effect>>() {}.getType();
       // jsonList = gson.fromJson(jsonString, type);
//
        effectList = jsonList;
//        currentEffect = jsonList.get(0);
//        effectText  = currentEffect.getDescription();













    }

    @Override
    public void onClick(View v)  {
        String currentEffectText;
        String currentEffectTitle;
        switch(v.getId()) {

            case R.id.showEffectButton:
                int randomEffectNumber = rand.nextInt(349-1)+1;
                currentEffect = jsonList.get(randomEffectNumber);
                currentEffectText = currentEffect.getDescription();
                currentEffectTitle = currentEffect.getDisplayNum() + " "
                        + currentEffect.getName();
                EffectTextView.setText(currentEffectText);
                EffectTitleTextView.setTextColor(Color.WHITE);
                EffectTitleTextView.setText(currentEffectTitle);

               // weightedEffectTextView.setText(effectList.get(0).FIELD3);




                break;

            case R.id.dataRefreshButton:
                Toast.makeText(getApplicationContext(),effectText ,
                        Toast.LENGTH_SHORT).show();

                break;

            case R.id.weightedRandomButton:

                int randomFirst = rand.nextInt(20)+1;
                int randomSecond;

                //rand.nextInt((max - min) + 1) + min;
                //we'll eventually want to create sliders or fields to fill that
                //allow the user to pick the min/max for the different weightings
                if (randomFirst <= 12){
                    randomSecond = rand.nextInt(128)+1;

                    currentEffect = jsonList.get(randomSecond);
                    currentEffectText = currentEffect.getDescription();
                    currentEffectTitle = currentEffect.getDisplayNum()
                            + " "+ currentEffect.getName();
                    EffectTextView.setText(currentEffectText);
                    EffectTitleTextView.setTextColor(Color.parseColor("#0070dd"));
                    EffectTitleTextView.setText(currentEffectTitle);


                }
                else if(randomFirst <= 18 && randomFirst >= 13){
                    randomSecond = rand.nextInt(305-130)+130;

                    currentEffect = jsonList.get(randomSecond);
                    currentEffectText = currentEffect.getDescription();
                    currentEffectTitle = currentEffect.getDisplayNum()
                            + " "+ currentEffect.getName();
                    EffectTextView.setText(currentEffectText);
                    EffectTitleTextView.setTextColor(Color.parseColor("#a335ee"));
                    EffectTitleTextView.setText(currentEffectTitle);

                }
                else {
                    randomSecond = rand.nextInt(400-307)+307;

                    currentEffect = jsonList.get(randomSecond);
                    currentEffectText = currentEffect.getDescription();
                    currentEffectTitle = currentEffect.getDisplayNum()
                            + " "+ currentEffect.getName();
                    EffectTextView.setText(currentEffectText);
                    EffectTitleTextView.setTextColor(Color.parseColor("#ff8000"));
                    EffectTitleTextView.setText(currentEffectTitle);

                }


                break;

            default:
                break;

        }

    }
}
