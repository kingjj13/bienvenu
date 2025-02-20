package com.jakarkaeeudbl.bienvenue.beans;  // Vérifie que le package correspond bien

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import java.io.IOException;

@Named("navigationController")  // Equivalent de @ManagedBean
@RequestScoped  // Scope de la requête
public class NavigationController {

    public String ajouter() {
        return "lieu";  // Assure-toi que lieu.xhtml existe bien
    }

    public String visiter() {
        return "visiter";
    }

    public String voirApropos() {
        return "a_propos";
    }
   
}
