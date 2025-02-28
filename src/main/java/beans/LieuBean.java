package beans;

import business.LieuEntrepriseBean;
import entities.Lieu;
import entities.Visite; // Assurez-vous d'importer la classe Visite
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.AjaxBehaviorEvent;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Named("lieuBean")
@SessionScoped
public class LieuBean implements Serializable {
    private int idLieu = 0;
    private String nom;
    private String description;
    private double latitude;
    private double longitude;
    private String weatherMessage;
    private int selectedLieu;
    private Visite visite; // Assurez-vous que visite est du type Visite
    private Date dateVisiteInput = new Date(); // Initialiser avec une valeur par défaut

    public int getSelectedLieu() {
        return selectedLieu;
    }

    public void setSelectedLieu(int selectedLieu) {
        this.selectedLieu = selectedLieu;
    }

    public void sauvegarderVisite() {
        try {
            // Initialiser l'objet visite
            if (visite == null) {
                visite = new Visite();
            }

            // Vérifier si dateVisiteInput est null
            if (dateVisiteInput == null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "La date de visite est requise.", null));
                return;
            }

            // Convertir Date en LocalDateTime
            LocalDateTime dateVisite = dateVisiteInput.toInstant()
                                          .atZone(ZoneId.systemDefault())
                                          .toLocalDateTime();

            // Assurez-vous que visite est du type correct et que dateVisite est un LocalDateTime
            visite.setDateVisite(dateVisite);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Visite sauvegardée avec succès !"));
            // Logique de sauvegarde
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur lors de la sauvegarde de la visite: " + e.getMessage(), null));
            e.printStackTrace();
        }
    }

    @Inject
    private LieuEntrepriseBean lieuEntrepriseBean;

    // Récupérer la liste des lieux depuis la base de données
    public List<Lieu> getListeLieux() {
        return lieuEntrepriseBean.listerTousLesLieux();
    }

    // Ajouter ou Modifier un lieu
    public void enregistrerLieu() {
        if (idLieu == 0) {
            lieuEntrepriseBean.ajouterLieuEntreprise(nom, description, latitude, longitude);
        } else {
            lieuEntrepriseBean.modifierLieuEntreprise(idLieu, nom, description, latitude, longitude);
        }
        resetForm();
    }

    // Supprimer un lieu
    public void supprimerLieu(int id) {
        lieuEntrepriseBean.supprimerLieuEntreprise(id);
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

    public Date getDateVisiteInput() { return dateVisiteInput; }
    public void setDateVisiteInput(Date dateVisiteInput) { this.dateVisiteInput = dateVisiteInput; }

    public void fetchWeatherMessage(Lieu l) {
        if (l != null) {
            // Appel au service web pour obtenir les données météorologiques
            String serviceURL = "http://172.20.10.14:8080/j-weather/webapi/JarkartaWeather?latitude=" + l.getLatitude() + "&longitude=" + l.getLongitude();

            Client client = ClientBuilder.newClient();
            String response = client.target(serviceURL)
                    .request(MediaType.TEXT_PLAIN)
                    .get(String.class);

            // Enregistrement du message météo dans la variable weatherMessage
            this.weatherMessage = response;
        }
    }

    public void updateWeatherMessage(AjaxBehaviorEvent event) {
        Lieu lieu = lieuEntrepriseBean.trouverLieuParId(selectedLieu);
        this.fetchWeatherMessage(lieu);
    }

    public String getWeatherMessage() {
        return weatherMessage;
    }

    public void setWeatherMessage(String weatherMessage) {
        this.weatherMessage = weatherMessage;
    }
}
