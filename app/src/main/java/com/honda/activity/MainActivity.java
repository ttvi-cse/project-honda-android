package com.honda.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.honda.R;

import java.util.HashMap;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private LinearLayout maintenance;
    private LinearLayout promotion;
    private LinearLayout insurance;
    private LinearLayout ambumlance;
    private LinearLayout towing;
    private LinearLayout search;
    private SliderLayout advertisement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        maintenance = (LinearLayout) findViewById(R.id.maintenance);
        promotion = (LinearLayout) findViewById(R.id.promotion);
        insurance = (LinearLayout) findViewById(R.id.insurance);
        ambumlance = (LinearLayout) findViewById(R.id.ambumlance);
        towing = (LinearLayout) findViewById(R.id.towing);
        search = (LinearLayout) findViewById(R.id.search);
        advertisement = (SliderLayout) findViewById(R.id.advertisement);

        maintenance.setOnClickListener(this);
        promotion.setOnClickListener(this);
        insurance.setOnClickListener(this);
        ambumlance.setOnClickListener(this);
        towing.setOnClickListener(this);
        search.setOnClickListener(this);

        setupAdvertisement();
    }

    @Override
    boolean showAdvertisement() {
        return false;
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
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.maintenance:
                i = new Intent(MainActivity.this, MaintenanceActivity.class);
                startActivity(i);
                break;
            case R.id.promotion:
                i = new Intent(MainActivity.this, PromotionActivity.class);
                startActivity(i);
                break;
            case R.id.insurance:
                i = new Intent(MainActivity.this, InsuranceActivity.class);
                startActivity(i);
                break;
            case R.id.ambumlance:
                i = new Intent(MainActivity.this, AbumlanceActivity.class);
                startActivity(i);
                break;
            case R.id.towing:
                i = new Intent(MainActivity.this, TowingActivity.class);
                startActivity(i);
                break;
            case R.id.search:
                i = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(i);
                break;
            default:
                break;
        }
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Intent i = new Intent(MainActivity.this, AdvertisingActivity.class);
        startActivity(i);
    }
}
