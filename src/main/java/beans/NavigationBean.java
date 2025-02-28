/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import jakarta.faces.context.FacesContext;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.io.IOException;

/**
 *
 * @author Munung
 */
@Named("NavigationBean")
@RequestScoped
public class NavigationBean { 
    
    public void redirection(String url) {
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("pages/a_propos.xhtml");
        
        }catch(IOException e){
            e.printStackTrace();
        
        }
    }
    
    public void ajouterLieu(){
    redirection("pages/lieu.xhtml"); }
    
    public void voirApropos(){
        
        redirection("pages/a_propos.xhtml");
    
    }
    public void voirVisiter(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("pages/visite.xhtml");
        
        }catch(IOException e){
            e.printStackTrace();
        
        }
    
    
    }
    public void voirAjouter(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("pages/lieu.xhtml");
        
        }catch(IOException e){
            e.printStackTrace();
        
        }
    
    
    }
      
}
