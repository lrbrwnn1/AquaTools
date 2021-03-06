package com.browning.rex.aquatools;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PPT extends AppCompatActivity {

    private EditText PPT;
    private EditText Gallons;
    private TextView PPT_result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ppt);
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        PPT = (EditText) findViewById(R.id.PPT);
        Gallons = (EditText) findViewById(R.id.Gallons);
        Button ppt_button = (Button) findViewById(R.id.calc);
        PPT_result = (TextView) findViewById(R.id.PPT_result);

        ppt_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Brings up a toast if user leaves a field blank
                if (PPT.getText().toString().equals("") || Gallons.getText().toString().equals(""))
                    Toast.makeText(getApplicationContext(), "Please enter data", Toast.LENGTH_LONG).show();
                else
                    makeCalculation();
            }
        });
    }

    private void makeCalculation() {
        //This takes the given ppt and multiplies it by .0001, then multiplies by Litres to get the desired measurement.
        double ppt = Double.valueOf(PPT.getText().toString());
        double gallons = Double.valueOf(Gallons.getText().toString());
        double Lit = (gallons * 3.78541);
        double result1 = (ppt * Lit);
        double result2 = (ppt * 0.008335882 * gallons);
        result1 = Math.round(result1 * 10000.0) / 10000.0;
        result2 = Math.round(result2 * 10000.0) / 10000.0;
        PPT_result.setText("The result is " + result1 + " g \n" + "The result is " + result2 + " lbs");
    }

}




