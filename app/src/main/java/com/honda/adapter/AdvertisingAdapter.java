package com.honda.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.honda.R;
import com.honda.data.Advertising;

import java.util.List;

/**
 * Created by ttvi on 5/15/2016.
 */
public class AdvertisingAdapter extends BaseAdapter {

    Context mContext;
    List<Advertising> mData;

    public AdvertisingAdapter(Context mContext, List<Advertising> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public int getCount() {
        if(null != mData){
            return mData.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder convertView;
        if (view == null) {
            convertView = new ViewHolder(mContext);
        } else {
            convertView = (ViewHolder) view;
        }
        Advertising s = mData.get(position);
        convertView.setData(s, position);
        convertView.bindingData();
        return convertView;
    }

    private class ViewHolder extends LinearLayout {
        public TextView tvTitle;
        public ImageView imageView;
        public TextView tvContent;

        Advertising advertisement;
        int pos;

        public ViewHolder(Context context) {
            super(context);
            LayoutInflater li = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            li.inflate(R.layout.list_item_advertising, this, true);

            tvTitle = (TextView) findViewById(R.id.tv_title);
            imageView = (ImageView) findViewById(R.id.img_advertising);
            tvContent = (TextView) findViewById(R.id.tv_advertising);
        }

        public void setData(Advertising advertisement, int pos) {
            this.advertisement = advertisement;
            this.pos = pos;
        }

        public void bindingData() {
            try {
                tvTitle.setText(advertisement.getTitle());
                // get image url and show to list item
                imageView.setImageResource(advertisement.getImgRes());
                tvContent.setText(advertisement.getContent());
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
