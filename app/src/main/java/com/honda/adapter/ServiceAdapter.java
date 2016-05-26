package com.honda.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.honda.R;
import com.honda.data.Service;
import com.honda.uicomponent.TextProgressBar;

import java.util.List;

/**
 * Created by ttvi on 5/15/2016.
 */
public class ServiceAdapter extends BaseAdapter {

    Context mContext;
    List<Service> mData;

    public ServiceAdapter(Context mContext, List<Service> mData) {
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
        Service s = mData.get(position);
        convertView.setData(s, position);
        convertView.bindingData();
        return convertView;
    }

    private class ViewHolder extends LinearLayout {

        public TextView tvTitle;
        public TextView tvLastFinish;
        public TextProgressBar pbTimeRemainning;
        public TextProgressBar pbDueMileage;
        public TextView tvCurrentMileage;
        public ImageButton btnEdit;
        public ImageView imgItem;

        Service s;
        int pos;


        public ViewHolder(Context context) {
            super(context);
            LayoutInflater li = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            li.inflate(R.layout.list_item_maintenance, this, true);

            tvTitle = (TextView) findViewById(R.id.tv_title);
            tvLastFinish = (TextView) findViewById(R.id.tv_last_finish);
            pbTimeRemainning = (TextProgressBar) findViewById(R.id.pb_time_remaining);
            pbDueMileage = (TextProgressBar) findViewById(R.id.pb_due_mileage);
            tvCurrentMileage = (TextView) findViewById(R.id.tv_cur_mileage);
            btnEdit = (ImageButton) findViewById(R.id.btn_edit);
            imgItem = (ImageView) findViewById(R.id.img_list_item);
        }

        public void setData(Service s, int pos) {
            this.s = s;
            this.pos = pos;
        }

        public void bindingData() {
            try {
                tvTitle.setText(s.getTitle());
                tvLastFinish.setText(s.getLastFinish());

                String timeRemainning = s.getTimeRemaining();

                if (timeRemainning == null || timeRemainning.equals("")) {

                    pbTimeRemainning.setVisibility(View.VISIBLE);
                    pbTimeRemainning.setProgress(80);
                    pbTimeRemainning.setText("");
                    pbTimeRemainning.setProgressDrawable(mContext.getDrawable(R.drawable.pink_progressbar));

                } else {
                    pbTimeRemainning.setVisibility(View.VISIBLE);
                    pbTimeRemainning.setProgress(100);
                    pbTimeRemainning.setText(mContext.getString(R.string.overdue));
                    pbTimeRemainning.setProgressDrawable(mContext.getDrawable(R.drawable.red_progressbar));
                }

                if (s.getTitle() != null && !s.getTitle().equals("")) {
                    if (s.getTitle().equals("OIL CHANGE")) {
                        imgItem.setImageResource(R.drawable.ic_oil_change);
                    } else if (s.getTitle().equals("TIRE CHANGE")) {
                        imgItem.setImageResource(R.drawable.ic_tie_change);
                    } else if (s.getTitle().equals("BATERRY CHANGE")) {
                        imgItem.setImageResource(R.drawable.ic_battery_change);
                    } else if (s.getTitle().equals("INSURANCE RENEWAL CHANGE")) {
                        imgItem.setImageResource(R.drawable.ic_insurance_renew);
                    }
                }

                pbDueMileage.setVisibility(View.VISIBLE);
                pbDueMileage.setProgress(100);
                pbDueMileage.setText(mContext.getString(R.string.test_due_mileage));
                pbDueMileage.setProgressDrawable(mContext.getDrawable(R.drawable.red_progressbar));

                tvCurrentMileage.setText(s.getCurMileage());
                btnEdit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                        LayoutInflater inflater = (LayoutInflater)
                                mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                        final View rootView = inflater.inflate(R.layout.dialog, null);
                        final EditText edtCurMilleage = (EditText) rootView.findViewById(R.id.edt_cur_mileage);

                        builder.setView(rootView)
                                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        String curMileage = edtCurMilleage.getText().toString();
                                        mData.get(pos).setCurMileage(curMileage);
                                        notifyDataSetChanged();
                                        Toast.makeText(mContext, curMileage, Toast.LENGTH_SHORT).show();

                                    }
                                })
                                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                });

                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
