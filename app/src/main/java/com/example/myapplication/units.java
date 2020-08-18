package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class units extends AppCompatActivity {

    private EditText unitfrom;
    private Spinner spinnerunit;
    private Button b1;
    private TextView m1,cm1,metre1,kilom,miles,inch1,foot1,yard1;

    String unitss[]={ "Millimeter", "Centimeter", "Metre", "Kilometre","mile","Inch","Foot","yard"};

    ArrayAdapter<String> adapter3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_units);

        unitfrom=(EditText)findViewById(R.id.unitLenght);
        m1=(TextView)findViewById(R.id.milli);
        cm1=(TextView)findViewById(R.id.cm);
        metre1=(TextView)findViewById(R.id.metre);
        kilom=(TextView)findViewById(R.id.kilometre);
        miles=(TextView)findViewById(R.id.mile);
        inch1=(TextView)findViewById(R.id.inch);
        foot1=(TextView)findViewById(R.id.foot);
        yard1=(TextView)findViewById(R.id.yard);
        b1=(Button) findViewById(R.id.unit_button);
        spinnerunit=(Spinner) findViewById(R.id.spinner_lenght);


        adapter3=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,unitss);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerunit.setAdapter(adapter3);

        unitfrom.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(unitfrom.getText().toString().isEmpty()){
                    unitfrom.setError("Field cannot be Empty");
                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        spinnerunit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(units.this, "Millimeter", Toast.LENGTH_SHORT).show();

                                m1.setText("in millimetre");
                                m1.setText("in metre");
                                m1.setText("in millimetre");
                                m1.setText("in millimetre");
                                m1.setText("in millimetre");
                                m1.setText("in millimetre");
                                m1.setText("in millimetre");
                                m1.setText("in millimetre");


                            }
                        });

                        break;
                    case 1:
                        break;

                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





    }
}
