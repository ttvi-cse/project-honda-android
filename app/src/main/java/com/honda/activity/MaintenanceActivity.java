package com.honda.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.google.android.gms.ads.AdView;
import com.honda.R;
import com.honda.adapter.ServiceAdapter;
import com.honda.data.Service;

import java.util.ArrayList;
import java.util.List;

public class MaintenanceActivity extends BaseActivity implements BaseSliderView.OnSliderClickListener {

    private ListView listView;
    private RelativeLayout home;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listView = (ListView) findViewById(R.id.listView);
        home = (RelativeLayout) findViewById(R.id.home);

        List<Service> mData = new ArrayList<>();
        mData.add(new Service("OIL CHANGE", "23/7/2015", "Over due", "25677", "27557"));
        mData.add(new Service("TIRE CHANGE", "23/7/2015", "", "25677", "27557"));
        mData.add(new Service("BATERRY CHANGE", "03/7/2015", "Out of date", "25677", "27557"));
//        mData.add(new Service("INSURANCE RENEWAL CHANGE", "23/6/2015", "Out of date", "25677", "27557"));
        listView.setAdapter(new ServiceAdapter(MaintenanceActivity.this, mData));

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MaintenanceActivity.this, MainActivity.class));
            }
        });
    }

    @Override
    protected int getLayoutViewResId() {
        return R.layout.activity_maintenance;
    }

    @Override
    protected boolean showAdvertisement() {
        return true;
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Intent i = new Intent(MaintenanceActivity.this, AdvertisingActivity.class);
        startActivity(i);
    }
}
