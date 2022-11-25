package com.example.cartest.cars;

import java.util.Date;

public class Car {

    String marque;
    String modele;
    String miseEnCirculation;
    String kilometrage;

    public Car(String marque, String modele, String miseEnCirculation, String kilometrage) {
        this.marque = marque;
        this.modele = modele;
        this.miseEnCirculation = miseEnCirculation;
        this.kilometrage = kilometrage;
    }

    public Car() {
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getMiseEnCirculation() {
        return miseEnCirculation;
    }

    public void setMiseEnCirculation(String miseEnCirculation) {
        this.miseEnCirculation = miseEnCirculation;
    }

    public String getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(String kilometrage) {
        this.kilometrage = kilometrage;
    }
}
