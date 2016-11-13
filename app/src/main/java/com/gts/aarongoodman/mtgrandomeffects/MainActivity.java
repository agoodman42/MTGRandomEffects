package com.gts.aarongoodman.mtgrandomeffects;


import android.os.Build;
import android.os.Bundle;

import android.support.annotation.RequiresApi;
import android.view.View;

import android.widget.Button;
import android.widget.TextView;

import android.support.v7.app.AppCompatActivity;

import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Random rand = new Random();
    String jsonString = "/Users/aarongoodman/AndroidStudioProjects/MTGRandomEffects" +
            "/app/src/main/assets/chaos_list.json";
    TextView randomEffectTextView;
    TextView EffectTextView;
    List<Effect> effectList;




    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Type listType = new TypeToken<List<Effect>>() {}.getType();
        List<Effect> target = new LinkedList<Effect>();



        EffectTextView = (TextView) findViewById(R.id.EffectTextView);

        Button showEffectButton = (Button) findViewById(R.id.showEffectButton);
        showEffectButton.setOnClickListener(this);

        Button DataRefreshButton = (Button) findViewById(R.id.dataRefreshButton);
        DataRefreshButton.setOnClickListener(this);

        Button WeightedRandomButton = (Button) findViewById(R.id.weightedRandomButton);
        WeightedRandomButton.setOnClickListener(this);


        Gson gson = new Gson();

        try (Reader reader = new FileReader("/Users/aarongoodman/AndroidStudioProjects/" +
                "MTGRandomEffects/app/src/main/assets/chaos_list.json")) {

            // Convert JSON to Java Object
            Effect effectList = gson.fromJson(reader, Effect.class);
            System.out.println(effectList);

            // Convert JSON to JsonElement, and later to String
            /*JsonElement json = gson.fromJson(reader, JsonElement.class);
            String jsonInString = gson.toJson(json);
            System.out.println(jsonInString);*/

        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "404 file not found",
                    Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onClick(View v)  {
        String currentEffectText;
        switch(v.getId()) {

            case R.id.showEffectButton:
                int randomEffectNumber = rand.nextInt(349-1)+1;
                currentEffectText = "" + randomEffectNumber;
                //weightedEffectTextView.setText(currentEffectText);
               // weightedEffectTextView.setText(effectList.get(0).FIELD3);




                Toast.makeText(getApplicationContext(), "Effect Button Works",
                        Toast.LENGTH_SHORT).show();
                break;

            case R.id.dataRefreshButton:
                Toast.makeText(getApplicationContext(), "Refresh Button Works",
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
                    Toast.makeText(getApplicationContext(), "" + randomSecond,
                            Toast.LENGTH_SHORT).show();
                    currentEffectText = "" + randomSecond;
                    EffectTextView.setText(currentEffectText);
                }
                else if(randomFirst <= 18 && randomFirst >= 13){
                    randomSecond = rand.nextInt(305-130)+130;
                    Toast.makeText(getApplicationContext(), "" + randomSecond,
                            Toast.LENGTH_SHORT).show();
                    currentEffectText = "" + randomSecond;
                    EffectTextView.setText(currentEffectText);
                }
                else {
                    randomSecond = rand.nextInt(400-307)+307;
                    Toast.makeText(getApplicationContext(), "" + randomSecond,
                            Toast.LENGTH_SHORT).show();
                    currentEffectText = "" + randomSecond;
                    EffectTextView.setText(currentEffectText);
                }


                break;

            default:
                break;

        }

    }
}
