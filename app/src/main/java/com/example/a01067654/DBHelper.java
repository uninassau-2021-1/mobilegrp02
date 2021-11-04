package com.example.a01067654;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static int versao = 1;
    private static String nome = "LoginBasedados.db";

    public DBHelper(Context context){
        super(context,nome,null,versao);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String str = "CREATE TABLE acesso1 (idusuario INT usuario TEXT PRIMARY KEY, senha TEXT);";
        db.execSQL(str);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS acesso1;");
        onCreate(db);

    }

    public long CriarUtilizador(String usuario, String senha){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("usuario", usuario);
        cv.put("senha",senha);
        long result = db.insert("acesso1",null,cv);
        return 0;
    }
    public String ValidarLogin(String usuario, String senha){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM acesso1 WHERE usuario=? AND senha=?", new String[]{usuario,senha});
        if (c.getCount() > 0){
            return "Ok";
        }
        return "ERRO";
    }
}
