package com.example.capitales;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;

public class Modo extends AppCompatActivity {


    private TextView modos;
    private Button botonCapitales;
    private Button botonBanderas;
    private Button botonLocalizacion;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modo);


        modos = findViewById(R.id.modos);
        botonCapitales = findViewById(R.id.botonCapitales);
        botonBanderas = findViewById(R.id.botonBanderas);
        botonLocalizacion = findViewById(R.id.botonLocalizacion);

    }
}