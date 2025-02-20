package com.jakarkaeeudbl.bienvenue.beans;

import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("lieuBean")
@SessionScoped
public class LieuBean implements Serializable {
    private int idLieu = 0; // Ajout d'un ID pour la modification
    private String nom;
    private String description;
    private double latitude;
    private double longitude;
    private List<Lieu> listeLieux = new ArrayList<>();
    private int nextId = 1; // ID auto-incrémenté pour simuler une base de données

    // Ajouter ou Modifier un lieu
    public void enregistrerLieu() {
        if (idLieu == 0) {
            // Ajout d'un nouveau lieu
            Lieu lieu = new Lieu(nom, description, latitude, longitude);
            listeLieux.add(lieu);
        } else {
            // Modification d'un lieu existant
            for (Lieu lieu : listeLieux) {
                if (lieu.getId() == idLieu) {
                    lieu.setNom(nom);
                    lieu.setDescription(description);
                    lieu.setLatitude(latitude);
                    lieu.setLongitude(longitude);
                    break;
                }
            }
        }
        resetForm();
    }

    // Supprimer un lieu
    public void supprimerLieu(int id) {
        listeLieux.removeIf(lieu -> lieu.getId() == id);
    }

    // Préparer la modification d'un lieu
    public void preparerModification(Lieu lieu) {
        this.idLieu = lieu.getId();
        this.nom = lieu.getNom();
        this.description = lieu.getDescription();
        this.latitude = lieu.getLatitude();
        this.longitude = lieu.getLongitude();
    }

    // Réinitialiser le formulaire
    private void resetForm() {
        this.idLieu = 0;
        this.nom = "";
        this.description = "";
        this.latitude = 0;
        this.longitude = 0;
    }

    // Getters et Setters
    public int getIdLieu() { return idLieu; }
    public void setIdLieu(int idLieu) { this.idLieu = idLieu; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    public List<Lieu> getListeLieux() { return listeLieux; }
}
