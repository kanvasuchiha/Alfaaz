package com.smartherd.sur;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.mikhaellopez.circularimageview.CircularImageView;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    private Button btplay, btpause, btstop;
    private MediaPlayer mediaPlayer;
    private ImageView progress;
    private ImageView cardView;



    int pauseCurretPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btplay = findViewById(R.id.play);
        btpause = findViewById(R.id.pause);
        btstop = findViewById(R.id.stop);
        cardView = findViewById(R.id.elevate);
        progress = findViewById(R.id.background);
        if (progress != null) {
            progress.setVisibility(View.VISIBLE);
            AnimationDrawable frameAnimation = (AnimationDrawable) progress.getDrawable();
            frameAnimation.setEnterFadeDuration(1000);
            frameAnimation.setExitFadeDuration(1000);
            frameAnimation.start();
        }


        btpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer != null) {
                    mediaPlayer.pause();
                    pauseCurretPosition = mediaPlayer.getCurrentPosition();
                }
            }
        });

        btplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer == null) {
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.dil);
                    mediaPlayer.start();
                    if (cardView != null) {
                        cardView.setVisibility(View.VISIBLE);
                        AnimationDrawable frameAnimation = (AnimationDrawable) cardView.getDrawable();
                        frameAnimation.setEnterFadeDuration(100);
                        frameAnimation.setExitFadeDuration(100);
                        frameAnimation.start();
                    }
                } else if (!mediaPlayer.isPlaying()) {
                    mediaPlayer.seekTo(pauseCurretPosition);
                    mediaPlayer.start();
                }


            }
        });


        btstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer = null;
                }
            }
        });

        }
    }