package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class si extends AppCompatActivity {
    private EditText paisa;
    private Spinner spprate;
    private Spinner sprate;
    private EditText rate_m,years,months,days;
    private EditText raters;
    private Button con_button;
    private TextView result,bysim;


    String rates[]={"Percentage","Rupees"};
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.si);

        paisa=(EditText)findViewById(R.id.principle);
        years=(EditText)findViewById(R.id.year);
        months=(EditText)findViewById(R.id.months);
        days=(EditText)findViewById(R.id.days);
        rate_m=(EditText)findViewById(R.id.rate_spinner);
        sprate=(Spinner) findViewById(R.id.sp_time);
        bysim=(TextView)findViewById(R.id.siby) ;
        con_button=(Button)findViewById(R.id.converter);
        result=(TextView)findViewById(R.id.result_si) ;






        adapter =new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,rates);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sprate.setAdapter(adapter);

       // if(years.getText().toString().isEmpty()){
         //   Toast.makeText(si.this, "NO empty field is allowed", Toast.LENGTH_SHORT).show();

     //   }


        paisa.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(paisa.length()==0){
                    paisa.setError("field Cannot Be Empty");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        rate_m.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(rate_m.length()==0){
                    rate_m.setError("field Cannot Be Empty");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        months.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(months.length()==0){
                    months.setError("field Cannot Be Empty");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        sprate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Toast.makeText(si.this, "Percent", Toast.LENGTH_SHORT).show();
                        bysim.setText("In Percent");


                        con_button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                if(years.getText().toString().isEmpty()){
                                    years.setText(""+0);

                                }


                                if(days.getText().toString().isEmpty()){
                                    days.setText(""+0);

                                }




                                if(months.length()==0 ){
                                    months.setError("field Cannot Be Empty");
                                 } else {
                                    float paisa_rs = Float.parseFloat(paisa.getText().toString());
                                    float ratee = Float.parseFloat(rate_m.getText().toString());
                                    int y = Integer.parseInt(years.getText().toString());
                                   int m = Integer.parseInt(months.getText().toString());
                                    int d = Integer.parseInt(days.getText().toString());


                                    float r = y/12+m+d/30;
                                    float answer=(paisa_rs*(r/12)*ratee)/100;
                                   result.setText("Rs " + answer);

                                }


                            }
                        });
                        break;

                    case 1:
                        bysim.setText("In Rupees");

                        Toast.makeText(si.this, "Rupees", Toast.LENGTH_SHORT).show();

                        con_button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                if(years.getText().toString().isEmpty()){
                                    years.setText(""+0);

                                }


                                if(days.getText().toString().isEmpty()){
                                    days.setText(""+0);

                                }




                                if(months.length()==0 ){
                                    months.setError("field Cannot Be Empty");
                                } else {
                                    float paisa_rs = Float.parseFloat(paisa.getText().toString());
                                    float ratee = Float.parseFloat(rate_m.getText().toString());
                                    int y = Integer.parseInt(years.getText().toString());
                                    int m = Integer.parseInt(months.getText().toString());
                                    int d = Integer.parseInt(days.getText().toString());


                                    float r = y/12+m+d/30;
                                    float answer=(paisa_rs*r*ratee)/100;
                                    result.setText("Rs " + answer);

                                }


                            }
                        });
                       break;


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });






    }
}
