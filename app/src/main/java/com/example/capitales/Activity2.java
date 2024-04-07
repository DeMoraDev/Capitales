package com.example.capitales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity2 extends AppCompatActivity {

    private Button botonJugar;
    private Button botonModo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);


        botonJugar = findViewById(R.id.botonJugar);
        botonModo = findViewById(R.id.botonModo);

        botonModo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para iniciar MainActivity
                Intent intent = new Intent(Activity2.this, Modo.class);
                // Iniciar MainActivity
                startActivity(intent);
            }
        });
        botonJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para iniciar MainActivity
                Intent intent = new Intent(Activity2.this, MainActivity.class);
                // Iniciar MainActivity
                startActivity(intent);
            }
        });
    }
}