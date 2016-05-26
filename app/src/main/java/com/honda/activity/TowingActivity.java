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
import com.honda.R;
import com.honda.adapter.StationAdapter;
import com.honda.data.Station;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TowingActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener{

    private ListView listView;
    private SliderLayout advertisement;
    private RelativeLayout home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_towing);

        listView = (ListView) findViewById(R.id.listView);
        advertisement = (SliderLayout) findViewById(R.id.advertisement);
        home = (RelativeLayout) findViewById(R.id.home);

        List<Station> mData = new ArrayList<>();
        mData.add(new Station("Income", "234 HT street", "+65 565 856 34"));
        mData.add(new Station("AIG", "234 HT street", "+65 565 856 34"));
        mData.add(new Station("Hong Leong", "234 HT street", "+65 565 856 34"));
        mData.add(new Station("Income", "234 HT street", "+65 565 856 34"));
        mData.add(new Station("AIG", "234 HT street", "+65 565 856 34"));
        mData.add(new Station("Hong Leong", "234 HT street", "+65 565 856 34"));
        mData.add(new Station("Income", "234 HT street", "+65 565 856 34"));
        mData.add(new Station("AIG", "234 HT street", "+65 565 856 34"));
        mData.add(new Station("Hong Leong", "234 HT street", "+65 565 856 34"));
        listView.setAdapter(new StationAdapter(TowingActivity.this, mData));

        advertisement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TowingActivity.this, AdvertisingActivity.class);
                startActivity(i);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TowingActivity.this, MainActivity.class));
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
    public void onSliderClick(BaseSliderView slider) {
        Intent i = new Intent(TowingActivity.this, AdvertisingActivity.class);
        startActivity(i);
    }

    @Override
    protected void onStop() {
        advertisement.stopAutoCycle();
        super.onStop();
    }
}
