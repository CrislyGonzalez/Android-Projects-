package com.example.crisly_pc.basecita_prelab;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Parcel;
import android.os.Parcelable;


public class Animal implements Parcelable {
    public String nombre;
    public String edad;
    public String identificacion;
    public String peso;

    public Animal(String nombre, String edad, String  peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
    }


    protected Animal(Parcel in) {
        nombre = in.readString();
        edad = in.readString();
        peso = in.readString();
    }


    //Metodo de Parceable
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nombre);
        parcel.writeString(edad);
        parcel.writeString(peso);
        parcel.writeString(identificacion);
    }

    public static final Creator<Animal> CREATOR = new Creator<Animal>() {
        @Override
        public Animal createFromParcel(Parcel in) {
            return new Animal(in);
        }

        @Override
        public Animal[] newArray(int size) {
            return new Animal[size];
        }
    };


    public String getIdentificacion() {
        return identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEdad() {
        return edad;
    }

    public String getPeso() {
        return peso;
    }


    // insertar una un Animal en la base de datos
    public long insertar(Context context) {

        // usar la clase DataBaseHelper para realizar la operacion de insertar
        DataBaseHelper dataBaseHelper = new DataBaseHelper(context);

        // Obtiene la base de datos en modo escritura
        SQLiteDatabase db = dataBaseHelper.getWritableDatabase();

        // Crear un mapa de valores donde las columnas son las llaves
        ContentValues values = new ContentValues();
        values.put(DataBaseContactData.DataBaseEntry._ID, getIdentificacion());
        values.put(String.valueOf(DataBaseContactData.DataBaseEntry.edad),getEdad());
        values.put(DataBaseContactData.DataBaseEntry.nombre, getNombre());
        values.put(String.valueOf(DataBaseContactData.DataBaseEntry.peso), getPeso());

        // Insertar la nueva fila
        return db.insert(DataBaseContactData.DataBaseEntry.entidadAnimal, null, values);

    }
}

