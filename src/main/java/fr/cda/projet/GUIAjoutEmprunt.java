package fr.cda.projet;

import fr.cda.ihm.Formulaire;
import fr.cda.ihm.FormulaireInt;
import fr.cda.modele.Emprunteur;
import fr.cda.modele.Media;
import fr.cda.modele.Mediatheque;

import java.util.ArrayList;
import java.util.List;

public class GUIAjoutEmprunt implements FormulaireInt {
    private GUISite formPP;
    private Mediatheque m;

    public GUIAjoutEmprunt(GUISite formPP, Mediatheque m) {
        this.formPP = formPP;
        this.m = m;

        Formulaire form = new Formulaire("Ajout Emprunt", this, 400, 300);

        //Listes de sélection pour emprunteurs et médias
        String[] listeEmprunts = this.convertListEmpruntString();
        form.addListScroll("LISTE-EMPRUNTS", "Emprunteur", true, listeEmprunts, 250, 100);
        String[] listeMedias = this.convertListMediaString();
        form.addListScroll("LISTE-MEDIAS", "Média", true, listeMedias, 250, 100);

        //form.addText("NUMERO-EMPRUNTEUR", "Numéro de l'emprunteur", true, "");
        //form.addText("NUMERO-MEDIA", "Numéro du média", true, "");
        form.addButton("VALIDER", "Valider");
        form.addButton("ANNULER", "Annuler");

        //Position de la fenêtre principale
        form.setPosition(300, 300);
        form.afficher();
    }

    //Saisie de l'emprunt
    @Override
    public void submit(Formulaire form, String nomSubmit) {
        if (nomSubmit.equals("VALIDER")) {
            String emprunteur = form.getValeurChamp("LISTE-EMPRUNTS");
            String media = form.getValeurChamp("LISTE-MEDIAS");

            //Récupération id emprunteur
            String[] sple = emprunteur.split(" ");
            int idEmprunt = Integer.valueOf(sple[0]);
            //récupération id-média
            String[] splm = media.split(" ");
            String idMedia = splm[0];
            this.m.emprunterMedia(idMedia, idEmprunt);

            //Affichage du résultat
            this.formPP.afficherResultat(m.afficher());

            form.fermer();
        } else if (nomSubmit.equals("ANNULER")) {
            form.fermer();
        }
    }

    private String[] convertListEmpruntString() {
        List<Emprunteur> le = m.getListEmprunteurs();
        List<String> listeEmprunteurs = new ArrayList<>();
        for (Emprunteur e : le) {
            String nom = e.getNom();
            String prenom = e.getPrenom();
            String numEmprenteur = String.valueOf(e.getNumero());
            listeEmprunteurs.add(numEmprenteur + nom + prenom);
        }
        return listeEmprunteurs.toArray(String[]::new);
    }

    private String[] convertListMediaString() {
        List<Media> lm = m.getListMedias();
        List<String> listeMedia = new ArrayList<>();
        for (Media m : lm) {
            listeMedia.add(m.serialiser());
        }
        return listeMedia.toArray(String[]::new);
    }
}
