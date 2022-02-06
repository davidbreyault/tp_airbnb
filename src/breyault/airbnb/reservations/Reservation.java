package breyault.airbnb.reservations;

import breyault.airbnb.utilisateurs.Personne;

import java.util.Date;

public class Reservation {
    private int identifiant;
    private Sejour sejour;
    private Personne voyageur;
    private boolean estValidee;
    private Date dateDeReservation;

    public Reservation(Sejour sejour, Personne voyageur) {
        this.sejour = sejour;
        this.voyageur = voyageur;
    }

    public void afficher() {
        this.voyageur.afficher();
        System.out.print(" a fait une réservation chez ");
        this.sejour.afficher();
    }
}
