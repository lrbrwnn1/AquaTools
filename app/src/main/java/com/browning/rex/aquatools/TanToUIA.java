package com.browning.rex.aquatools;

import android.app.Activity;
import android.os.Bundle;

public class TanToUIA extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tan_to_uia);
    }


    private double TanConverter() {
        double var1 = findViewById(Temp);
        double varNH3 = findViewById(NH3);
        double varLT = varNH3.substring(0, 1);

        if (varLT == "<") {
            varNH3 = varNH3.substring(1, varNH3.length);
        } else {
            varLT = "";
        }

        var1 = 2730.0 / (273.2 + var1);
        var2 = .0902 - pH;
        var3 = var1 + var2;
        var4 = 1.0 + Math.pow(10, var3);
        var5 = (1.0 / var4);
        var6 = (var5 * (varNH3 * 1.0));
        var5 = 100.0 * var5;
        var6 = Math.round(1000.0 * var6) / 1000.;
        ammoniaresult = var5.toFixed(1) + "%";
        if (NH3 == "") {
            UIA = "";
        } else {
            UIA = varLT.concat(var6.toFixed(3));
        }

        return UIA;
    }


}
