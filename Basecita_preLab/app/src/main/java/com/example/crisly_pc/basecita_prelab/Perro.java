package com.example.crisly_pc.basecita_prelab;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Parcel;
import android.widget.Toast;

/**
 * Created by Crisly-PC on 27/04/2017.
 */

public class Perro extends Animal {
    public String cola;
    public String ocico;

    public Perro(String nombre, String edad, String peso, String cola, String ocico) {
        super(nombre, edad, peso);
        this.cola = cola;
        this.ocico = ocico;
    }

    public Perro(Parcel in, String cola, String ocico) {
        super(in);
        this.cola = cola;
        this.ocico = ocico;
    }



    public long insertarPerro(Context context) {

        // inserta el animal antes  antes del perro
        long newRowId = super.insertar(context);

        if (newRowId > 0) {

            // usar la clase DataBaseHelper para realizar la operacion de insertar
            DataBaseHelper dataBaseHelper = new DataBaseHelper(context);

            // Obtiene la base de datos en modo escritura
            SQLiteDatabase db = dataBaseHelper.getWritableDatabase();

            // Crear un mapa de valores donde las columnas son las llaves
            ContentValues values = new ContentValues();
            values.put(DataBaseContactData.DataBaseEntry._ID, getIdentificacion());
            values.put(DataBaseContactData.DataBaseEntry.cola, getCola());
            values.put(DataBaseContactData.DataBaseEntry.ocico, getOcico());

            // Insertar la nueva fila
            newRowId = db.insert(DataBaseContactData.DataBaseEntry.entidadPerro, null, values);
            Toast.makeText(context,"creado",Toast.LENGTH_SHORT).show();
        }
        return newRowId;
    }


    public String getCola() {
        return cola;
    }

    public String getOcico() {
        return ocico;
    }

}
