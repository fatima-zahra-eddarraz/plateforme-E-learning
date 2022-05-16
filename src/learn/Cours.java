/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package learn;

public abstract class Cours {
        int idCours;
	String libelle;
	String description;
        String dateCreation;
	public abstract void creationCours(String n,String m);
        	public abstract void NotifyStudent(String n);

    public Cours(String Libelle, String Description, String DateCreation) {
        this.libelle = Libelle;
        this.description = Description;
        this.dateCreation = DateCreation;
    }
    public Cours(String Libelle, String Description) {
        this.libelle = Libelle;
        this.description = Description;
    }

    public int getIdCours() {
        return idCours;
    }

    public void setIdCours(int idCours) {
        this.idCours = idCours;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    
  
    
   

}
