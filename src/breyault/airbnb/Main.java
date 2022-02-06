package breyault.airbnb;

import breyault.airbnb.logements.Logement;
import breyault.airbnb.outils.Utile;
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

        // Dates
        Date date = new Date(2022, 02, 12);
        Date date2 = Utile.buildDateObject(2022, 12, 02);

        // Séjours
        Sejour sejour = new Sejour(date, 1, logement, 2);

        // Réservations
        Reservation reservation = new Reservation(sejour, jean);
        reservation.afficher();
    }
}
