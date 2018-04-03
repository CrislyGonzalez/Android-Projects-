package com.example.crisly_pc.labbasesdatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Crisly-PC on 28/04/2017.
 */

public class Insumo implements Parcelable {
    private String codigoInsumo;
    private String nombreInsumo;
    private String cantidadInsumo;
    private String unidadMedidaInsumo;

    //constructor
    public Insumo(String codigoInsumo, String nombreInsumo, String cantidadInsumo, String unidadMedidaInsumo) {
        this.codigoInsumo = codigoInsumo;
        this.nombreInsumo = nombreInsumo;
        this.cantidadInsumo = cantidadInsumo;
        this.unidadMedidaInsumo = unidadMedidaInsumo;
    }

    //metodo get clase


    public String getCodigoInsumo() {
        return codigoInsumo;
    }

    public String getNombreInsumo() {
        return nombreInsumo;
    }

    public String getCantidadInsumo() {
        return cantidadInsumo;
    }

    public String getUnidadMedidaInsumo() {
        return unidadMedidaInsumo;
    }



    //Metodos de clase extendida
    protected Insumo(Parcel in) {
        codigoInsumo = in.readString();
        nombreInsumo = in.readString();
        cantidadInsumo = in.readString();
        unidadMedidaInsumo = in.readString();
    }

    public static final Creator<Insumo> CREATOR = new Creator<Insumo>() {
        @Override
        public Insumo createFromParcel(Parcel in) {
            return new Insumo(in);
        }

        @Override
        public Insumo[] newArray(int size) {
            return new Insumo[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    public static Creator<Insumo> getCREATOR() {
        return CREATOR;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(codigoInsumo);
        parcel.writeString(nombreInsumo);
        parcel.writeString(cantidadInsumo);
        parcel.writeString(unidadMedidaInsumo);
    }



    public long insertarInsumo(Context context) {
        // usar la clase DataBaseHelper para realizar la operacion de insertar
        DataBaseHelper dataBaseHelper = new DataBaseHelper(context);

        // Obtiene la base de datos en modo escritura
        SQLiteDatabase db = dataBaseHelper.getWritableDatabase();

        // Crear un mapa de valores donde las columnas son las llaves
        ContentValues values = new ContentValues();
        values.put(BDFormat.DataBaseEntry.codigoInsumo, getCodigoInsumo());
        values.put(BDFormat.DataBaseEntry.nombreInsumo, getNombreInsumo());
        values.put(BDFormat.DataBaseEntry.cantidadInsumo, getCantidadInsumo());
        values.put(BDFormat.DataBaseEntry.unidadMedidaInsumo, getUnidadMedidaInsumo());

        // Insertar la nueva fila
        return db.insert(BDFormat.DataBaseEntry.entidadInsumo, null, values);

    }


}
