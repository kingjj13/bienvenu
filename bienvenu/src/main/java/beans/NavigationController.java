package beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named("NavigationController") // Nom utilisé dans les pages JSF
@RequestScoped
public class NavigationController {
    
    public String ajouter() {
        return "ajouter.xhtml?faces-redirect=true";
    }

    public String voirHome() {
        return "home.xhtml"; // Redirige vers home.xhtml
    }

    public String voirApropos() {
        return "a_propos.xhtml"; // Redirige vers a_propos.xhtml
    }
}
