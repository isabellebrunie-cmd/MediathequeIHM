package fr.cda.projet;

import fr.cda.ihm.Formulaire;
import fr.cda.ihm.FormulaireInt;
import fr.cda.modele.Mediatheque;

public class GUIErreurSaisie implements FormulaireInt {
    private GUISite formPP;

    public GUIErreurSaisie(GUISite formPP, String message) {
        this.formPP = formPP;
        Formulaire form = new Formulaire("Erreur de saisie", this, 320, 260);
        form.addText("ERREUR", "Erreur", false, message);
        form.addButton("FERMER", "Fermer");
        //Position de la fenêtre principale
        form.setPosition(300, 300);
        form.afficher();
    }

    @Override
    public void submit(Formulaire form, String nom) {
        if (nom.equals("FERMER")) {
            form.fermer();
        }
    }
}
