package com.browning.rex.aquatools;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RectangleVolume extends AppCompatActivity {

    public TextView RectangleVolume;
    private EditText RectangleHeight;
    private EditText RectangleLength;
    private EditText RectangleWidth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangle_volume);
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RectangleHeight = (EditText) findViewById(R.id.RectangleHeight);
        RectangleLength = (EditText) findViewById(R.id.RectangleLength);
        RectangleWidth = (EditText) findViewById(R.id.RectangleWidth);
        Button RectangleButton = (Button) findViewById(R.id.RectangleButton);
        RectangleVolume = (TextView) findViewById(R.id.RectangleOutput);

        RectangleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeCalculation();

            }
        });
    }

    public TextView makeCalculation() {
        //This gets the volume of a cuboid via the formula V=W*L*H
        double rectangle_height = Double.valueOf(RectangleHeight.getText().toString());
        double rectangle_length = Double.valueOf(RectangleLength.getText().toString());
        double rectangle_width = Double.valueOf(RectangleWidth.getText().toString());
        double RectangleVolumeFinal = Math.round(Math.PI * ((rectangle_width * rectangle_height * rectangle_length) * 0.004329) * 100.0 / 100.0);
        RectangleVolume.setText("The tank can hold a maximum of " + RectangleVolumeFinal + " gallons");
        return RectangleVolume;
    }


}
