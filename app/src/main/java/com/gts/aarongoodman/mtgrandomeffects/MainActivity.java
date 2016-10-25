package com.gts.aarongoodman.mtgrandomeffects;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.Random;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    public static final String TAG = MainActivity.class.getSimpleName();
    TextView EffectTextView;
//    public Effect DemoEffect0 = new Effect(0,"Demo Effect 0","All creatures gain tap target " +
//            "summon 1/1 token fart with flying");
//    public Effect DemoEffect1 = new Effect(0,"Zentai Hero Team","All creatures are now equipment" +
//            "Equip: tap x, where x is the number of creatues being equipped and the color of the" +
//            "equipped creature with: +/+ equal to their attack/defense " );
//    public EffectList efl = new EffectList();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EffectTextView = (TextView) findViewById(R.id.effectTextView);

        Button ShowEffectButton = (Button) findViewById(R.id.showEffectButton);
        ShowEffectButton.setOnClickListener(this);

        Button DataRefreshButton = (Button) findViewById(R.id.dataRefreshButton);
        DataRefreshButton.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {

        switch(v.getId()) {

            case R.id.showEffectButton:
                EffectList efl = new EffectList();
                String currentEffectText =  efl.getEffect(0).getText();
                EffectTextView.setText(currentEffectText);
                Toast.makeText(getApplicationContext(), "Effect Button Works",
                        Toast.LENGTH_SHORT).show();
                break;

            case R.id.dataRefreshButton:
                Toast.makeText(getApplicationContext(), "Refresh Button Works",
                        Toast.LENGTH_SHORT).show();
                break;
            default:
                break;

        }

    }
}
