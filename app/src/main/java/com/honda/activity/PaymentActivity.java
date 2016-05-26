package com.honda.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.honda.R;

public class PaymentActivity extends AppCompatActivity implements OnClickListener {

    public static final String EXTRA_TITLE = "title";

    private RelativeLayout home;

    private Button btnQuantityUp;
    private Button btnQuantityDown;
    private Button btnExpirationUp;
    private Button btnExpirationDown;
    private Button btnYearUp;
    private Button btnYearDown;
    private Button btnSubmit;

    private TextView tvDescription;
    private TextView tvQuantity;
    private TextView tvExpiration;
    private TextView tvYear;

    int quantity = 1, month = 1, year = 2020;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        btnQuantityUp = (Button) findViewById(R.id.btn_quantity_up);
        btnQuantityDown = (Button) findViewById(R.id.btn_quantity_down);
        btnExpirationUp = (Button) findViewById(R.id.btn_expiration_up);
        btnExpirationDown = (Button) findViewById(R.id.btn_expiration_down);
        btnYearUp = (Button) findViewById(R.id.btn_year_up);
        btnYearDown = (Button) findViewById(R.id.btn_year_down);
        btnSubmit = (Button) findViewById(R.id.btn_submit);

        tvDescription = (TextView) findViewById(R.id.tv_description);
        tvQuantity = (TextView) findViewById(R.id.tv_quantity);
        tvExpiration = (TextView) findViewById(R.id.tv_expiration);
        tvYear = (TextView) findViewById(R.id.tv_year);
        home = (RelativeLayout) findViewById(R.id.home);


        Intent i = getIntent();
        if (i != null && i.getExtras() != null) {
            String description = i.getStringExtra(EXTRA_TITLE);
            tvDescription.setText(description);
        } else {
            tvDescription.setText("No description.");
        }
        tvQuantity.setText(Integer.toString(quantity));
        tvExpiration.setText(Integer.toString(month));
        tvYear.setText(Integer.toString(year));
        
        btnQuantityUp.setOnClickListener(this);
        btnQuantityDown.setOnClickListener(this);
        btnExpirationUp.setOnClickListener(this);
        btnExpirationDown.setOnClickListener(this);
        btnYearUp.setOnClickListener(this);
        btnYearDown.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);
        home.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_quantity_up:
                tvQuantity.setText(Integer.toString(++quantity));
                break;
            case R.id.btn_quantity_down:
                tvQuantity.setText(Integer.toString(--quantity));
                break;
            case R.id.btn_expiration_up:
                tvExpiration.setText(Integer.toString(++month));
                break;
            case R.id.btn_expiration_down:
                tvExpiration.setText(Integer.toString(--month));
                break;
            case R.id.btn_year_up:
                tvYear.setText(Integer.toString(++year));
                break;
            case R.id.btn_year_down:
                tvYear.setText(Integer.toString(--year));
                break;
            case R.id.btn_submit:
                Toast.makeText(PaymentActivity.this, "Submiting...", Toast.LENGTH_SHORT).show();
                break;
            case R.id.home:
                startActivity(new Intent(PaymentActivity.this, MainActivity.class));
                break;
            default:
                break;
        }
    }
}
