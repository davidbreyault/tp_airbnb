package breyault.airbnb;

import breyault.airbnb.logements.Appartement;
import breyault.airbnb.logements.Logement;
import breyault.airbnb.logements.Maison;
import breyault.airbnb.menu.Menu;
import breyault.airbnb.outils.LogementsDomParser;
import breyault.airbnb.outils.MaDate;
import breyault.airbnb.reservations.Reservation;
import breyault.airbnb.reservations.Sejour;
import breyault.airbnb.reservations.SejourLong;
import breyault.airbnb.utilisateurs.Hote;
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

        // Logements
        Logement maison = new Maison("maison", david, 100, "31 rue Colbert, 37000, TOURS", 140, 6, 280, true);
        Logement appartement = new Appartement("appartement", david, 88, "20 avenue de la Mer, 17200, ROYAN", 68, 4, 1, 12);

        // Dates
        MaDate date = new MaDate(2022, 9, 2);

        // Séjours
        Sejour sejour = new SejourLong(date, 7, appartement, 2);

        // Réservations
        Reservation reservation = new Reservation(sejour, jean);
        // reservation.afficher();

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
        System.out.println("Recherche : ");
        try {
            Menu.findMaisonByName("Maison 9").afficher();
        } catch (NullPointerException e) {
            System.err.println("Ce logement n'existe pas !");
        }

        // Test TP 7 - 1.2
        Logement maison8 = Menu.findLogementByName("Maison 1");
        Maison maison9 = (Maison) Menu.findLogementByName("Maison 1");

        // Test TP 7 - 1.3
        Appartement appartement3 = Menu.findLogementByNameWithGenericity("Appartement 3");
        appartement3.afficher();

        /*

        La première méthode consiste à créer une méthode 'find' pour chaque classe héritant de Logement :
        Si cela fonctionne, cela posera vite des problèmes de maintenabilité.
        Et si la classe Logement avait une quinzaine d'enfants ? (Chalets, Yourte, Troglodytique...)

        Ecrire une méthode en se basant sur la classe générique resout le problème ci-dessus.
        Néanmoins, si l'on souhaite typer plus précisément, on sera obligé de caster chaque nouvelle variable.

        On comprend donc l'utilisation de la généricité sur cette méthode.

        */
    }
}
