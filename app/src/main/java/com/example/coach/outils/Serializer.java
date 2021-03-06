package com.example.coach.outils;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class Serializer {

    public static void serialize(String fileName, Object object, Context context){
        try {
            FileOutputStream fileOutputStream=context.openFileOutput(fileName,Context.MODE_PRIVATE);
            ObjectOutputStream objectOutputStream;

            try{
                objectOutputStream=new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(object);
                objectOutputStream.flush();
                objectOutputStream.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static  Object deSerialize(String fileName,Context context){
        try {
            FileInputStream fileInputStream=context.openFileInput(fileName);
            ObjectInputStream objectInputStream;
            try {
                objectInputStream=new ObjectInputStream(fileInputStream);
                try {
                    Object object=objectInputStream.readObject();
                    objectInputStream.close();
                    return object;
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
