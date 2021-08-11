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
                    return; //Check if device has vibrator hardware or not, if not then return from this method
                            //don't execute futher code below
                }

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    
                    //if API = 26(Oreo) or higher
                    vibrator.vibrate(
                            VibrationEffect.createOneShot(1000,VibrationEffect.DEFAULT_AMPLITUDE)
                    );

                } else {
                    //vibrate for 1 second
                     vibrator.vibrate(1000);
                    
                    //Vibration Pattern - you can create yours
                    long[] pattern = {0, 200, 10, 500};
                    vibrator.vibrate(pattern, -1);
                }


            }
        });

        Stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                //To stop the vibartion
                vibrator.cancel();
            }
        });


    }


}
