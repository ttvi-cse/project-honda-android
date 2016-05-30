package com.honda.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.honda.R;
import com.honda.data.Station;

import java.util.List;

/**
 * Created by ttvi on 5/15/2016.
 */
public class StationAdapter extends BaseAdapter {

    Context mContext;
    List<Station> mData;

    public StationAdapter(Context mContext, List<Station> mData) {
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
        Station station = mData.get(position);
        convertView.setData(station, position);
        convertView.bindingData();
        return convertView;
    }

    private class ViewHolder extends LinearLayout {

        public LinearLayout layoutItem;// = (LinearLayout) v.findViewById(R.id.item_accident_alert_layout);
        public TextView tvName;// = (TextView) v.findViewById(R.id.tv_name);
        public TextView tvAddress;// = (TextView) v.findViewById(R.id.tv_address);
        public TextView tvPhoneNumber;// = (TextView) v.findViewById(R.id.tv_phone_number);

        Station station;
        int pos;


        public ViewHolder(Context context) {
            super(context);
            LayoutInflater li = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            li.inflate(R.layout.list_item_accident_alert, this, true);

            layoutItem = (LinearLayout) findViewById(R.id.item_accident_alert_layout);
            tvName = (TextView) findViewById(R.id.tv_name);
            tvAddress = (TextView) findViewById(R.id.tv_address);
            tvPhoneNumber = (TextView) findViewById(R.id.tv_phone_number);
        }

        public void setData(Station station, int pos) {
            this.station = station;
            this.pos = pos;
        }

        public void bindingData() {
            try {
                tvName.setText(station.getName());
                tvAddress.setText(station.getAddress());
                tvPhoneNumber.setText(station.getPhoneNumber());
                layoutItem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContext, "Calling: " + station.getPhoneNumber() + " ...", Toast.LENGTH_SHORT).show();
                    }
                });
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
