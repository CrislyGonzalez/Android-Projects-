package com.example.crisly_pc.basecita_prelab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivityBasecitaPreLab extends AppCompatActivity {


    Button buttonDataBaseInser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_basecita_pre_lab);

        // Instanciar los botones del layout activity_main.xml
        buttonDataBaseInser = (Button)  findViewById(R.id.buttonDataBaseInsert);
        buttonDataBaseInser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertarPerroMainData();
            }
        });

    }

    private void insertarPerroMainData() {
        // Instancia la clase Perro y realiza la inserción de datos
        Perro p = new Perro("loki", "5", "5", "si", "corto");

        // inserta el Perro, se le pasa como parametro el contexto de la app
        long newRowId = p.insertarPerro(getApplicationContext());

        // Mostrar un mensaje para el usuario
        Toast.makeText(getApplicationContext(),
                "\nNombre: " + p.getNombre() + "\nedad: " +
                p.getEdad() +
                "\nTiene Cola: " + p.getCola() + "\nTiene Ocico: " + p.getOcico() +
                "\nPeso: " + p.getPeso(), Toast.LENGTH_LONG).show();
    }

}
