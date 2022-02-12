package breyault.airbnb.reservations;

import breyault.airbnb.logements.Logement;

import java.util.Date;

public class SejourCourt extends Sejour {

    private int tarif;

    public SejourCourt(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
        super(dateArrivee, nbNuits, logement, nbVoyageurs);
        this.tarif = nbNuits * logement.getTarifParNuit();
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Le prix de ce séjour est de : " + this.tarif + "€.");
    }
}
