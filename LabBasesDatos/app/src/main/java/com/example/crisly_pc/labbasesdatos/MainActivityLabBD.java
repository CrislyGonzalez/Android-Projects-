package com.example.crisly_pc.labbasesdatos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivityLabBD extends AppCompatActivity {


    Button buttonDataBaseInser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lab_bd);

        /*
        // Instanciar los botones del layout activity_main.xml
        buttonDataBaseInser = (Button)  findViewById(R.id.buttonDataBaseInsert);
        buttonDataBaseInser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertarPlato();
            }
        });

        */

    }

    private void insertarPlato() {

        Plato p = new Plato("502", "Arroz con pollo ", "Mezcla de vegetales ", "5000");
        long newRowId = p.insertarPlato(getApplicationContext());
        Toast.makeText(getApplicationContext(),
                "\nCódigo: " + p.getCodigoPlato() + "\nNombre: " +
                        p.getNombrePlato() +
                        "\nDescripcion: " + p.getDescripción() + "\nPrecio: " + p.getPrecio(), Toast.LENGTH_LONG).show();
    }
}
