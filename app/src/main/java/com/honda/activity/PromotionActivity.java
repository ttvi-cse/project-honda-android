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
import com.honda.adapter.VoucherAdapter;
import com.honda.data.Voucher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PromotionActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener {

    private ListView listView;
    private SliderLayout advertisement;
    private RelativeLayout home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotion);

        listView = (ListView) findViewById(R.id.listView);
        advertisement = (SliderLayout) findViewById(R.id.advertisement);
        home = (RelativeLayout) findViewById(R.id.home);

        List<Voucher> mData = new ArrayList<>();
        mData.add(new Voucher(getString(R.string.ambulance_service_advertising_title), R.drawable.ambulance_service_advertising, getString(R.string.ambulance_service_advertising_content), false));
        mData.add(new Voucher(getString(R.string.battery_advertising_title), R.drawable.battery_advertising, getString(R.string.battery_advertising_content), false));
        mData.add(new Voucher(getString(R.string.car_insurance_advertising_title), R.drawable.car_insurance_advertising, getString(R.string.car_insurance_advertising_content), true));
        mData.add(new Voucher(getString(R.string.oil_change_advertising_title), R.drawable.oil_change_advertising, getString(R.string.oil_change_advertising_content), false));
        mData.add(new Voucher(getString(R.string.oil_promotion_products_advertising_title), R.drawable.oil_promotion_products_advertising, getString(R.string.oil_promotion_products_advertising_content), true));
        mData.add(new Voucher(getString(R.string.towing_advertising_title), R.drawable.towing_advertising, getString(R.string.towing_advertising_content), true));
        listView.setAdapter(new VoucherAdapter(PromotionActivity.this, mData));

        advertisement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PromotionActivity.this, AdvertisingActivity.class);
                startActivity(i);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PromotionActivity.this, MainActivity.class));
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
        Intent i = new Intent(PromotionActivity.this, AdvertisingActivity.class);
        startActivity(i);
    }

    @Override
    protected void onStop() {
        advertisement.stopAutoCycle();
        super.onStop();
    }
}
