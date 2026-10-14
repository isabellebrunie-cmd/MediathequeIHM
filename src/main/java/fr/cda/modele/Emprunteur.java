package fr.cda.modele;

import java.time.LocalDate;
import java.util.*;

public class Emprunteur {
    private int numero;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private List<Media> mediasEmpruntes;

    public Emprunteur(int numero, String nom, String prenom, LocalDate dateNaissance, List<Media> mediasEmpruntes) {
        this.numero = numero = 0;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.mediasEmpruntes = new ArrayList<>();
    }

    public Emprunteur(String nom, String prenom, LocalDate dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public List<Media> getMediasEmpruntes() {
        return mediasEmpruntes;
    }

    public void setMediasEmpruntes(List<Media> mediasEmpruntes) {
        this.mediasEmpruntes = mediasEmpruntes;
    }

    @Override
    public String toString() {
        return "Emprunteur{" +
                "numero=" + numero +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateNaissance=" + dateNaissance +
                '}';
    }

    public void addEmprunt(Media media) {
        media.setEmprunteur(this);
        media.setDateEmprunt(LocalDate.now());
        this.mediasEmpruntes.add(media);
    }

    public void supprimerEmprunt(Media media) {
        this.mediasEmpruntes.remove(media);
        media.setEmprunteur(null);
        media.setDateEmprunt(null);
    }

    public void supprimerEmprunt(String identificateur) {
        Media media = new Media(identificateur);
        this.mediasEmpruntes.remove(media);
        media.setEmprunteur(null);
        media.setDateEmprunt(null);
    }



}
