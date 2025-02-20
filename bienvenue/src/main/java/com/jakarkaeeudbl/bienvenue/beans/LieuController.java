/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jakarkaeeudbl.bienvenue.beans;

/**
 *
 * @author MIKE KIBWE
 */
public class LieuController {
    private String nom;
    private String description;
    private double latitude;
    private double longitude;

    public String ajouterLieu() {
        System.out.println("Lieu ajouté : " + nom + ", " + description + " [" + latitude + ", " + longitude + "]");
        return "home";  // Redirige vers la page d'accueil après l'ajout
    }

    // Getters et Setters
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

}
