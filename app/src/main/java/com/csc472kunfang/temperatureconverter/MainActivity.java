package com.csc472kunfang.temperatureconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doConvert(View v)
    {
        EditText temperature_input_text = findViewById(R.id.temperature_input);

        double input_number = Double.parseDouble(temperature_input_text.getText().toString());

        //Log.d("HW1", "doConvert: " + temperature_input_text.getText().toString());

        TextView temperature_output_view = findViewById(R.id.temperature_output);

        double output_number = (input_number - 32)/1.8;

        temperature_output_view.setText(String.format("%.1f", output_number));
    }
}
