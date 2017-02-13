package com.introtoandroid.mortgage_calculator_masiowski;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.DatePicker;
import android.content.Intent;



/**
 * MORTGAGE CALCULATOR APP
 * <p>
 * INPUT: a home value, loan amount, interest rate, loan term,
 * start date, property tax, home insurance per year, and monthly HOA amount + an option to
 * calculate mortgage summary or an option for payment summary.
 * <p>
 * OUPUT: whatever choice is made, that a new activity is launched with the appropriate calculations
 * made. ( HINT: three activities will be required)
 */

public class MainActivity extends AppCompatActivity {


    // WIDGETS
    EditText homeValue_ET;
    EditText loanAmount_ET;
    EditText interestRate_ET;
    EditText loanTerm_ET;
    DatePicker startDate;
    EditText propertyTax_ET;
    EditText homeIns_ET;
    EditText monthlyHOA_ET;

    Button mortgageSummaryButton;
    Button paymentSummaryButton;


    // VALUES
    int homeValue;
    int loanAmount;
    double interestRate;
    int loanTerm;
    int SD_month;
    int SD_day;
    int SD_year;
    double propertyTax;
    double homeInsurance;
    int monthlyHOA;


    //ONCREATE =====================================================================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();

        // get widgets by id from main activity
        homeValue_ET = (EditText) findViewById(R.id.homeValue);
        loanAmount_ET = (EditText) findViewById(R.id.loanAmount);
        interestRate_ET = (EditText) findViewById(R.id.interestRate);
        loanTerm_ET = (EditText) findViewById(R.id.loanTerm);
        startDate = (DatePicker) findViewById(R.id.startDate);
        propertyTax_ET = (EditText) findViewById(R.id.propertyTax);
        monthlyHOA_ET = (EditText) findViewById(R.id.monthlyHOA);
        homeIns_ET = (EditText) findViewById(R.id.homeIns);

