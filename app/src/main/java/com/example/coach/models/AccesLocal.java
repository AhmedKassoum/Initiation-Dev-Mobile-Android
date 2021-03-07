package com.example.coach.models;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.coach.outils.MySqlOpenHelper;

import java.util.Date;

public class AccesLocal {

    private String dBName="bdCoach.sqlite";
    private Integer dBVersion=1;
    private MySqlOpenHelper dAL;
    private SQLiteDatabase database;

    public AccesLocal(Context context){
        dAL=new MySqlOpenHelper(context,dBName,null,dBVersion);
    }

    public void Add(Profile profile){
        database=dAL.getWritableDatabase();
        String rqt="insert into Profile (dateMesure,poids,taille,age,sexe) values ";
        rqt +="(\""+profile.getDateMesure()+"\","+profile.getPoids()+","+profile.getTaille()+","+profile.getAge()+","+profile.getSexe()+");";
        database.execSQL(rqt);
    }

    public Profile getLastestProfile(){
        database=dAL.getReadableDatabase();
        Profile profile=null;
        String rqt="select *from Profile";
        Cursor cursor=database.rawQuery(rqt,null);
        cursor.moveToLast();
        if (!cursor.isAfterLast()){
            Date date=new Date();
            Integer poids=cursor.getInt(1);
            Integer taille=cursor.getInt(2);
            Integer age=cursor.getInt(3);
            Integer sexe=cursor.getInt(4);
            profile=new Profile(poids,taille,age,sexe,date);

        }
        cursor.close();
        return profile;
    }
}
