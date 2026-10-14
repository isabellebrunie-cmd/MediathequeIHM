package fr.cda.modele;

import fr.cda.Exceptions.ExceptionMediatheque;

import java.time.LocalDate;
import java.util.*;


public class Mediatheque {
    private List<Media> listMedias;
    private List<Emprunteur> listEmprunteurs;
    private int compteurMedia;

    public Mediatheque() {
        this.listMedias = new ArrayList<>();
        this.listEmprunteurs = new ArrayList<>();
        this.compteurMedia = 0;
    }

    // Crée un média et l'ajoute à la médiathèque
    public void ajouterMedia(String categorie, String sousCategorie, String description) {
        Calendar dateIdent = Calendar.getInstance();
        int annee = dateIdent.get(Calendar.YEAR);
        int mois = dateIdent.get(Calendar.MONTH);
        compteurMedia++;
        String ident = String.format("%d-%02d-%05d", annee, mois, compteurMedia);
        Media newMedia = new Media(ident, categorie, sousCategorie, description);
        listMedias.add(newMedia);
    }

    public List<Media> getListMedias() {
        return listMedias;
    }

    public List<Emprunteur> getListEmprunteurs() {
        return listEmprunteurs;
    }

    public void ajouterInscrit(Emprunteur e) {
        // TODO récip le numéro inscrit le plus élevé
        e.setNumero(getNumeroInscrit());
        listEmprunteurs.add(e);
    }

    private int getNumeroInscrit() {
        if (listEmprunteurs.size() == 0) {
            return 1;
        }
        //Récup du 1er numero du 1er emprunter de ma liste
        int max = listEmprunteurs.get(0).getNumero();
        //Recherche du numero le + grand
        for (Emprunteur e : listEmprunteurs) {
            if (e.getNumero() > max) {
                max = e.getNumero();
            }
        }
        return max + 1;
    }

    // Affiche le contenu de la médiathèque : les médias puis les inscrits
    public void afficherMediatheque() {
        System.out.println("=== Liste des Médias ===");
        listMedias.forEach(System.out::println);
        System.out.println("=== Liste des Inscrits ===");
        listEmprunteurs.forEach(System.out::println);
    }


    public String afficher() {
        StringBuilder res = new StringBuilder();

        if (!listMedias.isEmpty()) {
            res.append("Les médias de la médiathèque :\n");
            for (Media m : listMedias) {
                res.append(m.toString() + "\n");
                res.append(("---------------\n"));
            }
        } else {
            res.append("Liste des médias vide !\n");
        }

        if (!listEmprunteurs.isEmpty()) {
            res.append("Les inscrits de la médiathèque :\n");
            for (Emprunteur e : listEmprunteurs) {
                res.append(e.toString() + "\n");
                res.append((e.getMediasEmpruntes()) + "\n");
                res.append(("---------------\n"));
            }
        } else {
            res.append("Liste des emprunteurs vide !");
        }
        return res.toString();
    }

    public Emprunteur rechercherEmprunteur(int numEmprunteur) throws ExceptionMediatheque {
        if (listEmprunteurs.isEmpty()) {
            throw new ExceptionMediatheque("Liste vide !");
        }
        for (Emprunteur e : listEmprunteurs)
            if (Objects.equals(numEmprunteur, e.getNumero()))
                return e;
        throw new ExceptionMediatheque("Emprunteur absent de la liste.");
    }

    public Media trouverMedia(String id) {
        if (listMedias.isEmpty()) {
            throw new ExceptionMediatheque("Liste vide !");
        }
        for (Media m : listMedias)
            if (Objects.equals(id, m.getIdentificateur()))
                return m;
        throw new ExceptionMediatheque("Média absent de la liste.");
    }

    public void emprunterMedia(String idMedia, int numEmprunteur) {
        Media mediaEmprunter = this.trouverMedia(idMedia);
        Emprunteur emprunteur = this.rechercherEmprunteur(numEmprunteur);

        emprunteur.addEmprunt(mediaEmprunter);
        mediaEmprunter.setEmprunteur(emprunteur);
        mediaEmprunter.setDateEmprunt(LocalDate.now());
    }
}
