package com.example.crisly_pc.basecita_prelab;

import android.provider.BaseColumns;

/**
 * Created by Crisly-PC on 27/04/2017.
 */

public class DataBaseContactData {

    private static final String COMMA_SEP = ",";


    public static class DataBaseEntry implements BaseColumns {
        public static final String entidadAnimal = "Animal";
        public static final String entidadPerro = "Perro";
        public static final String entidadAbeja = "Abeja";

        //atributos de Animal
        public static final String nombre = "";
        public static final String edad = "";
        public static final String peso = "";

        //atributos de perro
        public static final String cola = "";
        public static final String ocico = "";

        //atributos de abeja
        public static final String patas = "";
        public static final String tipo = "";

    }

    public static final String CreateTableAnimal = "CREATE TABLE " + DataBaseEntry. entidadAnimal + " (" +
            DataBaseEntry._ID + "text"+ "PRIMARY KEY," +
            DataBaseEntry.nombre +"text" +COMMA_SEP +
            DataBaseEntry.edad + "text" +COMMA_SEP +
            DataBaseEntry.peso + " )";


    public static final String CreateTablePerro = "CREATE TABLE " + DataBaseEntry.entidadPerro +
            " (" +  DataBaseEntry._ID  + "PRIMARY KEY," +
                    DataBaseEntry.cola + DataBaseEntry.ocico + ") REFERENCES " +
                    DataBaseEntry.entidadAnimal + "(" + DataBaseEntry._ID +  "))";


    public static final String CreateTableAbeja =
            "CREATE TABLE " + DataBaseEntry.entidadAbeja + " (" +  DataBaseEntry._ID  + "PRIMARY KEY," +
            DataBaseEntry.patas + DataBaseEntry.tipo + ") REFERENCES " +
            DataBaseEntry.entidadAnimal + "(" + DataBaseEntry._ID +  "))";




}// final de la clase
