package com.example.a01067654;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE = "acesso";
    private static int versao = 1;

    public DBHelper(Context context){
        super(context,"acesso",null,versao);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String str = "CREATE TABLE acesso ( idusuario INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, usuario VARCHAR(10) NOT NULL DEFAULT(''), senha VARCHAR(20) NOT NULL DEFAULT(''));";
        db.execSQL(str);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS acesso;");
        onCreate(db);

    }

    public long CriarUtilizador(String usuario, String senha){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("usuario", usuario);
        cv.put("senha",senha);
        long result = db.insert("acesso",null,cv);
        return result;
    }
    public String ValidarLogin(String usuario, String senha){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM acesso WHERE usuario=? AND senha=?", new String[]{usuario,senha});
        if (c.getCount() > 0){
            return "Ok";
        }
        return "ERRO";
    }
}
