package breyault.airbnb.reservations;

import breyault.airbnb.logements.Logement;

import java.util.Date;

public class SejourLong extends Sejour {

    private static final int PROMOTION_EN_POURCENTAGE = 20;
    private int promotion;

    public SejourLong(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
        super(dateArrivee, nbNuits, logement, nbVoyageurs);
        this.promotion = ((nbNuits * logement.getTarifParNuit() * 20) / 100);
    }

    @Override
    public boolean verificationNombreDeNuits() {
        return this.getNbNuits() >= 6 && this.getNbNuits() <= 31;
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Le prix de ce séjour est de : " + this.tarif + "€ (" + this.promotion + "€ de promotion)");
    }

    @Override
    public void miseAJourDuTarif() {
        int tarifInitial = this.getNbNuits() * this.getLogement().getTarifParNuit();
        this.promotion = (tarifInitial * 20) / 100;
        this.tarif = tarifInitial - this.promotion;
    }
}
