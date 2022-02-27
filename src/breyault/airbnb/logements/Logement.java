package breyault.airbnb.logements;

import breyault.airbnb.outils.Comparable;
import breyault.airbnb.utilisateurs.Hote;

public abstract class Logement implements Comparable {
    private final String nom;
    private final Hote hote;
    private final int tarifParNuit;
    private final String adresse;
    private final int superficie;
    private final int nbVoyageursMax;

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

    @Override
    public int getValueToCompare() {
        return this.tarifParNuit;
    }
}
