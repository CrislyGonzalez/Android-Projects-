package com.example.crisly_pc.basecita_prelab;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.Settings;


public class DataBaseHelper extends SQLiteOpenHelper {

    //incrementar la versión de la bd
    public static final int DATABASE_VERSION = 2;

   // Nombre de bd
   public static final String DATABASE_NAME = "Animal.db";


    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    //metodo de sqlite
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Crear la base de datos de la app
        System.out.println("\n\n\n\nJJAJAJAJ\n\n\n\n");
        //db.execSQL(DataBaseContactData.CreateTableAnimal);
        System.out.println("\n\n\n\nASDFASDFASDFASDF\n\n\n\n");
       // db.execSQL(DataBaseContactData.CreateTableAbeja);
        //db.execSQL(DataBaseContactData.CreateTablePerro);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        //segunda etapa
    }

}
