package com.example.coach.outils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MySqlOpenHelper extends SQLiteOpenHelper {

    private String sqlRqt="create table Profile( "+
            "dateMesure TEXT PRIMARY KEY,"+
            "poids INTEGER NOT NULL,"+
            "taille INTEGER NOT NULL,"+
            "age INTEGER NOT NULL,"+
            "sexe INTEGER NOT NULL );";

    public MySqlOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     * Seulement en cas de changement de DataBase
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlRqt);
    }

    /**
     * Uniquement en cas de changement de version
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
