package breyault.airbnb.logements;

import breyault.airbnb.utilisateurs.Hote;

public class Maison extends Logement {

    private int superficieJardin;
    private boolean possedePiscine;

    public Maison(Hote hote, int tarifParNuit, String adresse, int superficie, int nbVoyageursMax, int superficieJardin, boolean possedePiscine) {
        super(hote, tarifParNuit, adresse, superficie, nbVoyageursMax);
        this.superficieJardin = superficieJardin;
        this.possedePiscine = possedePiscine;
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("\nLe logement est une maison situé " + this.getAdresse() + ".");
        System.out.println("Superficie : " + this.getSuperficie() + "m2.");
        System.out.println("Jardin : " + (this.superficieJardin > 0 ? "Oui ("+ this.superficieJardin +"m2)" : "Non"));
        System.out.println("Piscine : " + (this.possedePiscine ? "Oui" : "Non"));
    }
}
