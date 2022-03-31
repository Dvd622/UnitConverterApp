package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText et_value = (EditText) findViewById(R.id.et_value);
        TextView tv_value1 = findViewById(R.id.tv_value1);
        TextView tv_value2 = findViewById(R.id.tv_value2);
        TextView tv_value3 = findViewById(R.id.tv_value3);
        TextView tv_unit1 = findViewById(R.id.tv_unit1);
        TextView tv_unit2 = findViewById(R.id.tv_unit2);
        TextView tv_unit3 = findViewById(R.id.tv_unit3);
        ImageButton ib_length = findViewById(R.id.ib_length);
        ImageButton ib_temperature = findViewById(R.id.ib_temperature);
        ImageButton ib_weight = findViewById(R.id.ib_weight);

        Spinner spinner_units = (Spinner) findViewById(R.id.spinner_units);
        ArrayAdapter<CharSequence> adapter_units = ArrayAdapter.createFromResource(this, R.array.units_array, android.R.layout.simple_spinner_item);
        adapter_units.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_units.setAdapter(adapter_units);

        tv_value1.setText("");
        tv_value2.setText("");
        tv_value3.setText("");
        tv_unit1.setText("");
        tv_unit2.setText("");
        tv_unit3.setText("");

        ib_length.setOnClickListener(view -> {
            if (spinner_units.getSelectedItem().toString().equals("Metres")) {
                double result_cm;
                double result_foot;
                double result_inch;
                double value = Double.parseDouble(et_value.getText().toString());

                result_cm = value * 100;
                result_foot = value * 3.281;
                result_inch = value * 39.37;

                tv_value1.setText(String.format("%.2f", result_cm));
                tv_value2.setText(String.format("%.2f", result_foot));
                tv_value3.setText(String.format("%.2f", result_inch));
                tv_unit1.setText("Centimetre");
                tv_unit2.setText("Foot");
                tv_unit3.setText("Inch");
            } else {
                Toast.makeText(MainActivity.this, "Please select the correct conversion icon", Toast.LENGTH_SHORT).show();
            }
        });

        ib_temperature.setOnClickListener(view -> {
            if (spinner_units.getSelectedItem().toString().equals("Celsius")) {
                double result_fahrenheit;
                double result_kelvin;
                double value = Double.parseDouble(et_value.getText().toString());

                result_fahrenheit = (value * 9 / 5) + 32;
                result_kelvin = value + 273.15;

                tv_value1.setText(String.format("%.2f", result_fahrenheit));
                tv_value2.setText(String.format("%.2f", result_kelvin));
                tv_value3.setText("");
                tv_unit1.setText("Fahrenheit");
                tv_unit2.setText("Kelvin");
                tv_unit3.setText("");
            } else {
                Toast.makeText(MainActivity.this, "Please select the correct conversion icon", Toast.LENGTH_SHORT).show();
            }
        });

        ib_weight.setOnClickListener(view -> {
            if (spinner_units.getSelectedItem().toString().equals("Kilograms")) {
                double result_gram;
                double result_ounce;
                double result_pound;
                double value = Double.parseDouble(et_value.getText().toString());

                result_gram = value * 1000;
                result_ounce = value * 35.274;
                result_pound = value * 2.205;

                tv_value1.setText(String.format("%.2f", result_gram));
                tv_value2.setText(String.format("%.2f", result_ounce));
                tv_value3.setText(String.format("%.2f", result_pound));
                tv_unit1.setText("Gram");
                tv_unit2.setText("Ounce(Oz)");
                tv_unit3.setText("Pound(lb)");
            } else {
                Toast.makeText(MainActivity.this, "Please select the correct conversion icon", Toast.LENGTH_SHORT).show();
            }
        });
    }
}