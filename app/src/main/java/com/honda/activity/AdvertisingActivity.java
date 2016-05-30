package com.honda.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.honda.R;
import com.honda.adapter.AdvertisingAdapter;
import com.honda.data.Advertising;

import java.util.ArrayList;
import java.util.List;

public class AdvertisingActivity extends BaseActivity {

    private ListView listView;
    private RelativeLayout home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listView = (ListView) findViewById(R.id.listView);
        home = (RelativeLayout) findViewById(R.id.home);

        List<Advertising> mData = new ArrayList<>();
        mData.add(new Advertising(getString(R.string.ambulance_service_advertising_title), R.drawable.ambulance_service_advertising, getString(R.string.ambulance_service_advertising_content)));
        mData.add(new Advertising(getString(R.string.battery_advertising_title), R.drawable.battery_advertising, getString(R.string.battery_advertising_content)));
        mData.add(new Advertising(getString(R.string.car_insurance_advertising_title), R.drawable.car_insurance_advertising, getString(R.string.car_insurance_advertising_content)));
        mData.add(new Advertising(getString(R.string.oil_change_advertising_title), R.drawable.oil_change_advertising, getString(R.string.oil_change_advertising_content)));
        mData.add(new Advertising(getString(R.string.oil_promotion_products_advertising_title), R.drawable.oil_promotion_products_advertising, getString(R.string.oil_promotion_products_advertising_content)));
        mData.add(new Advertising(getString(R.string.towing_advertising_title), R.drawable.towing_advertising, getString(R.string.towing_advertising_content)));
        listView.setAdapter(new AdvertisingAdapter(AdvertisingActivity.this, mData));

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdvertisingActivity.this, MainActivity.class));
            }
        });
    }

    @Override
    protected int getLayoutViewResId() {
        return R.layout.activity_advertising;
    }

    @Override
    protected boolean showAdvertisement() {
        return false;
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }
}
