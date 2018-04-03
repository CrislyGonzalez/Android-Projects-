package com.example.crisly_pc.labbasesdatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Crisly-PC on 28/04/2017.
 */

public class InsumoPlato implements Parcelable {
    private String codigoInsumo; // (llave foranea de Insumo)
    private String codigoPlato; //(llave foranea de Plato)

    //constructor
    public InsumoPlato(String codigoInsumo, String codigoPlato) {
        this.codigoInsumo = codigoInsumo;
        this.codigoPlato = codigoPlato;
    }

    //metodos get de InsumoPlato
    public String getCodigoInsumo() {
        return codigoInsumo;
    }

    public String getCodigoPlato() {
        return codigoPlato;
    }


    //Metodos de la clase Insumo
    protected InsumoPlato(Parcel in) {
        codigoInsumo = in.readString();
        codigoPlato = in.readString();
    }

    public static Creator<InsumoPlato> getCREATOR() {
        return CREATOR;
    }

    public static final Creator<InsumoPlato> CREATOR = new Creator<InsumoPlato>() {
        @Override
        public InsumoPlato createFromParcel(Parcel in) {
            return new InsumoPlato(in);
        }

        @Override
        public InsumoPlato[] newArray(int size) {
            return new InsumoPlato[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(codigoInsumo);
        parcel.writeString(codigoPlato);
    }


    //insertar un insumoPlato

    public long insertarInsumoPlato(Context context) {

        DataBaseHelper dataBaseHelper = new DataBaseHelper(context);
        SQLiteDatabase db = dataBaseHelper.getWritableDatabase();

        // Crear un mapa de valores donde las columnas son las llaves
        ContentValues values = new ContentValues();
        values.put(BDFormat.DataBaseEntry.codigoInsumoR, getCodigoInsumo());
        values.put(BDFormat.DataBaseEntry.codigoPlatoR, getCodigoPlato());

        // Insertar la nueva fila
        return db.insert(BDFormat.DataBaseEntry.entidadInsumoPlato, null, values);

    }





}
