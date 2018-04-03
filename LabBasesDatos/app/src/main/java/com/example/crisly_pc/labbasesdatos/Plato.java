package com.example.crisly_pc.labbasesdatos;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Parcel;
import android.os.Parcelable;

public class Plato implements Parcelable {

    private String codigoPlato;
    private String nombrePlato;
    private String descripción;
    private String precio;


    //Constructor
    public Plato(String codigoPlato, String nombrePlato, String descripción, String precio) {
        this.codigoPlato = codigoPlato;
        this.nombrePlato = nombrePlato;
        this.descripción = descripción;
        this.precio = precio;
    }



    //Metodos de la clase extendida
    protected Plato(Parcel in) {
        codigoPlato = in.readString();
        nombrePlato = in.readString();
        descripción = in.readString();
        precio = in.readString();
    }

    public static final Creator<Plato> CREATOR = new Creator<Plato>() {
        @Override
        public Plato createFromParcel(Parcel in) {
            return new Plato(in);
        }

        @Override
        public Plato[] newArray(int size) {
            return new Plato[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(codigoPlato);
        parcel.writeString(nombrePlato);
        parcel.writeString(descripción);
        parcel.writeString(precio);
    }


    //Get de la clase
    public String getCodigoPlato() {
        return codigoPlato;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public String getDescripción() {
        return descripción;
    }

    public String getPrecio() {
        return precio;
    }

    public long insertarPlato(Context context) {
        // usar la clase DataBaseHelper para realizar la operacion de insertar
        DataBaseHelper dataBaseHelper = new DataBaseHelper(context);

        // Obtiene la base de datos en modo escritura
        SQLiteDatabase db = dataBaseHelper.getWritableDatabase();

        // Crear un mapa de valores donde las columnas son las llaves
        ContentValues values = new ContentValues();
        values.put(BDFormat.DataBaseEntry.codigoPlato, getCodigoPlato());
        values.put(BDFormat.DataBaseEntry.nombrePlato, getNombrePlato());
        values.put(BDFormat.DataBaseEntry.descripcion, getDescripción());
        values.put(BDFormat.DataBaseEntry.precio, getPrecio());

        // Insertar la nueva fila
        return db.insert(BDFormat.DataBaseEntry.entidadPlato, null, values);

    }



}
