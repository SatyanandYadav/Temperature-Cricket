package com.example.temperaturecricket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText editTextNumber;
    Button button;
    TextView output;
    DecimalFormat formatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber=findViewById(R.id.editTextNumber);
        button=findViewById(R.id.button);
        output=findViewById(R.id.output);
         formatter=new DecimalFormat("#0.00");
        output.setVisibility(View.GONE);
        button.setOnClickListener(v -> {

            String numberOfChirps=editTextNumber.getText().toString().trim();
            if(numberOfChirps.isEmpty())
            {
                Toast.makeText(MainActivity.this,"fill the number of chirps",Toast.LENGTH_SHORT).show();
            }
            else {
                int value=Integer.parseInt(numberOfChirps);
                double degree=(value/3.0)+4;
                String put="The approximate temperature of outside is "+formatter.format(degree)+" degrees Celsius.";
                output.setText(put);
                output.setVisibility(View.VISIBLE);
            }

        });

    }
}