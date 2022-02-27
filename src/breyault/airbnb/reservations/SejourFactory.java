package breyault.airbnb.reservations;

import breyault.airbnb.logements.Logement;

import java.util.Date;

public final class SejourFactory {

    private SejourFactory() {}

    public static Sejour buildSejour(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
        return nbNuits < 6
            ? new SejourCourt(dateArrivee, nbNuits, logement, nbVoyageurs)
            : new SejourLong(dateArrivee, nbNuits, logement, nbVoyageurs)
        ;
    }
}
