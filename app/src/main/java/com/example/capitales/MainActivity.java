package com.example.capitales;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView pregunta;
    private TextView mensaje;
    private TextView puntuacion;
    private Button respuesta1;
    private Button respuesta2;
    private Button respuesta3;
    private Button respuesta4;
    boolean clickado = false;
    public int contador = 0;
    private Handler mHandler = new Handler();

    List<Pais> ciudades = CiudadesUitls.fillCiudades();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pregunta = findViewById(R.id.pregunta);
        mensaje = findViewById(R.id.mensaje);
        puntuacion = findViewById(R.id.puntuacion);
        respuesta1 = findViewById(R.id.button);
        respuesta2 = findViewById(R.id.button2);
        respuesta3 = findViewById(R.id.button3);
        respuesta4 = findViewById(R.id.button4);

        initViews();
    }

    public void initViews() {
        puntuacion.setText("Aciertos: " + contador);

        Random aleatorio = new Random();
        String paisBueno = "";
        String capitalBuena = "";

        List<Pais> libres = new ArrayList<>();

        while (libres.size() < 4) {
            int i = aleatorio.nextInt(ciudades.size());
            //filtro
            if (ciudades.get(i).getContinente().equals("África")) {
                if (paisBueno.equals("")) {
                    paisBueno = ciudades.get(i).getNombre();
                    capitalBuena = ciudades.get(i).getCapital();
                }
                if (!libres.contains(ciudades.get(i)))
                    libres.add(ciudades.get(i));
            }
        }

        Collections.shuffle(libres);

        pregunta.setText("¿Cuál es la capital de " + paisBueno + "?");

        respuesta1.setText(libres.get(0).getCapital());
        respuesta2.setText(libres.get(1).getCapital());
        respuesta3.setText(libres.get(2).getCapital());
        respuesta4.setText(libres.get(3).getCapital());

        String finalCapitalBuena = capitalBuena;
        respuesta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkeo(respuesta1, finalCapitalBuena);
            }
        });

        respuesta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkeo(respuesta2, finalCapitalBuena);
            }
        });

        respuesta3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkeo(respuesta3, finalCapitalBuena);
            }
        });

        respuesta4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkeo(respuesta4, finalCapitalBuena);
            }
        });
    }

    void checkeo(TextView textView, String capitalBuena) {
        if (!clickado) {
            clickado = true;
            if (textView.getText().toString().equals(capitalBuena)) {
                textView.setBackgroundColor(getResources().getColor(R.color.correcto));
                mensaje.setTextColor(getResources().getColor(R.color.correcto));
                mensaje.setText("¡Correcto!");
                contador++;
            } else {
                textView.setBackgroundColor(getResources().getColor(R.color.incorrecto));
                mensaje.setTextColor(getResources().getColor(R.color.incorrecto));
                mensaje.setText("¡Incorrecto!");

                if (respuesta1.getText().toString().equals(capitalBuena)) {
                    respuesta1.setBackgroundColor(getResources().getColor(R.color.correcto));
                } else if (respuesta2.getText().toString().equals(capitalBuena)) {
                    respuesta2.setBackgroundColor(getResources().getColor(R.color.correcto));
                } else if (respuesta3.getText().toString().equals(capitalBuena)) {
                    respuesta3.setBackgroundColor(getResources().getColor(R.color.correcto));
                } else if (respuesta4.getText().toString().equals(capitalBuena)) {
                    respuesta4.setBackgroundColor(getResources().getColor(R.color.correcto));
                }
            }

            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    clickado = false;
                    respuesta1.setBackgroundColor(getResources().getColor(R.color.colorBoton));
                    respuesta2.setBackgroundColor(getResources().getColor(R.color.colorBoton));
                    respuesta3.setBackgroundColor(getResources().getColor(R.color.colorBoton));
                    respuesta4.setBackgroundColor(getResources().getColor(R.color.colorBoton));
                    mensaje.setText("");
                    initViews();
                }
            }, 2000);
        }
    }
}