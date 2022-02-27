package breyault.airbnb.outils;

import breyault.airbnb.logements.Logement;
import breyault.airbnb.menu.Menu;
import breyault.airbnb.utilisateurs.Hote;
import breyault.airbnb.utilisateurs.Voyageur;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class AirBnbData {

    // L'unique instance de AirBnbData
    private static AirBnbData instance = new AirBnbData();
    // Les données de AirBnbData
    private ArrayList<Hote> listHotes;
    private ArrayList<Logement> listLogements;

    private AirBnbData() {
        this.listHotes = new ArrayList<Hote>();
        this.listLogements = new ArrayList<Logement>();

        try {
            LogementsDomParser.parseData("src/breyault/airbnb/data/logements.xml", listHotes, listLogements);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static AirBnbData getInstance() {
        return instance;
    }

    public ArrayList<Logement> getListLogements() {
        return this.listLogements;
    }

    public ArrayList<Hote> getListHotes() {
        return this.listHotes;
    }
}
