package com.example.crisly_pc.labbasesdatos;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import static android.R.attr.version;

/**
 * Created by Crisly-PC on 28/04/2017.
 */

public class DataBaseHelper extends SQLiteOpenHelper{

    //incrementar la versión de la bd
    public static final int DATABASE_VERSION = 2;

    // Nombre de bd
    public static final String DATABASE_NAME = "moviles.db";


    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Crear la base de datos de la app
        sqLiteDatabase.execSQL(BDFormat.CreateTablePlato);
        sqLiteDatabase.execSQL(BDFormat.CreateTableOrden);
        sqLiteDatabase.execSQL(BDFormat.CreateTableInsumo);
        sqLiteDatabase.execSQL(BDFormat.CreateTableInsumoPlato);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
