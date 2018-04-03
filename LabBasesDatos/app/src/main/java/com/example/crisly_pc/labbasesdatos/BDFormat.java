package com.example.crisly_pc.labbasesdatos;

import android.provider.BaseColumns;

public class BDFormat {

    private static final String COMMA_SEP = ",";


    public static class DataBaseEntry implements BaseColumns {
        public static final String entidadOrden = "Orden";
        public static final String entidadPlato = "Plato";
        public static final String entidadInsumo = "Insumo";
        public static final String entidadInsumoPlato = "InsumoPlato";


        //atributos de orden
        public static final String codigoOrden = "";
        public static final String codigoPlatoO= "";
        public static final String fecha = "";
        public static final String hora = "";
        public static final String comentario = "";

        //atributos de Plato
        public static final String codigoPlato= "";
        public static final String nombrePlato = "";
        public static final String descripcion = "";
        public static final String precio = "";

        //atributos de Insumo
        public static final String codigoInsumo= "";
        public static final String nombreInsumo = "";
        public static final String cantidadInsumo = "";
        public static final String unidadMedidaInsumo = "";

        //atributos de InsumoPlato
        public static final String codigoInsumoR= "";
        public static final String codigoPlatoR= "";

    }


    public static final String CreateTablePlato = "CREATE TABLE " + DataBaseEntry. entidadPlato + " (" +
            DataBaseEntry.codigoPlato + "text"+ "PRIMARY KEY," +
            DataBaseEntry.nombrePlato +"text" +COMMA_SEP +
            DataBaseEntry.descripcion + "text" +COMMA_SEP +
            DataBaseEntry.precio + "text" + " )";


    public static final String CreateTableOrden = "CREATE TABLE " + DataBaseEntry. entidadOrden + " (" +
            DataBaseEntry.codigoOrden + "text"+ "PRIMARY KEY," +
            DataBaseEntry.fecha +"text" +COMMA_SEP +
            DataBaseEntry.hora + "text" +COMMA_SEP +
            DataBaseEntry.comentario + "text" + "FOREIGN KEY(" + DataBaseEntry.codigoPlato + " ) + REFERENCES " +
            DataBaseEntry.entidadPlato + "(" + DataBaseEntry.codigoPlato +  "))";


    public static final String CreateTableInsumo = "CREATE TABLE " + DataBaseEntry. entidadInsumo + " (" +
            DataBaseEntry.codigoInsumo + "text"+ "PRIMARY KEY," +
            DataBaseEntry.nombreInsumo +"text" +COMMA_SEP +
            DataBaseEntry.cantidadInsumo + "text" +COMMA_SEP +
            DataBaseEntry.unidadMedidaInsumo + "text" + " )";


    public static final String CreateTableInsumoPlato = "CREATE TABLE " + DataBaseEntry. entidadInsumoPlato + " (" +
            "FOREIGN KEY(" + DataBaseEntry.codigoInsumoR +  "FOREIGN KEY(" + DataBaseEntry.codigoPlatoR+ " )";


}// final de la clase
