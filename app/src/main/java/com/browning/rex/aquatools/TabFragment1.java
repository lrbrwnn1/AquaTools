package com.browning.rex.aquatools;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class TabFragment1 extends Fragment {
    public static final String Cylinder_Volume = "?";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment1,
                container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            String link = bundle.getString("?");
            setText(link);
        }
    }

    public void setText(String cyl_vol) {
        TextView view = (TextView) getView().findViewById(R.id.cylinder_volume_result);
        view.setText(cyl_vol);
    }
}








