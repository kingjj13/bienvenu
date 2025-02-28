/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import business.VisiteEntrepriseBean;
import entities.Visite;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import static java.time.temporal.TemporalQueries.zoneId;
import java.util.Date;

/**
 *
 * @author Munung
 */
@Named(value = "formulaireVisiteBean")
@SessionScoped
public class visiteBean implements Serializable {
    private Long idUtilisateur;
    private Long idLieu;
    private LocalDateTime dateVisite;
    private int tempsPasse;
    private String observations;
    private double depenses;
    private boolean afficherFormulaireVisite;

    @Inject
    private VisiteEntrepriseBean visiteEntrepriseBean;

    public void afficherFormulaireVisite() {
        afficherFormulaireVisite = true;
    }

    public void sauvegarderVisite() {
        try {
            Visite visite = new Visite();
            visite.setIdUtilisateur(idUtilisateur.intValue()); // Conversion explicite
            visite.setIdLieu(idLieu.intValue()); // Conversion explicite
            visite.setDateVisite(dateVisite);
            visite.setTempsPasse(tempsPasse);
            visite.setObservations(observations);
            visite.setDepenses(depenses);

            // Ajout dans la base de données
            visiteEntrepriseBean.ajouterVisite(visite);

            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Visite enregistrée avec succès", null));

            afficherFormulaireVisite = false;
            resetForm();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur lors de l'enregistrement: " + e.getMessage(), null));
            e.printStackTrace();
        }
    }

    private void resetForm() {
        idLieu = null;
       
        dateVisite = LocalDateTime.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
        tempsPasse = 0;
        observations = "";
        depenses = 0.0;

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Formulaire réinitialisé"));
    }

    public boolean isAfficherFormulaireVisite() {
        return afficherFormulaireVisite;
    }

    public Long getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Long idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Long getIdLieu() {
        return idLieu;
    }

    public void setIdLieu(Long idLieu) {
        this.idLieu = idLieu;
    }

    public LocalDateTime getDateVisite() {
        return dateVisite;
    }

    public void setDateVisite(LocalDateTime dateVisite) {
        this.dateVisite = dateVisite;
    }

    public int getTempsPasse() {
        return tempsPasse;
    }

    public void setTempsPasse(int tempsPasse) {
        this.tempsPasse = tempsPasse;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public double getDepenses() {
        return depenses;
    }

    public void setDepenses(double depenses) {
        this.depenses = depenses;
    }
}
