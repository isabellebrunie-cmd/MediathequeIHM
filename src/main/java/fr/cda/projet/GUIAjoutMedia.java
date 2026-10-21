package fr.cda.projet;

import fr.cda.ihm.Formulaire;
import fr.cda.ihm.FormulaireInt;
import fr.cda.modele.Categorie;
import fr.cda.modele.Mediatheque;

public class GUIAjoutMedia implements FormulaireInt {

    private GUISite formPP;
    private Mediatheque m;
    private Categorie c;

    public GUIAjoutMedia(GUISite formPP, Mediatheque m) {
        this.formPP = formPP;
        this.m = m;
        Categorie[] valeurs = Categorie.values();
        String[] listeCategories = new String[valeurs.length];
        for (int i = 0; i < valeurs.length; i++) {
            listeCategories[i] = valeurs[i].name();
        }
        Formulaire form = new Formulaire("Ajout Média", this, 320, 260);
        form.addListScroll("CATEGORIE", "Catégorie", true, listeCategories, 250, 100);
        form.addText("SOUS-CATEGORIE", "Sous-catégorie", true, "");
        form.addText("DESCRIPTION", "Description", true, "");
        form.addButton("VALIDER", "Valider");
        form.addButton("ANNULER", "Annuler");

        //Position de la fenêtre principale
        form.setPosition(300, 300);
        form.afficher();
    }

    //Saisie du média
    @Override
    public void submit(Formulaire form, String nomSubmit) {
        if (nomSubmit.equals("VALIDER")) {
            this.m.ajouterMedia(form.getValeurChamp("CATEGORIE"), form.getValeurChamp("SOUS-CATEGORIE"), form.getValeurChamp("DESCRIPTION"));
            formPP.afficherResultat(m.afficher());
            form.fermer();
        } else if (nomSubmit.equals("ANNULER")) {
            form.fermer();
        }
    }

}
