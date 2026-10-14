package fr.cda.projet;

import fr.cda.modele.Emprunteur;
import fr.cda.modele.Mediatheque;

import java.time.LocalDate;

public class MainEtape1 {

    public static void main(String[] args) {
        Mediatheque mediatheque = new Mediatheque();

        //TODO Création et ajout de 3 médias
        mediatheque.ajouterMedia("LIVRE", "ROMAN", "Anasterry, un livre d'Isabelle Bauthian");
        mediatheque.ajouterMedia("DVD","REPORTAGE", "Un jour de 79 : la destruction de Pompéi");
        mediatheque.ajouterMedia("CD", "METAL", "Ultra Vomit Hellfest 2026");

        //TODO création et l'ajout de 3 emprunteurs

        Emprunteur e1 = new Emprunteur("Fey", "Tina", LocalDate.of(1970, 5, 18));
        Emprunteur e2 = new Emprunteur("Dalton", "Joe", LocalDate.of(1968, 6, 17));
        Emprunteur e3 = new Emprunteur("Macron", "Brigitte", LocalDate.of(1953, 4, 13));
        mediatheque.ajouterInscrit(e1);
        mediatheque.ajouterInscrit(e2);
        mediatheque.ajouterInscrit(e3);

        //Affichage de la médiathèque dans la console
        mediatheque.afficherMediatheque();
    }
}