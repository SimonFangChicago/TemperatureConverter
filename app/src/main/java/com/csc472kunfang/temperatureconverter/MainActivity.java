package com.csc472kunfang.temperatureconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private boolean isF2C = true;

    public void doConvert(View v)
    {
        EditText temperature_input_text = findViewById(R.id.temperature_input);

        double input_number = Double.parseDouble(temperature_input_text.getText().toString());



        //Log.d("HW1", "doConvert: " + temperature_input_text.getText().toString());

        TextView temperature_output_view = findViewById(R.id.temperature_output);

        double output_number = 0;

        if(isF2C)
        {
            output_number = (input_number - 32)/1.8;
        }
        else
        {
            output_number = input_number*1.8 + 32;
        }

        String outputString = String.format("%.1f", output_number);
        String inputString = String.format("%.1f", input_number);
        temperature_output_view.setText(outputString);

        AddHistory(isF2C,inputString,outputString);
    }


    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        TextView temperature_format_text1 = findViewById(R.id.temperature_format_text1);
        TextView temperature_format_text2 = findViewById(R.id.temperature_format_text2);

        switch(view.getId()) {
            case R.id.radio_btn_f2c:
                if (checked)

                    temperature_format_text1.setText(R.string.f2c);
                    temperature_format_text2.setText(R.string.c2f);

                    isF2C = true;

                    break;
            case R.id.radio_btn_c2f:
                if (checked)

                    temperature_format_text1.setText(R.string.c2f);
                    temperature_format_text2.setText(R.string.f2c);

                    isF2C = false;

                    break;
        }
    }

    private void AddHistory(boolean F2CMode,String from,String to)
    {
        TextView temperature_format_text1 = findViewById(R.id.text_conversion_history);
        if(F2CMode)
        {
            temperature_format_text1.setText(temperature_format_text1.getText().toString() + "\n" + from + " F" + "==>" + to + " C");
        }
        else
        {
            temperature_format_text1.setText(temperature_format_text1.getText().toString() + "\n" + from + " C" + "==>" + to + " F");
        }

    }
}
