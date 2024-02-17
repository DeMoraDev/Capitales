package com.example.Capitales;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.capitales.R;

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

    String[] paises = {
            "Afganistán", "Albania", "Alemania", "Andorra", "Angola", "Antigua y Barbuda", "Arabia Saudita", "Argelia", "Argentina", "Armenia",
            "Australia", "Austria", "Azerbaiyán", "Bahamas", "Bangladés", "Barbados", "Baréin", "Bélgica", "Belice", "Benín",
            "Bielorrusia", "Bolivia", "Bosnia y Herzegovina", "Botsuana", "Brasil", "Brunéi", "Bulgaria", "Burkina Faso", "Burundi", "Bután",
            "Cabo Verde", "Camboya", "Camerún", "Canadá", "Catar", "Chad", "Chile", "China", "Chipre", "Colombia",
            "Comoras", "Corea del Norte", "Corea del Sur", "Costa de Marfil", "Costa Rica", "Croacia", "Cuba", "Dinamarca", "Dominica",
            "Ecuador", "Egipto", "El Salvador", "Emiratos Árabes Unidos", "Eritrea", "Eslovaquia", "Eslovenia", "España", "Estados Unidos", "Estonia",
            "Etiopía", "Filipinas", "Finlandia", "Fiyi", "Francia", "Gabón", "Gambia", "Georgia", "Ghana", "Granada",
            "Grecia", "Guatemala", "Guinea", "Guinea-Bisáu", "Guinea Ecuatorial", "Guyana", "Haití", "Honduras", "Hungría", "India",
            "Indonesia", "Irak", "Irán", "Irlanda", "Islandia", "Islas Marshall", "Islas Salomón", "Israel", "Italia", "Jamaica",
            "Japón", "Jordania", "Kazajistán", "Kenia", "Kirguistán", "Kiribati", "Kuwait", "Laos", "Lesoto", "Letonia",
            "Líbano", "Liberia", "Libia", "Liechtenstein", "Lituania", "Luxemburgo", "Macedonia del Norte", "Madagascar", "Malasia", "Malaui",
            "Maldivas", "Malí", "Malta", "Marruecos", "Mauricio", "Mauritania", "México", "Micronesia", "Moldavia", "Mónaco",
            "Mongolia", "Montenegro", "Mozambique", "Namibia", "Nauru", "Nepal", "Nicaragua", "Níger", "Nigeria", "Noruega",
            "Nueva Zelanda", "Omán", "Países Bajos", "Pakistán", "Palaos", "Panamá", "Papúa Nueva Guinea", "Paraguay", "Perú",
            "Polonia", "Portugal", "Reino Unido", "República Centroafricana", "República Checa", "República del Congo", "República Democrática del Congo", "República Dominicana", "Ruanda", "Rumanía",
            "Rusia", "Samoa", "San Cristóbal y Nieves", "San Marino", "San Vicente y las Granadinas", "Santa Lucía", "Santo Tomé y Príncipe", "Senegal", "Serbia", "Seychelles",
            "Sierra Leona", "Singapur", "Siria", "Somalia", "Sri Lanka", "Suazilandia", "Sudáfrica", "Sudán", "Sudán del Sur", "Suecia",
            "Suiza", "Surinam", "Tailandia", "Tanzania", "Tayikistán", "Timor Oriental", "Togo", "Tonga", "Trinidad y Tobago", "Túnez",
            "Turkmenistán", "Turquía", "Tuvalu", "Ucrania", "Uganda", "Uruguay", "Uzbekistán", "Vanuatu", "Vaticano", "Venezuela",
            "Vietnam", "Yemen", "Yibuti", "Zambia", "Zimbabue"
    };

    // Array de capitales correspondientes a los países
    String[] capitales = {
            "Kabul", "Tirana", "Berlín", "Andorra la Vella", "Luanda", "Saint John's", "Riad", "Argel", "Buenos Aires", "Ereván",
            "Canberra", "Viena", "Bakú", "Nasáu", "Dhaka", "Bridgetown", "Manama", "Bruselas", "Belmopán", "Porto Novo",
            "Minsk", "Sucre", "Sarajevo", "Gaborone", "Brasilia", "Bandar Seri Begawan", "Sofía", "Uagadugú", "Buyumbura", "Timbu",
            "Praia", "Nom Pen", "Yaundé", "Ottawa", "Doha", "N'Djamena", "Santiago", "Pekín", "Nicosia", "Bogotá",
            "Moroni", "Pionyang", "Seúl", "Yamusukro", "San José", "Zagreb", "La Habana", "Copenhague", "Roseau",
            "Quito", "El Cairo", "San Salvador", "Abu Dabi", "Asmara", "Bratislava", "Liubliana", "Madrid", "Washington D.C.", "Tallin",
            "Adís Abeba", "Manila", "Helsinki", "Suva", "París", "Libreville", "Banjul", "Tiflis", "Accra", "Saint George's",
            "Atenas", "Guatemala", "Conakri", "Bisáu", "Malabo", "Georgetown", "Puerto Príncipe", "Tegucigalpa", "Budapest", "Nueva Delhi",
            "Yakarta", "Bagdad", "Teherán", "Dublín", "Reikiavik", "Majuro", "Honiara", "Jerusalén", "Roma", "Kingston",
            "Tokio", "Amán", "Nur-Sultán", "Nairobi", "Biskek", "Tarawa", "Kuwait", "Vientiane", "Maseru", "Riga",
            "Beirut", "Monrovia", "Trípoli", "Vaduz", "Vilna", "Luxemburgo", "Gitega", "Antananarivo", "Kuala Lumpur", "Lilongüe",
            "Malé", "Bamako", "La Valeta", "Rabat", "Port Louis", "Nuakchot", "Ciudad de México", "Palikir", "Chisináu", "Mónaco",
            "Ulán Bator", "Podgorica", "Maputo", "Windhoek", "Yaren", "Katmandú", "Managua", "Niamey", "Abuya", "Oslo",
            "Wellington", "Mascate", "Ámsterdam", "Islamabad", "Melekeok", "Ciudad de Panamá", "Port Moresby", "Asunción", "Lima",
            "Varsovia", "Lisboa", "Londres", "Bangui", "Praga", "Brazzaville", "Kinshasa", "Santo Domingo", "Kigali", "Bucarest",
            "Moscú", "Apia", "Basseterre", "San Marino", "Kingstown", "Castries", "Santo Tomé", "Dakar", "Belgrado", "Victoria",
            "Freetown", "Singapur", "Damasco", "Mogadiscio", "Colombo", "Mbabane", "Pretoria", "Jartum", "Yuba", "Estocolmo",
            "Berna", "Paramaribo", "Bangkok", "Dodoma", "Dusambé", "Dili", "Lomé", "Nuku'alofa", "Puerto España", "Túnez",
            "Asjabad", "Ankara", "Funafuti", "Kiev", "Kampala", "Montevideo", "Taskent", "Port Vila", "Ciudad del Vaticano", "Caracas",
            "Hanói", "Saná", "Yibuti", "Lusaka", "Harare"
    };


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
        int indiceAleatorio = aleatorio.nextInt(paises.length);
        String paisBueno = paises[indiceAleatorio];
        String capitalBuena = capitales[indiceAleatorio];

        HashSet<Integer> libres = new HashSet<>();
        libres.add(indiceAleatorio);

        while (libres.size() < 4) {
            libres.add(aleatorio.nextInt(paises.length));
        }

        List<Integer> listaLibres = new ArrayList<>(libres);
        Collections.shuffle(listaLibres);

        pregunta.setText("¿Cuál es la capital de " + paisBueno + "?");

        respuesta1.setText(capitales[listaLibres.get(0)]);
        respuesta2.setText(capitales[listaLibres.get(1)]);
        respuesta3.setText(capitales[listaLibres.get(2)]);
        respuesta4.setText(capitales[listaLibres.get(3)]);

        respuesta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkeo(respuesta1,capitalBuena);
            }
        });

        respuesta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkeo(respuesta2,capitalBuena);
            }
        });

        respuesta3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkeo(respuesta3,capitalBuena);
            }
        });

        respuesta4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkeo(respuesta4,capitalBuena);
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

                if (respuesta1.getText().toString().equals(capitalBuena)){
                    respuesta1.setBackgroundColor(getResources().getColor(R.color.correcto));
                } else if (respuesta2.getText().toString().equals(capitalBuena)) {
                    respuesta2.setBackgroundColor(getResources().getColor(R.color.correcto));
                }else if (respuesta3.getText().toString().equals(capitalBuena)) {
                    respuesta3.setBackgroundColor(getResources().getColor(R.color.correcto));
                }else if (respuesta4.getText().toString().equals(capitalBuena)) {
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