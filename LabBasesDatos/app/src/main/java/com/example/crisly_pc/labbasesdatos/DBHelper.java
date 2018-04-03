package com.example.crisly_pc.labbasesdatos;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Crisly-PC on 28/04/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    //incrementar la versión de la bd
    public static final int DATABASE_VERSION = 2;

    // Nombre de bd
    public static final String DATABASE_NAME = "moviles.db";


    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(BDFormat.CreateTablePlato);
        sqLiteDatabase.execSQL(BDFormat.CreateTableOrden);
        sqLiteDatabase.execSQL(BDFormat.CreateTableInsumo);
        sqLiteDatabase.execSQL(BDFormat.CreateTableInsumoPlato);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
