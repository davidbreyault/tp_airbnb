package breyault.airbnb;

import breyault.airbnb.logements.Appartement;
import breyault.airbnb.logements.Logement;
import breyault.airbnb.logements.Maison;
import breyault.airbnb.menu.Menu;
import breyault.airbnb.outils.Compare;
import breyault.airbnb.outils.CompareMoreThanTwo;
import breyault.airbnb.outils.LogementsDomParser;
import breyault.airbnb.outils.MaDate;
import breyault.airbnb.reservations.Reservation;
import breyault.airbnb.reservations.Sejour;
import breyault.airbnb.reservations.SejourCourt;
import breyault.airbnb.reservations.SejourLong;
import breyault.airbnb.utilisateurs.Hote;
import breyault.airbnb.utilisateurs.Personne;
import breyault.airbnb.utilisateurs.Voyageur;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        // Personnes
        Hote david = new Hote("Breyault", "David", 29, 24);
        Voyageur jean = new Voyageur("Bonneau", "Jean", 34);
        Hote annie = new Hote("Mahle", "Annie", 32, 12);

        // Logements
        Logement maison = new Maison("maison", david, 100, "31 rue Colbert, 37000, TOURS", 140, 6, 280, true);
        Logement appartement = new Appartement("appartement", david, 88, "20 avenue de la Mer, 17200, ROYAN", 68, 4, 1, 12);

        // Dates
        MaDate date = new MaDate(2022, 9, 2);

        // Critères séjour
        int sNbNuits = 7;
        Date sDate = date;
        Logement sLogement = appartement;
        int sNbVoyageursMax = 2;

        // Séjours
        Sejour sejour;
        if (sNbNuits < 6) {
            sejour = new SejourCourt(sDate, sNbNuits, sLogement, sNbVoyageursMax);
        } else {
            sejour = new SejourLong(sDate, sNbNuits, sLogement, sNbVoyageursMax);
        }

//        // TP_8 - 1.1, 1.3
//        Date date2 = sejour.getDateArrivee();
//        //System.out.println(date2); // 02/09/2022 ???
//        //System.out.println(date2.getYear()); // 122 ???
//        date2.setYear(98);
//        sejour.afficher();

        try {
            Reservation reservation = new Reservation(sejour, jean);
            reservation.payer();
            sejour.setLogement(maison);
            reservation.afficher();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Le logement n'existe pas");
        }

        try {
            LogementsDomParser.parseData("src/breyault/airbnb/data/logements.xml", Menu.listHotes, Menu.listLogements);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        System.out.println("Nombre d'hôtes : " + Menu.listHotes.size());
//        System.out.println("Nombre de logements : " + Menu.listLogements.size() + "\n");
//
//        for (int i = 0; i < Menu.listLogements.size(); i++) {
//            Menu.listLogements.get(i).afficher();
//            System.out.println("");
//        }

        // Test TP 7 - 1.1
//        System.out.println("Recherche : ");
//        try {
//            Menu.findMaisonByName("Maison 9").afficher();
//        } catch (NullPointerException e) {
//            System.err.println("Ce logement n'existe pas !");
//        }

        // Test TP 7 - 1.2
        Logement maison1 = Menu.findLogementByName("Maison 1");
        Maison maison2 = (Maison) Menu.findLogementByName("Maison 2");

        // Test TP 7 - 1.3
        Appartement appartement3 = Menu.findLogementByNameWithGenericity("Appartement 3");
        // appartement3.afficher();

        /*

        La première méthode consiste à créer une méthode 'find' pour chaque classe héritant de Logement :
        Si cela fonctionne, cela posera vite des problèmes de maintenabilité.
        Et si la classe Logement avait une quinzaine d'enfants ? (Chalet, Yourte, Troglodytique...)

        Écrire une méthode en se basant sur la classe parente résout le problème ci-dessus.
        Néanmoins, si l'on souhaite typer plus précisément, on sera obligé de caster chaque nouvelle variable.

        On comprend donc l'utilisation de la généricité sur cette méthode.

        */

//        // Comparaison de deux logements en fonction de leur tarif grâce à la classe générique
//        Compare<Logement> comparaison = new Compare<Logement>(maison1, maison2);
//        comparaison.getLower().afficher();
//        // Comparaison de deux personnes en fonction de leur âge
//        Compare<Personne> comparaison2 = new Compare<Personne>(david, jean);
//        comparaison2.getHigher().afficher();
//        // Comparaison de deux hôtes en fonction de leur délai de réponse
//        Compare<Hote> comparaison3 = new Compare<Hote>(david, annie);
//        comparaison3.getLower().afficher();
//
//        CompareMoreThanTwo<Logement> comparaison4 = new CompareMoreThanTwo<Logement>(Menu.listLogements);
//        comparaison4.getLower().afficher();
    }
}
