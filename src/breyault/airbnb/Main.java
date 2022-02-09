package breyault.airbnb;

import breyault.airbnb.logements.Appartement;
import breyault.airbnb.logements.Logement;
import breyault.airbnb.logements.Maison;
import breyault.airbnb.outils.Utile;
import breyault.airbnb.reservations.Reservation;
import breyault.airbnb.reservations.Sejour;
import breyault.airbnb.utilisateurs.Hote;
import breyault.airbnb.utilisateurs.Voyageur;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        // Personnes
        Hote david = new Hote("Breyault", "David", 29, 24);
        Voyageur jean = new Voyageur("Bonneau", "Jean", 34);

        // Logements
        Logement maison = new Maison(david, 100, "31 rue Colbert, 37000, TOURS", 140, 6, 280, true);
        Logement appartement = new Appartement(david, 88, "20 avenue de la Mer, 17200, ROYAN", 68, 4, 1, 12);

        // Dates
        Date date = new Date(2022, 02, 12);
        Date date2 = Utile.buildDateObject(2022, 12, 02);

        // Séjours
        Sejour sejour = new Sejour(date, 2, appartement, 2);

        // Réservations
        Reservation reservation = new Reservation(sejour, jean);
        reservation.afficher();
    }
}
