package fr.cda.modele;

import java.time.LocalDate;

public class Media {
    private String identificateur;
    private String categorie;
    private String sousCategorie;
    private String description;
    //Peuvent être null :
    private Emprunteur emprunteur;
    private LocalDate dateEmprunt;

    public Media(String identificateur, String categorie, String sousCategorie, String description, Emprunteur emprunteur, LocalDate dateEmprunt) {
        this.identificateur = identificateur;
        this.categorie = categorie;
        this.sousCategorie = sousCategorie;
        this.description = description;
        this.emprunteur = emprunteur;
        this.dateEmprunt = dateEmprunt;
    }

    public Media(String identificateur, String categorie, String sousCategorie, String description) {
        this.identificateur = identificateur;
        this.categorie = categorie;
        this.sousCategorie = sousCategorie;
        this.description = description;
    }

    public Media(String identificateur) {
        this.identificateur = identificateur;
    }

    public enum categorie {LIVRE, DVD, CD, JEU};

    //Méthode utilisée par indexOf qui teste si deux médias sont identiques
    //deux médias sont identiques si ils ont le même identifiants.
    public boolean equals(Object o){
        Media m = (Media) o;
        return m.identificateur.equals(this.identificateur);
    }

    public String getIdentificateur() {
        return identificateur;
    }

    public void setIdentificateur(String identificateur) {
        this.identificateur = identificateur;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getSousCategorie() {
        return sousCategorie;
    }

    public void setSousCategorie(String sousCategorie) {
        this.sousCategorie = sousCategorie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Emprunteur getEmprunteur() {
        return emprunteur;
    }

    public void setEmprunteur(Emprunteur emprunteur) {
        this.emprunteur = emprunteur;
    }

    public LocalDate getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(LocalDate dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    @Override
    public String toString() {
        return "Media{" +
                "identificateur='" + identificateur + '\'' +
                ", categorie='" + categorie + '\'' +
                ", sousCategorie='" + sousCategorie + '\'' +
                ", description='" + description + '\'' +
                ", numeroEmprunteur=" + emprunteur +
                ", dateEmprunt=" + dateEmprunt +
                '}';
    }

    public String serialiser() {
        return String.join(" ", this.getIdentificateur(), this.categorie, this.sousCategorie, this.description);
    }
}
