package com.browning.rex.aquatools;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public Button button1;
    public Button button2;
    public Button button3;
    public Button button4;

    public void ppt_init() {
        button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent PPT_Calc = new Intent(MainActivity.this, PPT.class);
                startActivity(PPT_Calc);
            }
        });


    }

    public void ppm_init() {
        button2 = (Button) findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent PPM_Calc = new Intent(MainActivity.this, PPM.class);
                startActivity(PPM_Calc);
            }
        });


    }

    public void cylinder_init() {
        button3 = (Button) findViewById(R.id.button3);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent cylVol = new Intent(MainActivity.this, CylinderVolume.class);
                startActivity(cylVol);
            }
        });
    }

    public void rectangle_init() {
        button4 = (Button) findViewById(R.id.button4);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent recVol = new Intent(MainActivity.this, RectangleVolume.class);
                startActivity(recVol);
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolBar();
        ppt_init();
        ppm_init();
        rectangle_init();
        cylinder_init();

    }


    private void setToolBar() {
        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        ActionBar ab = getSupportActionBar();


    }

    @Override
    public void onClick(View view) {
    }
}
