package fr.afpa.jsf.metier;


public class Couleur {
    private int id;
    private String nom;

    public Couleur() {

    }

    public Couleur(Integer id, String libelle) {
        this.id = id;
        this.nom = libelle;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return nom;
    }

}
