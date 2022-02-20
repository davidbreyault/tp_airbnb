package breyault.airbnb.logements;

import breyault.airbnb.utilisateurs.Hote;

public abstract class Logement {
    private String nom;
    private Hote hote;
    private int tarifParNuit;
    private String adresse;
    private int superficie;
    private int nbVoyageursMax;

    public Logement(String nom, Hote hote, int tarifParNuit, String adresse, int superficie, int nbVoyageursMax) {
        this.nom = nom;
        this.hote = hote;
        this.tarifParNuit = tarifParNuit;
        this.adresse = adresse;
        this.superficie = superficie;
        this.nbVoyageursMax = nbVoyageursMax;
    }

    public String getNom() {
        return nom;
    }

    public int getTarifParNuit() {
        return tarifParNuit;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void afficher() {
        this.hote.afficher();
    }

    public int getNbVoyageursMax() {
        return nbVoyageursMax;
    }
}