        mortgageSummaryButton = (Button) findViewById(R.id.mortgageSummaryButton);
        paymentSummaryButton = (Button) findViewById(R.id.paymentSummaryButton);



    }


    // PAYMENT SUMMARY =============================================================================
    public void payment(View view) {
        Intent paymentIntent = new Intent(this, PaymentSummary.class);

        // GET VALUES FROM FORM
        homeValue = Integer.parseInt(String.valueOf(homeValue_ET.getText()));
        loanAmount = Integer.parseInt(String.valueOf(loanAmount_ET.getText()));
        interestRate = Double.parseDouble(String.valueOf(interestRate_ET.getText()));
        loanTerm = Integer.parseInt(String.valueOf(loanTerm_ET.getText()));
        propertyTax = Double.parseDouble(String.valueOf(propertyTax_ET.getText()));
        homeInsurance = Double.parseDouble(String.valueOf(homeIns_ET.getText()));
        monthlyHOA = Integer.parseInt(String.valueOf(monthlyHOA_ET.getText()));
        SD_day = Integer.parseInt(String.valueOf(startDate.getDayOfMonth()));
        SD_month = Integer.parseInt(String.valueOf(startDate.getMonth()));
        SD_year = Integer.parseInt(String.valueOf(startDate.getYear()));


        // CALCULATE VALUES ------------------------------------------------------------------------

        double monthlyinterestrate = (interestRate/100)/12;
        double totalMortgage1 = ((monthlyinterestrate*loanAmount)/(1-(1+monthlyinterestrate)*(loanTerm*(-12))));
        double totalMortgage = totalMortgage1*(loanTerm*12);

        //PAYMENTS
        double monthlyPayment = (totalMortgage/loanTerm)/12;
        double biWeeklyPayment = monthlyPayment/2;

        //INTEREST PAID
        double totalInterestPaid = (interestRate/100)*loanAmount;
        double monthlyInterestPaid = totalInterestPaid/12;

        //PAYOFF DATE
        int monthlyPayoffDate = 5;
        int biWeeklyPayoffDate = 5;

        //INTEREST SAVINGS
        int totalInterestSavings = 5;


        // convert values to string
        String TIS = String.valueOf(totalInterestSavings);
        String TIP = String.valueOf(totalInterestPaid);
        String MIP =String.valueOf(monthlyInterestPaid);
        String BWPD =String.valueOf(biWeeklyPayoffDate);
        String MPD = String.valueOf(monthlyPayoffDate);
        String BWP = String.valueOf(biWeeklyPayment);
        String MP = String.valueOf(monthlyPayment);


        // SEND VALUES TO ACTIVITY
        paymentIntent.putExtra("TIS", TIS);
        paymentIntent.putExtra("TIP", TIP);
        paymentIntent.putExtra("MIP", MIP);
        paymentIntent.putExtra("BWPD", BWPD);
        paymentIntent.putExtra("MPD", MPD);
        paymentIntent.putExtra("BWP", BWP);
        paymentIntent.putExtra("MP", MP);


        startActivity(paymentIntent);
    }



    // MORTGAGE SUMMARY ============================================================================
    public void mortgage(View view) {
        // create new intent
        Intent mortgageIntent = new Intent(this, MortgageSummary.class);


        // GET VALUES FROM FORM
        homeValue = Integer.parseInt(String.valueOf(homeValue_ET.getText()));
        loanAmount = Integer.parseInt(String.valueOf(loanAmount_ET.getText()));
        interestRate = Double.parseDouble(String.valueOf(interestRate_ET.getText()));
        loanTerm = Integer.parseInt(String.valueOf(loanTerm_ET.getText()));
        propertyTax = Double.parseDouble(String.valueOf(propertyTax_ET.getText()));
        homeInsurance = Double.parseDouble(String.valueOf(homeIns_ET.getText()));
        monthlyHOA = Integer.parseInt(String.valueOf(monthlyHOA_ET.getText()));
        SD_day = Integer.parseInt(String.valueOf(startDate.getDayOfMonth()));
        SD_month = Integer.parseInt(String.valueOf(startDate.getMonth()));
        SD_year = Integer.parseInt(String.valueOf(startDate.getYear()));

        // CALCULATE VALUES ------------------------------------------------------------------------
        double monthlyinterestrate = (interestRate/100)/12;
        double totalMortgage1 = ((monthlyinterestrate*loanAmount)/(1-(1+monthlyinterestrate)*(loanTerm*(-12))));
        double totalMortgage = totalMortgage1*(loanTerm*12);


        //total interest paid
        double totalInterestPaid=interestRate/100;


        //TAX PAID
        double totalTaxPaid= loanAmount*(propertyTax/100);
        double monthlyTaxPaid = totalTaxPaid/12;

        //HOME INSURANCE
        double totalHomeInsurance= loanTerm*homeInsurance;
        double monthlyHomeInsurance = totalHomeInsurance/12;



        double annualLoanAmount=totalMortgage/loanTerm;
        double total360Payments=totalMortgage;

        //   loanPayoffDate;



        // convert values to string
        String TIP = String.valueOf(totalInterestPaid);
        String MTP = String.valueOf(monthlyTaxPaid);
        String TTP = String.valueOf(totalTaxPaid);
        String MHI = String.valueOf(monthlyHomeInsurance);
        String THI = String.valueOf(totalHomeInsurance);
        String ALA = String.valueOf(annualLoanAmount);
        String T360P = String.valueOf(total360Payments);
        //   loanPayoffDate;

        // SEND VALUES TO ACTIVITY
        mortgageIntent.putExtra("TIP", TIP);
        mortgageIntent.putExtra("MTP", MTP);
        mortgageIntent.putExtra("TTP", TTP);
        mortgageIntent.putExtra("MHI", MHI);
        mortgageIntent.putExtra("THI", THI);
        mortgageIntent.putExtra("ALA", ALA);
        mortgageIntent.putExtra("T360P", T360P);


        startActivity(mortgageIntent);
    }







}

