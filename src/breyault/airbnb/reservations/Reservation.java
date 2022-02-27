package breyault.airbnb.reservations;

import breyault.airbnb.utilisateurs.Voyageur;

import java.util.Date;

public class Reservation {
    private int identifiant;
    private Sejour sejour;
    private Voyageur voyageur;
    private boolean estValidee;
    private Date dateDeReservation;

    public Reservation(Sejour sejour, Voyageur voyageur) throws Exception {

        if (sejour == null) {
            throw new IllegalArgumentException("Sejour null.....");
        }

        if (!sejour.verificationDateArrivee()) {
            throw new IllegalArgumentException("Sejour incorrect date non valide.....");
        }

        if (!sejour.verificationNombreDeVoyageurs()) {
            throw new IllegalArgumentException("Sejour incorrect nb voyageurs non valide.....");
        }

        if (!sejour.verificationNombreDeNuits()) {
            throw new IllegalArgumentException("Sejour incorrect nb nuits non valide.....");
        }

        this.sejour = (Sejour) sejour.clone();
        this.voyageur = voyageur;
        this.estValidee = false;
        this.dateDeReservation = new Date();
        this.identifiant = (int) (Math.random() * 123456789);
    }

    public void afficher() {
        this.voyageur.afficher();
        System.out.print(" a fait une réservation chez ");
        this.sejour.afficher();
    }

    public void payer() {
        System.out.println("Vous avez payé " + sejour.tarif + "€, pour le logement : " + sejour.getLogement().getAdresse());
    }
}
