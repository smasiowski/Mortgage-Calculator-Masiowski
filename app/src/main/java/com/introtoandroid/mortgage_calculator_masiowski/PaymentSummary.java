package com.introtoandroid.mortgage_calculator_masiowski;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.DatePicker;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by user on 2/12/17.
 */

public class PaymentSummary extends AppCompatActivity {

    TextView totalInterestSavings;
    TextView totalInterestPaid;
    TextView monthlyInterestPaid;
    TextView biWeeklyPayoffDate;
    TextView monthlyPayoffDate;
    TextView biWeeklyPayment;
    TextView monthlyPayment;


    //ONCREATE =====================================================================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_summary);



        totalInterestSavings = (TextView) findViewById(R.id.totalInterestSavings);
        totalInterestPaid = (TextView) findViewById(R.id.totalInterestPaid);
        monthlyInterestPaid = (TextView) findViewById(R.id.monthlyInterestPaid);
        biWeeklyPayoffDate = (TextView) findViewById(R.id.biWeeklyPayoffDate);
        monthlyPayoffDate = (TextView) findViewById(R.id.monthlyPayoffDate);
        biWeeklyPayment = (TextView) findViewById(R.id.biWeeklyPayment);
        monthlyPayment = (TextView) findViewById(R.id.monthlyPayment);


        Intent paymentIntent = getIntent();




        totalInterestSavings.setText(paymentIntent.getStringExtra("TIS"));
        totalInterestPaid.setText(paymentIntent.getStringExtra("TIP"));
        monthlyInterestPaid.setText(paymentIntent.getStringExtra("MIP"));
        biWeeklyPayoffDate.setText(paymentIntent.getStringExtra("BWPD"));
        monthlyPayoffDate.setText(paymentIntent.getStringExtra("MPD"));
        biWeeklyPayment.setText(paymentIntent.getStringExtra("BWP"));
        monthlyPayment.setText(paymentIntent.getStringExtra("MP"));

    }


    // BACK TO FORM ================================================================================
    protected void back(View view){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
