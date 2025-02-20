/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jakarkaeeudbl.bienvenue.beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

/**
 *
 * @author MIKE KIBWE
 */
@Named("WelcomeBean")
@RequestScoped

public class WelcomeBean {
    private String nom;
    private String message;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void afficherMessage()
    {
        if (nom != null && !nom.trim().isEmpty()) {
            message = "Selamat dating, " + nom + "!";
        } else {
            message = "";
        } 
    }
    

}
