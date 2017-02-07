package com.introtoandroid.mortgage_calculator_masiowski;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * MORTGAGE CALCULATOR APP
 *
 * INPUT: a home value, loan amount, interest rate, loan term,
 start date, property tax, home insurance per year, and monthly HOA amount + an option to
 calculate mortgage summary or an option for payment summary.
 *
 * OUPUT: whatever choice is made, that a new activity is launched with the appropriate calculations
 made. ( HINT: three activities will be required)
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
