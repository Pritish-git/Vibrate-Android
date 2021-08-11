package com.technical.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private Button Start, Stop;
    private Vibrator vibrator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Start = findViewById(R.id.button_start);
        Stop = findViewById(R.id.button_stop);

        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (!vibrator.hasVibrator()) {
                    return;
                }

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

                    vibrator.vibrate(
                            VibrationEffect.createOneShot(1000,VibrationEffect.DEFAULT_AMPLITUDE)
                    );

                } else {
                    long[] pattern = {0, 200, 10, 500};
                    vibrator.vibrate(pattern, -1);
                }


            }
        });

        Stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vibrator.cancel();
            }
        });


    }


}