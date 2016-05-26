package com.honda.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.google.android.gms.ads.AdView;
import com.honda.R;
import com.honda.adapter.ServiceAdapter;
import com.honda.data.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MaintenanceActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener {

    private ListView listView;
    private SliderLayout advertisement;
    private RelativeLayout home;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintenance);

        listView = (ListView) findViewById(R.id.listView);
        advertisement = (SliderLayout) findViewById(R.id.advertisement);
        home = (RelativeLayout) findViewById(R.id.home);

        List<Service> mData = new ArrayList<>();
        mData.add(new Service("OIL CHANGE", "23/7/2015", "Over due", "25677", "27557"));
        mData.add(new Service("TIRE CHANGE", "23/7/2015", "", "25677", "27557"));
        mData.add(new Service("BATERRY CHANGE", "03/7/2015", "Out of date", "25677", "27557"));
//        mData.add(new Service("INSURANCE RENEWAL CHANGE", "23/6/2015", "Out of date", "25677", "27557"));
        listView.setAdapter(new ServiceAdapter(MaintenanceActivity.this, mData));

        advertisement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MaintenanceActivity.this, AdvertisingActivity.class);
                startActivity(i);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MaintenanceActivity.this, MainActivity.class));
            }
        });
        setupAdvertisement();
    }

    private void setupAdvertisement() {
        HashMap<String, Integer> file_maps = new HashMap<>();
        file_maps.put("oil_change_2", R.drawable.oil_change_2);
        file_maps.put("oil_change_3", R.drawable.oil_change_3);
        file_maps.put("oil_change_5", R.drawable.oil_change_5);
        file_maps.put("oil_change_6", R.drawable.oil_change_6);

        for (String name : file_maps.keySet()) {
            DefaultSliderView textSliderView = new DefaultSliderView(this);
            textSliderView
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);
            advertisement.addSlider(textSliderView);
            advertisement.setPresetTransformer(SliderLayout.Transformer.Fade);
//            advertisement.setCustomIndicator((PagerIndicator) findViewById(R.id.custom_indicator));
            advertisement.setDuration(4000);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        advertisement.stopAutoCycle();
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Intent i = new Intent(MaintenanceActivity.this, AdvertisingActivity.class);
        startActivity(i);
    }
}
