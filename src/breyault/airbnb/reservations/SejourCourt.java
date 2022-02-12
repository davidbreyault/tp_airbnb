package breyault.airbnb.reservations;

import breyault.airbnb.logements.Logement;

import java.util.Date;

public class SejourCourt extends Sejour {

    public SejourCourt(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
        super(dateArrivee, nbNuits, logement, nbVoyageurs);
        this.tarif = nbNuits * logement.getTarifParNuit();
    }

    @Override
    public boolean verificationNombreDeNuits() {
        return this.getNbNuits() > 0 && this.getNbNuits() < 6;
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Le prix de ce séjour est de : " + this.tarif + "€.");
    }
}
