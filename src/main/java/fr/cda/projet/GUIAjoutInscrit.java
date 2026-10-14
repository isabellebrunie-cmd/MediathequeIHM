package fr.cda.projet;

import fr.cda.ihm.Formulaire;
import fr.cda.ihm.FormulaireInt;
import fr.cda.modele.Emprunteur;
import fr.cda.modele.Mediatheque;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class GUIAjoutInscrit implements FormulaireInt {

    private GUISite formPP;
    private Mediatheque m;

    public GUIAjoutInscrit(GUISite formPP, Mediatheque m) {
        this.formPP = formPP;
        this.m = m;
        Formulaire form = new Formulaire("Ajout Inscrit", this, 320, 260);
        form.addText("NOM", "Nom", true, "");
        form.addText("PRENOM", "Prénom", true, "");
        form.addText("DATE-NAISSANCE", "Date de naissance (jj/mm/aaaa)", true, "");
        form.addButton("VALIDER", "Valider");
        form.addButton("ANNULER", "Annuler");

        //Position de la fenêtre principale
        form.setPosition(300, 300);
        form.afficher();
    }

/*
    public LocalDate ConvertDateNaiss(String d) throws  DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            return LocalDate.parse(d, formatter);
        } catch (DateTimeParseException e) {
            System.err.println("Date invalide, format attendu : jj/mm/aaaa");
        }
    }*/

    @Override
    public void submit(Formulaire form, String nomSubmit) {
        if (nomSubmit.equals("VALIDER")) {
            String dateNaiss = form.getValeurChamp("DATE-NAISSANCE");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            LocalDate dateN;
            try {
                dateN = LocalDate.parse(dateNaiss, formatter);
            } catch (DateTimeParseException e) {
                System.err.println("Date invalide, format attendu : jj/mm/aaaa");
                GUIErreurSaisie er = new GUIErreurSaisie(formPP, "Date invalide, format attendu : jj/mm/aaaa");
                return;
            }

            Emprunteur e = new Emprunteur(form.getValeurChamp("NOM"), form.getValeurChamp("PRENOM"), dateN);
            this.m.ajouterInscrit(e);
            formPP.afficherResultat(m.afficher());
            form.fermer();
        } else if (nomSubmit.equals("ANNULER")) {
            form.fermer();
        }
    }
}
