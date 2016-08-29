package com.browning.rex.aquatools;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class UIA extends AppCompatActivity {

    private EditText Temp;
    private EditText pH;
    private EditText NH3;
    private TextView UIA_Result;
    private TextView Salinity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uia);
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Temp = (EditText) findViewById(R.id.UIA_Temperature);
        pH = (EditText) findViewById(R.id.UIA_pH);
        NH3 = (EditText) findViewById(R.id.UIA_NH3);
        Salinity = (EditText) findViewById(R.id.UIA_Salinity);
        Button UIA_Button = (Button) findViewById(R.id.UIA_Button);
        UIA_Result = (TextView) findViewById(R.id.UIA_Result);

        UIA_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Brings up a toast if user leaves a field blank
                if (pH.getText().toString().equals("") || Temp.getText().toString().equals("") || NH3.getText().toString().equals(""))
                    Toast.makeText(getApplicationContext(), "Please enter data", Toast.LENGTH_LONG).show();
                else
                    makeCalculation();
            }
        });


    }

    private void makeCalculation() {
        double Fahrenheit = Double.valueOf(Temp.getText().toString());
        double N = Double.valueOf(NH3.getText().toString());
        double Kelvin = (Fahrenheit + 459.67)/1.8;
        double ph = Double.valueOf(pH.getText().toString());
        double salinity = Double.valueOf(Salinity.getText().toString());
        double I = ((19.9273 * salinity) / (1000 - (1.005109 * salinity)));
        double pka = (9.245 + (.116 * I));
        double conversion = (pka + 0.0324 * (298 - Kelvin) + (.0415 / Kelvin) - ph);
        double equation = ((1 / (1 + (Math.pow(10, conversion)))) * N);
        double UIA_Answer = Math.round(equation*100000000.0)/100000000.0;
        String result = String.format("%.8f", UIA_Answer);
        UIA_Result.setText(String.format("%s%s%s", getString(R.string.uia_answer), result, getString(R.string.uia_answer2)));
    }
}
