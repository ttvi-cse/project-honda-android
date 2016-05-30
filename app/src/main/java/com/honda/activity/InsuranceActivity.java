package com.honda.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.honda.R;
import com.honda.uicomponent.TextProgressBar;

public class InsuranceActivity extends FragmentActivity {

    private RelativeLayout home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insurance);

        home = (RelativeLayout) findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InsuranceActivity.this, MainActivity.class));
            }
        });

        TextProgressBar pbTimeRemainning = (TextProgressBar) findViewById(R.id.pb_time_remaining);
        TextProgressBar pbDueMileage = (TextProgressBar) findViewById(R.id.pb_due_mileage);

        pbTimeRemainning.setVisibility(View.VISIBLE);
        pbTimeRemainning.setProgress(80);
        pbTimeRemainning.setText("");
        pbTimeRemainning.setProgressDrawable(ContextCompat.getDrawable(InsuranceActivity.this, R.drawable.pink_progressbar));

        pbDueMileage.setVisibility(View.VISIBLE);
        pbDueMileage.setProgress(100);
        pbDueMileage.setText(getString(R.string.test_due_mileage));
        pbDueMileage.setProgressDrawable(ContextCompat.getDrawable(InsuranceActivity.this, R.drawable.red_progressbar));

        ImageButton btnEdit = (ImageButton) findViewById(R.id.btn_edit);
        final TextView tvCurrentMileage = (TextView) findViewById(R.id.tv_cur_mileage);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(InsuranceActivity.this);
                LayoutInflater inflater = (LayoutInflater)
                        getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                final View rootView = inflater.inflate(R.layout.dialog, null);
                final EditText edtCurMilleage = (EditText) rootView.findViewById(R.id.edt_cur_mileage);

                builder.setView(rootView)
                        .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String curMileage = edtCurMilleage.getText().toString();
//                                mData.get(pos).setCurMileage(curMileage);
//                                notifyDataSetChanged();
                                tvCurrentMileage.setText(curMileage);
                                Toast.makeText(InsuranceActivity.this, curMileage, Toast.LENGTH_SHORT).show();

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
    }
}
