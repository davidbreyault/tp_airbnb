package breyault.airbnb;

import breyault.airbnb.logements.Logement;
import breyault.airbnb.reservations.Reservation;
import breyault.airbnb.reservations.Sejour;
import breyault.airbnb.utilisateurs.Personne;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        // Personnes
        Personne david = new Personne("Breyault", "David", 29);
        Personne jean = new Personne("Bonneau", "Jean", 34);

        // Logements
        Logement logement = new Logement(david, 50, "31 rue Colbert, 37000, TOURS", 65, 4);

        // Séjours
        Sejour sejour = new Sejour(new Date(2022 - 1900, 3, 12), 1, logement, 2);

        // Réservations
        Reservation reservation = new Reservation(sejour, jean);
        reservation.afficher();
    }
}
