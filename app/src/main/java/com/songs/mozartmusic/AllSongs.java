package com.songs.mozartmusic;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;


public class AllSongs extends AppCompatActivity {
    Button play, pause, star;
    MediaPlayer offline = new MediaPlayer();

    boolean isPaused;
    int length;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);



        pause = (Button) findViewById(R.id.pause);
        play = (Button) findViewById(R.id.play);



        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);




        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   /* if (isPaused = true || mp.isPlaying()) {
                        mp.seekTo(length);
                        mp.start();
                    }

                    else {
*/                  play.setVisibility(View.GONE);
                for (int i = 0; i < 3; i++) {
                    Toast.makeText(getApplicationContext(), "Loading..", Toast.LENGTH_LONG).show();
                }

                offline.reset();
                try {
                    offline = MediaPlayer.create(AllSongs.this, R.raw.offlinesong);

                    offline.setLooping(true);
                    offline.start();


                } catch (Exception e) {
                    e.printStackTrace();
                }
                // }
            }
        });





        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (offline.isPlaying()) {

                    pause.setBackgroundResource(R.drawable.play6);

                    offline.pause();
                    length = offline.getCurrentPosition();
                    isPaused = true;
                } else {

                    pause.setBackgroundResource(R.drawable.pause8);


                    offline.seekTo(length);
                    offline.start();

                }
            }
        });





 /*
        //For Seekbar
        handler = new Handler();
        seekBar = (SeekBar) findViewById(R.id.seekbar);

      offline.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBar.setMax(offline.getDuration());

                playCycle();


            }
        });



        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean input) {

                if (input) {
                    offline.seekTo(progress);

                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
*/



   /*     play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPaused = true) {
                    mp.seekTo(length);
                    mp.start();
                } else {


                    mp.reset();
                    try {
                        mp.prepare();

                        mp.start();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.pause();
                length = mp.getCurrentPosition();
                isPaused = true;
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seekBar.setProgress(0);
                mp.pause();
            }
        });




*/

    }



    @Override
    protected void onPause() {
        super.onPause();

        if(offline != null)
            offline.stop();
    }

    @Override
    protected void onStop() {
        super.onStop();

        if(offline != null)
            offline.stop();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(offline != null)
            offline.stop();

    }


    @Override
    public void onBackPressed() {
     //   offline.stop();
      //  offline.release();


        Intent i = new Intent(getApplicationContext(), FirstPage.class);
        //i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        startActivity(i);
        finish();
        super.onBackPressed();

    }

}




