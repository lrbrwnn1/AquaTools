package com.browning.rex.aquatools;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public Button button1;
    public Button button2;
    public Button button3;

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

    public void vol_init() {
        button3 = (Button) findViewById(R.id.button3);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent Vol_Calc = new Intent(MainActivity.this, VolumeMenu.class);
                startActivity(Vol_Calc);
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
        vol_init();
    }


    private void setToolBar() {
        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        ActionBar ab = getSupportActionBar();


    }
}
