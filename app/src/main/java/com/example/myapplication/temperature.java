package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.DelayQueue;

public class temperature extends AppCompatActivity {

    private Spinner sp;
    private TextView to_temp;
     private   EditText from_temp;
    private TextView cc;
    private Button b1;

    ArrayAdapter<String> adapter;


    String list_temp[]={"Celsius to Fahrenheit","Fahrenheit to Celsius" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        sp=(Spinner) findViewById(R.id.janak);
        from_temp=(EditText)findViewById(R.id.numtemp);
        cc=(TextView)findViewById(R.id.c);
        to_temp=(TextView) findViewById(R.id.f);
        b1 =(Button) findViewById(R.id.Next_convert);


        adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,list_temp);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);





        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {

                switch (i){

                    case 0:
                        cc.setText("°C");
                        to_temp.setText("000 °F");
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                if(from_temp.length()==0)
                                   {
                                    from_temp.setError("Field cannot be empty");
                                   }
                                else  {
                                 Toast.makeText(temperature.this, "Converting", Toast.LENGTH_SHORT).show();
                                 float fig =    Float.parseFloat(from_temp.getText().toString());
                                 to_temp.setText( fig*1.8+32 + "°F");

                                }

                  };

            });


                           break;


                    case 1:
                        cc.setText("°F");
                        to_temp.setText("000 °C");
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                if(from_temp.length()==0)
                                {
                                    from_temp.setError("Field cannot be empty");
                                }
                                else  {
                                    Toast.makeText(temperature.this, "Converting", Toast.LENGTH_SHORT).show();
                                    float fig =    Float.parseFloat(from_temp.getText().toString());
                                    to_temp.setText( fig-32/1.8 + "°C");

                                }

                            };

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
