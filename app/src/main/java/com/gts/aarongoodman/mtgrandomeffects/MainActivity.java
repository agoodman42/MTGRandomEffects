package com.gts.aarongoodman.mtgrandomeffects;


import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;

import android.view.View;

import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import android.support.v7.app.AppCompatActivity;

import android.widget.Toast;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Random;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Random rand = new Random();

    TextView randomEffectTextView;
    TextView EffectTextView;
    TextView EffectTitleTextView;
    String jsonString;
    Gson gson;
    Effect currentEffect;
    String effectText;
    ArrayList<Effect> TAB;







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


        EffectTextView = (TextView) findViewById(R.id.effectTextView);

        EffectTitleTextView = (TextView) findViewById(R.id.TitleTextView);

        Button showEffectButton = (Button) findViewById(R.id.randomEffectButton);
        showEffectButton.setOnClickListener(this);

        ImageButton aboutButton = (ImageButton) findViewById(R.id.aboutButton);
        aboutButton.setOnClickListener(this);

        Button WeightedRandomButton = (Button) findViewById(R.id.weightedRandomButton);
        WeightedRandomButton.setOnClickListener(this);

        jsonString = loadJSONFromAsset();

        Type effectListType = new TypeToken<ArrayList<Effect>>(){}.getType();
        TAB = gson.fromJson(jsonString, effectListType);
    }

    @Override
    public void onClick(View v)  {
        String currentEffectText;
        String currentEffectTitle;
        switch(v.getId()) {

            case R.id.randomEffectButton:
                int randomEffectNumber = rand.nextInt(199-1)+1;
                currentEffect = TAB.get(randomEffectNumber);
                currentEffectText = currentEffect.getEffect();
                currentEffectTitle = currentEffect.getNumber() + " "
                        + currentEffect.getName();
                EffectTextView.setText(currentEffectText);
                EffectTitleTextView.setTextColor(Color.WHITE);
                EffectTitleTextView.setText(currentEffectTitle);

               // weightedEffectTextView.setText(effectList.get(0).FIELD3);


                break;

            case R.id.aboutButton:
                Toast.makeText(getApplicationContext(),"Hi I'm Aaron, I made this thing" ,
                        Toast.LENGTH_SHORT).show();

                break;

            case R.id.weightedRandomButton:

                int randomFirst = rand.nextInt(20)+1;
                int randomSecond;

                //rand.nextInt((max - min) + 1) + min;
                //we'll eventually want to create sliders or fields to fill that
                //allow the user to pick the min/max for the different weightings
                if (randomFirst <= 12){
                    randomSecond = rand.nextInt(50)+1;

                    currentEffect = TAB.get(randomSecond);
                    currentEffectText = currentEffect.getEffect();
                    currentEffectTitle = currentEffect.getNumber()
                            + " "+ currentEffect.getName();
                    EffectTextView.setText(currentEffectText);
                    EffectTitleTextView.setTextColor(Color.parseColor("#0070dd"));
                    EffectTitleTextView.setText(currentEffectTitle);


                }
                else if(randomFirst <= 18 && randomFirst >= 13){
                    randomSecond = rand.nextInt(125-50)+50;

                    currentEffect = TAB.get(randomSecond);
                    currentEffectText = currentEffect.getEffect();
                    currentEffectTitle = currentEffect.getNumber()
                            + " "+ currentEffect.getName();
                    EffectTextView.setText(currentEffectText);
                    EffectTitleTextView.setTextColor(Color.parseColor("#a335ee"));
                    EffectTitleTextView.setText(currentEffectTitle);

                }
                else {
                    randomSecond = rand.nextInt(200-125)+125;

                    currentEffect = TAB.get(randomSecond);
                    currentEffectText = currentEffect.getEffect();
                    currentEffectTitle = currentEffect.getNumber()
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
