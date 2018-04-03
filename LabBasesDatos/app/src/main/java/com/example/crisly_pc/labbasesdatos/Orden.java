package com.example.crisly_pc.labbasesdatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Crisly-PC on 28/04/2017.
 */

public class Orden implements Parcelable{

    //Atributos
    private String codigoOrden;
    private String codigoPlato; // (llave foranea de Plato)
    private String fecha;
    private String hora;
    private String comentario;


    //Constructor
    public Orden(String codigoOrden, String códigoPlato, String fecha, String hora, String comentario) {
        this.codigoOrden = codigoOrden;
        this.codigoPlato = códigoPlato;
        this.fecha = fecha;
        this.hora = hora;
        this.comentario = comentario;
    }


    //Metodos de la clase Parcelable
    protected Orden(Parcel in) {
        codigoOrden = in.readString();
        codigoPlato = in.readString();
        fecha = in.readString();
        hora = in.readString();
        comentario = in.readString();
    }

    public static final Creator<Orden> CREATOR = new Creator<Orden>() {
        @Override
        public Orden createFromParcel(Parcel in) {
            return new Orden(in);
        }

        @Override
        public Orden[] newArray(int size) {
            return new Orden[size];
        }
    };



    //Metodos get de la clase
    public String getCodigoOrden() {
        return codigoOrden;
    }

    public String getCodigoPlato() {
        return codigoPlato;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getComentario() {
        return comentario;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(codigoOrden);
        parcel.writeString(codigoPlato);
        parcel.writeString(fecha);
        parcel.writeString(hora);
        parcel.writeString(comentario);
    }


    public long insertarOrden(Context context) {
        // usar la clase DataBaseHelper para realizar la operacion de insertar
        DataBaseHelper dataBaseHelper = new DataBaseHelper(context);

        // Obtiene la base de datos en modo escritura
        SQLiteDatabase db = dataBaseHelper.getWritableDatabase();

        // Crear un mapa de valores donde las columnas son las llaves
        ContentValues values = new ContentValues();
        values.put(BDFormat.DataBaseEntry.codigoOrden, getCodigoOrden());
        values.put(BDFormat.DataBaseEntry.fecha, getFecha());
        values.put(BDFormat.DataBaseEntry.hora, getHora());
        values.put(BDFormat.DataBaseEntry.comentario, getComentario());
        values.put(BDFormat.DataBaseEntry.codigoPlatoO, getCodigoPlato());

        // Insertar la nueva fila
        return db.insert(BDFormat.DataBaseEntry.entidadOrden, null, values);

    }

}
