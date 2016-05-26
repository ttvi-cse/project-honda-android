package com.honda.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.daimajia.slider.library.SliderTypes.BaseSliderView;

import com.honda.R;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private LinearLayout maintenance;
    private LinearLayout promotion;
    private LinearLayout insurance;
    private LinearLayout ambumlance;
    private LinearLayout towing;
    private LinearLayout search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        maintenance = (LinearLayout) findViewById(R.id.maintenance);
        promotion = (LinearLayout) findViewById(R.id.promotion);
        insurance = (LinearLayout) findViewById(R.id.insurance);
        ambumlance = (LinearLayout) findViewById(R.id.ambumlance);
        towing = (LinearLayout) findViewById(R.id.towing);
        search = (LinearLayout) findViewById(R.id.search);

        maintenance.setOnClickListener(this);
        promotion.setOnClickListener(this);
        insurance.setOnClickListener(this);
        ambumlance.setOnClickListener(this);
        towing.setOnClickListener(this);
        search.setOnClickListener(this);

    }

    @Override
    protected int getLayoutViewResId() {
        return R.layout.activity_main;
    }

    @Override
    protected boolean showAdvertisement() {
        return true;
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
