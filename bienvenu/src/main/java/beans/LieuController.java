package beans;


import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("LieuController")
@SessionScoped
public class LieuController implements Serializable {
    private String nom;
    private String description;
    private String latitude;
    private String longitude;
    private List<Lieu> lieux = new ArrayList<>();

    // Getters et setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public List<Lieu> getLieux() {
        return lieux;
    }

    public void setLieux(List<Lieu> lieux) {
        this.lieux = lieux;
    }

    // Méthode pour ajouter un lieu
    public String ajouterLieu() {
        if (nom == null || nom.trim().isEmpty()) {
            return null; // Reste sur la même page
        }

        Lieu lieu = new Lieu(nom, description, latitude, longitude);
        lieux.add(lieu);

        // Réinitialiser les champs après l'ajout
        nom = "";
        description = "";
        latitude = "";
        longitude = "";

        return null; // Reste sur la même page
    }
}
