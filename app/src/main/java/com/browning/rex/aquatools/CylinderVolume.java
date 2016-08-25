package com.browning.rex.aquatools;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CylinderVolume extends AppCompatActivity {

    public TextView CylinderVolume;
    private EditText CylinderHeight;
    private EditText CylinderRadius;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cylinder_volume);
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CylinderHeight = (EditText) findViewById(R.id.CylinderHeight);
        CylinderRadius = (EditText) findViewById(R.id.CylinderRadius);
        Button CylinderButton = (Button) findViewById(R.id.CylinderButton);
        CylinderVolume = (TextView) findViewById(R.id.CylinderOutput);

        CylinderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Brings up a toast if user leaves a field blank
                if (CylinderHeight.getText().toString().equals("") || CylinderRadius.getText().toString().equals(""))
                Toast.makeText(getApplicationContext(), "Please enter data", Toast.LENGTH_LONG).show();
                else
                makeCalculation();

            }
        });
    }

    private TextView makeCalculation() {
        //This gets the volume of a cylinder via the formula V=r**2*h*pi
        double cylinder_height = Double.valueOf(CylinderHeight.getText().toString());
        double cylinder_radius = Double.valueOf(CylinderRadius.getText().toString());
        double CylinderVolumeugly = (Math.PI * (cylinder_radius * cylinder_radius) * cylinder_height * 0.004329);
        double CylinderVolumeFinal = Math.round(CylinderVolumeugly * 100.0) / 100.0;
        CylinderVolume.setText("The tank can hold a maximum of " + CylinderVolumeFinal + " gallons");
        return CylinderVolume;
    }


}



