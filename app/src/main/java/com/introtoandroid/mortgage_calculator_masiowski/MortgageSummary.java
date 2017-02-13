package com.introtoandroid.mortgage_calculator_masiowski;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.DatePicker;

/**
 * Created by user on 2/12/17.
 */

public class MortgageSummary extends AppCompatActivity {

    DatePicker loanPayoffDate;
    TextView totalInterestPaid;
    TextView monthlyTaxPaid;
    TextView totalTaxPaid;
    TextView monthlyHomeInsurance;
    TextView totalHomeInsurance;
    TextView annualLoanAmount;
    TextView total360Payments;


    //ONCREATE =====================================================================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mortgage_summary);

        loanPayoffDate  = (DatePicker) findViewById(R.id.datePicker);
        totalInterestPaid = (TextView) findViewById(R.id.totalInterestPaid);
        monthlyTaxPaid = (TextView) findViewById(R.id.monthlyTaxPaid);
        totalTaxPaid = (TextView) findViewById(R.id.totalTaxPaid);
        monthlyHomeInsurance = (TextView) findViewById(R.id.monthlyHomeInsurance);
        totalHomeInsurance = (TextView) findViewById(R.id.totalHomeInsurance);
        annualLoanAmount = (TextView) findViewById(R.id.annualLoanAmount);
        total360Payments = (TextView) findViewById(R.id.total360Payments);

        Intent mortgageIntent = getIntent();


        // set values
      //   loanPayoffDate;
         totalInterestPaid.setText(mortgageIntent.getStringExtra("TIP"));
         monthlyTaxPaid.setText(mortgageIntent.getStringExtra("MTP"));
         totalTaxPaid.setText(mortgageIntent.getStringExtra("TTP"));
         monthlyHomeInsurance.setText(mortgageIntent.getStringExtra("MHI"));
         totalHomeInsurance.setText(mortgageIntent.getStringExtra("THI"));
         annualLoanAmount.setText(mortgageIntent.getStringExtra("ALA"));
         total360Payments.setText(mortgageIntent.getStringExtra("T360P"));


    }

    // BACK TO FORM ================================================================================
    protected void back(View view){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
