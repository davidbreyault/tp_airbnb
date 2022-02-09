package breyault.airbnb.reservations;

import breyault.airbnb.utilisateurs.Voyageur;

import java.util.Date;

public class Reservation {
    private int identifiant;
    private Sejour sejour;
    private Voyageur voyageur;
    private boolean estValidee;
    private Date dateDeReservation;

    public Reservation(Sejour sejour, Voyageur voyageur) {
        this.sejour = sejour;
        this.voyageur = voyageur;
    }

    public void afficher() {
        this.voyageur.afficher();
        System.out.print(" a fait une réservation chez ");
        this.sejour.afficher();
    }
}
