package com.honda.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.honda.R;

import java.util.HashMap;

/**
 * Created by ttvi on 5/26/2016.
 */
public abstract class BaseActivity extends FragmentActivity implements BaseSliderView.OnSliderClickListener{

    private SliderLayout advertisement;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutViewResId());


        if(showAdvertisement()) {
            advertisement = (SliderLayout) findViewById(R.id.advertisement);
//            advertisement.setMinimumeight(getWindowManager().get);
            setupAdvertisement();
        }
    }

    protected abstract int getLayoutViewResId();
    protected abstract boolean showAdvertisement();

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
                    .setScaleType(DefaultSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);
            advertisement.addSlider(textSliderView);
            advertisement.setPresetTransformer(SliderLayout.Transformer.Fade);
            advertisement.setDuration(4000);
        }
    }

    @Override
    protected void onStop() {
        if (showAdvertisement()) {
            advertisement.stopAutoCycle();
        }
        super.onStop();
    }
}
