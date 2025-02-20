package com.jakarkaeeudbl.bienvenue.beans;

public class Lieu {
    private int id;
    private String nom;
    private String description;
    private double longitude;
    private double latitude;

    public Lieu(String nom, String description, double longitude, double latitude) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }
}
