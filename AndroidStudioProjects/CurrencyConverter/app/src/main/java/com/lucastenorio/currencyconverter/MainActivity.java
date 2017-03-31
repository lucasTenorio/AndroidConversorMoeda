package com.lucastenorio.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    boolean tx = true;
    EditText editText;
    TextView textView;

    public void calculate(View view){
        if (!tx){
            editText = (EditText)findViewById(R.id.editText3);
            Double val1 = Double.parseDouble(editText.getText().toString());
            val1 = val1 * 3.45;
            textView = (TextView) findViewById(R.id.textView5);
            textView.setText(val1.toString());
        }else{

            editText = (EditText)findViewById(R.id.editText3);
            Double val1 = Double.parseDouble(editText.getText().toString());
            val1 = val1/3.45;
            textView = (TextView) findViewById(R.id.textView5);
            textView.setText(val1.toString());

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner)findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(this,R.array.spinner_array,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(parent.getItemAtPosition(position).toString().equals("BRL to DOLAR(US)")){

                    tx = false;

               }else if(parent.getItemAtPosition(position).toString().equals("DOLAR(US) to BRL")){

                    tx = true;

              }
                Toast.makeText(getBaseContext(), parent.getItemAtPosition(position)+" Selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
