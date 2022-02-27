package breyault.airbnb.reservations;

import breyault.airbnb.logements.Logement;
import breyault.airbnb.outils.MaDate;

import java.util.Date;

public abstract class Sejour implements SejourInterface {
    private Date dateArrivee;
    private int nbNuits;
    private Logement logement;
    private int nbVoyageurs;
    protected int tarif;

    public Sejour(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
        this.dateArrivee = new MaDate(dateArrivee.getTime()); // Copie défensive
        this.nbNuits = nbNuits;
        this.logement = logement;
        this.nbVoyageurs = nbVoyageurs;
        this.miseAJourDuTarif();
    }

    public Date getDateArrivee() {
        return new MaDate(this.dateArrivee.getTime()); // Copie défensive
    }

    public int getNbNuits() {
        return nbNuits;
    }

    public Logement getLogement() {
        return logement;
    }

    /**
     *
     * @param logement
     * @throws IllegalArgumentException Si le logement est null
     */
    public void setLogement(Logement logement) throws IllegalArgumentException {
        if (logement == null) {
            throw new IllegalArgumentException();
        }
        this.logement = logement;
        this.miseAJourDuTarif();
    }

    @Override
    public boolean verificationDateArrivee() {
        return this.dateArrivee.after(new Date());
    }

    @Override
    public boolean verificationNombreDeVoyageurs() {
        return this.nbVoyageurs > 0 && this.nbVoyageurs <= this.logement.getNbVoyageursMax();
    }

    public void afficher() {
        this.logement.afficher();
        System.out.println(
            "La date d'arrivée est le " + this.dateArrivee.toString() +
            " pour " + this.nbNuits + " nuit" + this.pluralManager(this.nbNuits) + "."
        );
    }

    public String pluralManager(int number) {
        return number > 1 ? "s" : "";
    }

    public abstract void miseAJourDuTarif();
}
