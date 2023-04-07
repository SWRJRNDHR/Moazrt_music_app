package com.songs.mozartmusic;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

/**
 * Created by Swaraj on 1/13/2018.
 */

class FirstPage extends AppCompatActivity {
    public static int adCounter;
    public static final int TIME_COUNTER=2;  //Should be always greater than zero

    InterstitialAd mInterstitialAd;
    private InterstitialAd interstitial;
    private AdView mAdView;
    Button rateus,share;

//CUSTOM GRIDVIEW

    GridView androidGridView;

    String[] gridViewString = {
            "Relaxation", "Relaxation(extended)", "DEEP Healing", "Concentration", "Meditation", "Positive Energy", "Workout",
            "Happiness", "Nature", "Piano", "Flute", "Sufi", "OM Chant"

    } ;
    int[] gridViewImageId = {

            R.drawable.relaxationoffline, R.drawable.relaxationonline1,
            R.drawable.deephealing1, R.drawable.concentration1,
            R.drawable.meditation, R.drawable.positive1,
            R.drawable.workout1, R.drawable.happiness,
            R.drawable.nature, R.drawable.piano1,
            R.drawable.flute, R.drawable.sufi,
            R.drawable.om
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        adCounter++;


/*
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);




        // Prepare the Interstitial Ad
        interstitial = new InterstitialAd(FirstPage.this);
// Insert the Ad Unit ID
        interstitial.setAdUnitId(getString(R.string.admob_interstitial_id));

        interstitial.loadAd(adRequest);
// Prepare an Interstitial Ad Listener
        interstitial.setAdListener(new AdListener() {
            public void onAdLoaded() {
// Call displayInterstitial() function



                if (adCounter%TIME_COUNTER==0)
                    displayInterstitial();



            }
        });

*/

        rateus  = (Button) findViewById(R.id.rateus);
        share = (Button) findViewById(R.id.share);


        if(isNetworkStatusAvialable(this)==false){
            Toast.makeText(FirstPage.this, "Please connect to internet to access all Music!",
                    Toast.LENGTH_LONG).show();

        }



        ImageAdapter adapterViewAndroid = new ImageAdapter(FirstPage.this, gridViewString, gridViewImageId);
        androidGridView=(GridView)findViewById(R.id.grid_view_image_text);
        androidGridView.setAdapter(adapterViewAndroid);
        androidGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if(position==0){
                    Intent i = new Intent(getApplicationContext(), AllSongs.class);
                    startActivity(i);
                    finish();
                }

                if(position==1 && isNetworkStatusAvialable(FirstPage.this)){

                    Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(i);
                    finish();
                }else{

                }


                if(position==2 && isNetworkStatusAvialable(FirstPage.this)){
                    Intent i = new Intent(getApplicationContext(), FirstList.class);
                    startActivity(i);
                    finish();
                }else{

                }


                if(position==3 && isNetworkStatusAvialable(FirstPage.this)){
                    Intent i = new Intent(getApplicationContext(), SecondList.class);
                    startActivity(i);
                    finish();
                }else{

                }


                if(position==4&& isNetworkStatusAvialable(FirstPage.this)){
                    Intent i = new Intent(getApplicationContext(), FourthList.class);
                    startActivity(i);
                    finish();
                }else{

                }

                if(position==5&& isNetworkStatusAvialable(FirstPage.this)){

                    Intent i = new Intent(getApplicationContext(), FifthList.class);
                    startActivity(i);
                    finish();

                }else{

                }

                if(position==6&& isNetworkStatusAvialable(FirstPage.this)){
                    Intent i = new Intent(getApplicationContext(), SixthList.class);
                    startActivity(i);
                    finish();

                }else{

                }

                if(position==7&& isNetworkStatusAvialable(FirstPage.this)){
                    Intent i = new Intent(getApplicationContext(), SeventhList.class);
                    startActivity(i);
                    finish();

                }else{

                }

                if(position==8&& isNetworkStatusAvialable(FirstPage.this)){
                    Intent i = new Intent(getApplicationContext(), EighthList.class);
                    startActivity(i);
                    finish();

                }else{

                }

                if(position==9&& isNetworkStatusAvialable(FirstPage.this)){
                    Intent i = new Intent(getApplicationContext(), NinthList.class);
                    startActivity(i);
                    finish();

                }else{

                }

                if(position==10&& isNetworkStatusAvialable(FirstPage.this)){
                    Intent i = new Intent(getApplicationContext(), TenthList.class);
                    startActivity(i);
                    finish();

                }else{

                }

                if(position==11&& isNetworkStatusAvialable(FirstPage.this)){
                    Intent i = new Intent(getApplicationContext(), EleventhList.class);
                    startActivity(i);
                    finish();

                }else{

                }

                if(position==12&& isNetworkStatusAvialable(FirstPage.this)){
                    Intent i = new Intent(getApplicationContext(), TwelvethList.class);
                    startActivity(i);
                    finish();

                }else{

                }


            }
        });


        rateus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                launchMarket();
                finish();
            }
        });
        share.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                shareApp(getApplicationContext());
            }
        });


    }




    public static boolean isNetworkStatusAvialable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo netInfos = connectivityManager.getActiveNetworkInfo();
            if (netInfos != null)
                if (netInfos.isConnected())
                    return true;
        }
        return false;
    }




    public void shareApp(Context context)
    {
        try {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_SUBJECT, "Relaxing Music");
            String sAux = "\nTry this new application\n\n";
            sAux = sAux + "https://play.google.com/store/apps/details?id="+ getPackageName();
            i.putExtra(Intent.EXTRA_TEXT, sAux);
            startActivity(Intent.createChooser(i, "choose one"));
        } catch(Exception e) {
            //e.toString();
        }
    }



    private void launchMarket() {
        Uri uri = Uri.parse("market://details?id=" + getPackageName());
        Intent myAppLinkToMarket = new Intent(Intent.ACTION_VIEW, uri);
        try {
            startActivity(myAppLinkToMarket);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, " unable to find market app", Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onBackPressed() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(FirstPage.this);
        builder.setMessage("Are you sure want to do this ?");
        builder.setCancelable(true);
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();

            }
        });

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
                System.exit(0);

            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }


    public void displayInterstitial() {
// If Ads are loaded, show Interstitial else show nothing.
        if (interstitial.isLoaded()) {
            interstitial.show();
        }
    }


}