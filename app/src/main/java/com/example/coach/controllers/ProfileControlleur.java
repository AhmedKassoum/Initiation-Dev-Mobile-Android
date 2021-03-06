package com.example.coach.controllers;

import com.example.coach.models.Profile;

public final class ProfileControlleur {

    private static ProfileControlleur instance=null;
    private Profile profile;

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
    public static final ProfileControlleur getInstance(){ // Pattern Singleton
        if(ProfileControlleur.instance==null){
            ProfileControlleur.instance=new ProfileControlleur();
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
    public void createProfile(Integer poids,Integer taille,Integer age,Integer sexe){
        profile=new Profile(poids,taille,age,sexe);
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
}
