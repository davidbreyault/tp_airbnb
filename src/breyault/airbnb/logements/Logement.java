package breyault.airbnb.logements;

import breyault.airbnb.utilisateurs.Hote;

public class Logement {
    private Hote hote;
    private int tarifParNuit;
    private String adresse;
    private int superficie;
    private int nbVoyageursMax;

    public Logement(Hote hote, int tarifParNuit, String adresse, int superficie, int nbVoyageursMax) {
        this.hote = hote;
        this.tarifParNuit = tarifParNuit;
        this.adresse = adresse;
        this.superficie = superficie;
        this.nbVoyageursMax = nbVoyageursMax;
    }

    public int getTarifParNuit() {
        return tarifParNuit;
    }

    public void afficher() {
        this.hote.afficher();
        System.out.println("\nLe logement est situé " + this.adresse + ".");
        System.out.println("Superficie : " + this.superficie + "m2.");

    }
}
