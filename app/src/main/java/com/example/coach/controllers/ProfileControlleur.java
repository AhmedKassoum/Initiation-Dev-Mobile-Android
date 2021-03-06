package com.example.coach.controllers;

import android.content.Context;

import com.example.coach.models.Profile;
import com.example.coach.outils.Serializer;

public final class ProfileControlleur {

    private static ProfileControlleur instance=null;
    private static Profile profile;
    private static String fineName="saveProfile";

    /**
     * Constructeur
     */
    private ProfileControlleur() {
        super();
    }

    /**
     * creation de l'instance
     * @return instance
     */
    public static final ProfileControlleur getInstance(Context context){ // Pattern Singleton
        if(ProfileControlleur.instance==null){
            ProfileControlleur.instance=new ProfileControlleur();
            getSerialize(context);
        }
        return ProfileControlleur.instance;
    }

    /**
     * creation du profile
     * @param poids
     * @param taille
     * @param age
     * @param sexe
     */
    public void createProfile(Integer poids, Integer taille, Integer age, Integer sexe, Context context){
        profile=new Profile(poids,taille,age,sexe);
        Serializer.serialize(fineName,profile,context);
    }

    /**
     * Recuperation de l'IMG du profile
     * @return
     */
    public float getIMG(){
        return profile.getImg();
    }

    /**
     * recuperation du texte d'indication du profile
     * @return
     */
    public String getIndication(){
        return profile.getIndication();
    }

    /**
     * recuperation de 'objet serialiser (profile)
     * @param context
     */
    private static void getSerialize(Context context){
        profile=(Profile) Serializer.deSerialize(fineName,context);
    }
    public  Integer getPoids(){
        if(profile==null){
            return null;
        }
        else {
            return profile.getPoids();
        }
    }

    public  Integer getAge(){
        if(profile==null){
            return null;
        }
        else {
            return profile.getAge();
        }
    }

    public  Integer getTaille(){
        if(profile==null){
            return null;
        }
        else {
            return profile.getTaille();
        }
    }

    public  Integer getSexe(){
        if(profile==null){
            return null;
        }
        else {
            return profile.getSexe();
        }
    }
}
