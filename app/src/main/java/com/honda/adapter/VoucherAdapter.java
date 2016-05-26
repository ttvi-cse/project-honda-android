package com.honda.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.honda.activity.AdvertisingActivity;
import com.honda.activity.PaymentActivity;
import com.honda.R;
import com.honda.data.Voucher;

import java.util.List;

/**
 * Created by ttvi on 5/15/2016.
 */
public class VoucherAdapter extends BaseAdapter {

    private static final String TAG = VoucherAdapter.class.getSimpleName();

    Context mContext;
    List<Voucher> mData;

    public VoucherAdapter(Context mContext, List<Voucher> mData) {
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
        Voucher s = mData.get(position);
        convertView.setData(s, position);
        convertView.bindingData();
        return convertView;
    }

    private class ViewHolder extends LinearLayout {
        public TextView tvTitle;
        public ImageView imageView;
        public TextView tvContent;
        public Button btnCall;
        public Button btnBuy;
        public Button btnShow;
        
        Voucher voucher;
        int pos;
        
        public ViewHolder(Context context) {
            super(context);
            LayoutInflater li = (LayoutInflater)    
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            li.inflate(R.layout.list_item_promotion, this, true);

            tvTitle = (TextView) findViewById(R.id.tv_title);
            imageView = (ImageView) findViewById(R.id.img_promotion);
            tvContent = (TextView) findViewById(R.id.tv_advertising);
            btnCall = (Button) findViewById(R.id.btn_call);
            btnBuy = (Button) findViewById(R.id.btn_buy_now);
            btnShow = (Button) findViewById(R.id.btn_show);

        }

        public void setData(Voucher voucher, int pos) {
            this.voucher = voucher;
            this.pos = pos;
        }

        public void bindingData() {
            try {
                Log.i(TAG, "Bind data: " + pos);

                tvTitle.setText(voucher.getTitle());
                imageView.setImageResource(voucher.getImgRes());
                tvContent.setText(voucher.getContent());

                if (voucher.isNegotiated()) {
                    btnBuy.setVisibility(View.GONE);
                    btnShow.setVisibility(View.VISIBLE);
                } else {
                    btnBuy.setVisibility(View.VISIBLE);
                    btnShow.setVisibility(View.GONE);
                }
                btnBuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(mContext, PaymentActivity.class);
                        i.putExtra(PaymentActivity.EXTRA_TITLE, voucher.getTitle());
                        mContext.startActivity(i);
                    }
                });
                btnShow.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(mContext, AdvertisingActivity.class);
                        mContext.startActivity(i);
                    }
                });
                btnCall.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContext, "Button \"CALL\" clicked!", Toast.LENGTH_SHORT).show();
                    }
                });

            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
