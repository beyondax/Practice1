package com.sergej.balabanov.practice1;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ConverterActivity extends AppCompatActivity {

    private EditText mFromEditText;
    private EditText mToEditText;
    private Spinner mFromSpinner;
    private Spinner mToSpinner;
    private TextView mFromTextView;
    private TextView mToTextView;
    private Conversion mConversion;
    private Unit mFromUnit;
    private Unit mToUnit;


    public ConverterActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        mFromEditText = findViewById(R.id.from_base_edit_text);
        mFromSpinner = findViewById(R.id.from_base_spinner);
        mToEditText = findViewById(R.id.to_base_edit_text);
        mToSpinner = findViewById(R.id.to_base_spinner);
        mFromTextView = findViewById(R.id.label_text_from);
        mToTextView = findViewById(R.id.label_text_to);

        mFromEditText.setText(R.string.default_text);
        mToEditText.setText(R.string.default_text);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            mConversion = (Conversion) getIntent().getSerializableExtra("CONVERSION");
        }

        setTitle(mConversion.mLabelRes);

        mToSpinner.setAdapter(new UnitSpinnerAdapter());
        mFromSpinner.setAdapter(new UnitSpinnerAdapter());

        mToSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mFromUnit = mConversion.mUnits.get(position);
                mToTextView.setText(getResources().getString(mFromUnit.getLabelResource()));
                convert();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mFromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mToUnit = mConversion.mUnits.get(position);
                mFromTextView.setText(getResources().getString(mToUnit.getLabelResource()));
                convert();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });

        mFromEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                convert();
            }

        });

    }

    private void convert() {
        if (mFromUnit != null && mToUnit != null) {
            final Editable fromText = mFromEditText.getText();
            if (fromText != null && fromText.length() > 0) {
                final Double fromValue = Double.valueOf(fromText.toString());
                mToEditText.setText(String.valueOf(fromValue * mFromUnit.mConversionToBase * mToUnit.mConversionFromBase));
            }
        }
        }
    }

