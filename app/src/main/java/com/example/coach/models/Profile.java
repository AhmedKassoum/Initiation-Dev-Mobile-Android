package com.example.coach.models;

import java.io.Serializable;
import java.util.Date;

public class Profile implements Serializable {

    private Date dateMesure;
    private static final Integer minHomme=10;
    private static final Integer maxHomme=25;
    private static final Integer minFemme=15;
    private static final Integer maxFemme=30;

    private Integer poids;
    private Integer taille;
    private Integer age;
    private Integer sexe;
    private float img;
    private String indication;

    public Profile(Integer poids, Integer taille, Integer age, Integer sexe,Date dateMesure) {
        this.poids = poids;
        this.taille = taille;
        this.age = age;
        this.sexe = sexe;
        this.dateMesure=dateMesure;
        this.calculIMG();
        this.resultIMG();
    }

    public Integer getPoids() {
        return poids;
    }

    public Integer getTaille() {
        return taille;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getSexe() {
        return sexe;
    }

    public float getImg() {
        return img;
    }

    public String getIndication() {
        return indication;
    }

    public Date getDateMesure() {
        return dateMesure;
    }

    private void calculIMG(){
        float tailleM=((float)taille)/100;
        this.img=(float)((1.2*poids / (tailleM*tailleM)) +(0.23*age) - (10.83*sexe) - 5.4);
    }

    private void resultIMG(){
        Integer min;
        Integer max;

        if(sexe==0){
            min=minFemme;
            max=maxFemme;
        }
        else {
            min=minHomme;
            max=maxHomme;
        }

        indication="Normal";

        if(img<min){
            indication="Trop faible";
        }
        else {
            if(img>max){
                indication="Trop gros";
            }
        }
    }
}
