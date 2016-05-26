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

public class TowingActivity extends BaseActivity implements BaseSliderView.OnSliderClickListener{

    private ListView listView;
    private RelativeLayout home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listView = (ListView) findViewById(R.id.listView);
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

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TowingActivity.this, MainActivity.class));
            }
        });

    }

    @Override
    protected int getLayoutViewResId() {
        return R.layout.activity_towing;
    }

    @Override
    protected boolean showAdvertisement() {
        return true;
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Intent i = new Intent(TowingActivity.this, AdvertisingActivity.class);
        startActivity(i);
    }
}
