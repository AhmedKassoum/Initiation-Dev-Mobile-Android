package com.example.coach.views;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coach.R;
import com.example.coach.controllers.ProfileControlleur;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Initialisation();

    }

    private EditText editTextPoids;
    private EditText editTextTaille;
    private EditText editTextAge;
    private RadioButton radioButtonSexe;
    private RadioButton radioButtonFemme;
    private TextView textViewIMG;
    private ImageView imageView;
    private ProfileControlleur controlleur;

    /**
     * Initialisation des liens avec les objets
     */
    private void Initialisation(){
        editTextPoids=(EditText) findViewById(R.id.editTextNumberPoids);
        editTextTaille=(EditText) findViewById(R.id.editTextNumberTaille);
        editTextAge=(EditText) findViewById(R.id.editTextNumberAge);
        radioButtonSexe=(RadioButton)findViewById(R.id.radioButtonHomme);
        radioButtonFemme=(RadioButton)findViewById(R.id.radioButtonFemme);
        textViewIMG=(TextView)findViewById(R.id.textViewIMG);
        imageView=(ImageView)findViewById(R.id.imageView);

        this.controlleur=ProfileControlleur.getInstance(this);

        ecouteCalculHandler();
        getProfile();
    }

    /**
     * Gestion de l'evenement OnClick sur le boutton Calculer
     */
    private void ecouteCalculHandler(){
        ((Button)findViewById(R.id.buttonCalculer)).setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {

                Integer poids=0;
                Integer taille=0;
                Integer age=0;
                Integer sexe=0;

                try {
                    poids=Integer.parseInt(editTextPoids.getText().toString());
                    taille=Integer.parseInt(editTextTaille.getText().toString());
                    age=Integer.parseInt(editTextAge.getText().toString());
                }
                catch (Exception exception){

                }

                if(radioButtonSexe.isChecked()){
                    sexe=1;
                }

                if(poids==0 || taille==0 || age==0 ){
                    Toast.makeText(MainActivity.this,"Saisie incorrecte",Toast.LENGTH_SHORT).show();
                }
                else {
                    afficheResult(poids,taille,age,sexe);
                }
            }
        });
    }

    private void afficheResult(Integer poids, Integer taille, Integer age, Integer sexe) {
        this.controlleur.createProfile(poids,taille,age,sexe,this);
        float img=this.controlleur.getIMG();
        String indication=this.controlleur.getIndication();

        if(indication=="Normal"){
            imageView.setImageResource(R.drawable.normal);
            textViewIMG.setTextColor(Color.GREEN);
        }
        else if (indication=="Trop faible"){
            textViewIMG.setTextColor(Color.RED);
            imageView.setImageResource(R.drawable.maigre);
        }
        else {
            imageView.setImageResource(R.drawable.grosse);
        }

        textViewIMG.setText(String.format("%.01f",img)+" IMG "+indication);

    }

    /**
     * Recuperation du profile par serialisation
     */
    private void getProfile(){
        if (controlleur.getPoids()!=null){
            editTextPoids.setText(controlleur.getPoids().toString());
            editTextAge.setText(controlleur.getAge().toString());
            editTextTaille.setText(controlleur.getTaille().toString());
            radioButtonFemme.setChecked(true);

            if (controlleur.getSexe()==1){
                radioButtonSexe.setChecked(true);
            }
            ((Button)findViewById(R.id.buttonCalculer)).performClick(); // Simule le click sur le boutton Calculer
        }
    }
}