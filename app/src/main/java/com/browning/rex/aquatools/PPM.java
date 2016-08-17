package com.browning.rex.aquatools;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PPM extends AppCompatActivity {

    private EditText PPM;
    private EditText Gallons;
    private TextView PPM_result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ppm);
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        PPM = (EditText) findViewById(R.id.PPM);
        Gallons = (EditText) findViewById(R.id.Gallons);
        Button ppm_button = (Button) findViewById(R.id.ppmcalc);
        PPM_result = (TextView) findViewById(R.id.PPM_result);
        ppm_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeCalculation();
            }
        });
    }


    @TargetApi(Build.VERSION_CODES.N)
    private void makeCalculation() {
        //This takes the given ppm and multiplies it by .0001, then multiplies by Litres to get the desired measurement.
        double ppm = Double.valueOf(PPM.getText().toString());
        double gallons = Double.valueOf(Gallons.getText().toString());
        double Lit = (gallons * 3.78541);
        double result1 = ((ppm * 0.001) * Lit);
        double result2 = (ppm * 0.000008335882 * gallons);
        result1 = Math.round(result1 * 1000.0) / 10000.0;
        result2 = Math.round(result2 * 10000.0) / 10000.0;
        PPM_result.setText("The result is " + result1 + " ml or g \n" + "The result is " + result2 + " lbs");

    }


}

