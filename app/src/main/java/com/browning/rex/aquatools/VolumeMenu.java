package com.browning.rex.aquatools;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

@SuppressWarnings("ALL")
public class VolumeMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.volume_menu);
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public class CylinderVolume extends AppCompatActivity {
        public TextView CylinderVolume;
        private EditText CylinderHeight;
        private EditText CylinderRadius;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.ppt);

            CylinderHeight = (EditText) findViewById(R.id.CylinderHeight);
            CylinderRadius = (EditText) findViewById(R.id.CylinderRadius);
            Button CylinderButton = (Button) findViewById(R.id.CylinderButton);
            CylinderVolume = (TextView) findViewById(R.id.CylinderVolume);

            CylinderButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    makeCalculation();
                }
            });
        }

        public double makeCalculation() {
            //This gets the volume of a cylinder via the formula V=r**2*h*pi
            double cylinder_height = Double.valueOf(CylinderHeight.getText().toString());
            double cylinder_radius = Double.valueOf(CylinderRadius.getText().toString());
            double CylinderVolumeugly = (Math.PI * (cylinder_radius * cylinder_radius) * cylinder_height * 0.004329);
            double CylinderVolume = Math.round(CylinderVolumeugly * 100.0) / 100.0;
            return CylinderVolume;


        }

    }


}
