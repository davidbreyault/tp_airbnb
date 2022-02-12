package breyault.airbnb.reservations;

import breyault.airbnb.logements.Logement;
import breyault.airbnb.outils.Utile;

import java.util.Date;

public class Sejour implements SejourInterface {
    private Date dateArrivee;
    private int nbNuits;
    private Logement logement;
    private int nbVoyageurs;

    public Sejour(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
        this.dateArrivee = dateArrivee;
        this.nbNuits = nbNuits;
        this.logement = logement;
        this.nbVoyageurs = nbVoyageurs;
    }

    @Override
    public boolean verificationDateArrivee() {
        return this.dateArrivee.after(new Date());
    }

    @Override
    public boolean verificationNombreDeNuits() {
        return this.nbNuits > 1 && this.nbNuits <= 31;
    }

    @Override
    public boolean verificationNombreDeVoyageurs() {
        return this.nbVoyageurs <= this.logement.getNbVoyageursMax();
    }

    public void afficher() {
        this.logement.afficher();
        System.out.println(
            "La date d'arrivée est le " + Utile.buildDateString(this.dateArrivee) +
            " pour " + this.nbNuits + " nuit" + this.pluralManager(this.nbNuits) + "."
        );
        System.out.println("Le prix de ce séjour est de : " + (this.nbNuits * this.logement.getTarifParNuit() + "€."));
    }

    public String pluralManager(int number) {
        return number > 1 ? "s" : "";
    }
}
