package com.gts.aarongoodman.mtgrandomeffects;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import com.google.api.client.googleapis.extensions.android.gms.auth.GooglePlayServicesAvailabilityIOException;
import com.google.api.client.googleapis.extensions.android.gms.auth.UserRecoverableAuthIOException;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.ExponentialBackOff;

import com.google.api.services.sheets.v4.SheetsScopes;

import com.google.api.services.sheets.v4.model.*;

import android.Manifest;
import android.accounts.AccountManager;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;




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
public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
    Random rand = new Random();






    public static final String TAG = MainActivity.class.getSimpleName();
    TextView EffectTextView;
    String debugKeystore = "BD:7A:93:39:83:B1:EB:32:B4:B7:94:92:9B:A3:C1:0E:AF:3C:05:33";
//    public Effect DemoEffect0 = new Effect(0,"Demo Effect 0","All creatures gain tap target " +
//            "summon 1/1 token fart with flying");
//    public Effect DemoEffect1 = new Effect(0,"Zentai Hero Team","All creatures are now equipment" +
//            "Equip: tap x, where x is the number of creatues being equipped and the color of the" +
//            "equipped creature with: +/+ equal to their attack/defense " );
//    public EffectList efl = new EffectList();


    //trying to parse the csv and turn it into objects.
//    public static String[] parseCsv(String fileName) throws java.io.IOException{
//        CSVReader reader = new CSVReader(new FileReader(fileName + ".csv"));
//        List<String[]> myEntries = reader.readAll();
//        System.out.println(myEntries.toString());
//        return myEntries.get(0);
//    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EffectTextView = (TextView) findViewById(R.id.effectTextView);

        Button ShowEffectButton = (Button) findViewById(R.id.showEffectButton);
        ShowEffectButton.setOnClickListener(this);

        Button DataRefreshButton = (Button) findViewById(R.id.dataRefreshButton);
        DataRefreshButton.setOnClickListener(this);

        Button WeightedRandomButton = (Button) findViewById(R.id.weightedRandomButton);
        WeightedRandomButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v)  {

        switch(v.getId()) {

            case R.id.showEffectButton:
                int randomEffectNumber = rand.nextInt(349-1)+1;
                String currentEffectText = "" + randomEffectNumber;
                EffectTextView.setText(currentEffectText);
                Toast.makeText(getApplicationContext(), "Effect Button Works",
                        Toast.LENGTH_SHORT).show();
                break;

            case R.id.dataRefreshButton:
                //try {
                    Toast.makeText(getApplicationContext(), "Refresh Button Works"
                            //+parseCsv("chaos_list"),
                            ,Toast.LENGTH_SHORT).show();
//                }catch(java.io.IOException IOE){
//                    System.out.println("IOException on refresh button");
//
//                }


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
                }
                else if(randomFirst <= 18 && randomFirst >= 13){
                    randomSecond = rand.nextInt(305-130)+130;
                    Toast.makeText(getApplicationContext(), "" + randomSecond,
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    randomSecond = rand.nextInt(400-307)+307;
                    Toast.makeText(getApplicationContext(), "" + randomSecond,
                            Toast.LENGTH_SHORT).show();
                }


                break;

            default:
                break;

        }

    }
}
