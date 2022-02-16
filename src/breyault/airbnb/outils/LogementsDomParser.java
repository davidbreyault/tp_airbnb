package breyault.airbnb.outils;

import breyault.airbnb.logements.Appartement;
import breyault.airbnb.logements.Logement;
import breyault.airbnb.logements.Maison;
import breyault.airbnb.utilisateurs.Hote;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class LogementsDomParser {

    private LogementsDomParser() {
        throw new UnsupportedOperationException();
    }

    public static void parseData(String path, ArrayList<Hote> listHotes, ArrayList<Logement> listLogements)
            throws IOException, ParserConfigurationException, SAXException {

        if (listHotes == null || listLogements == null) {
            throw new IllegalArgumentException("listHotes == null || listLogements == null");
        }

        File xmlFile = new File(path);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        Document document = dbFactory.newDocumentBuilder().parse(xmlFile);

        document.getDocumentElement().normalize();
        // Logements
        Node node = document.getChildNodes().item(0);
        NodeList nodeList = node.getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node iNode = nodeList.item(i);
            // System.out.print("\nCurrent Element :" + iNode.getNodeName());
            // Si le noeud de type ELEMENT (et non de type TEXT)
            if (iNode.getNodeType() == Node.ELEMENT_NODE) {
                // Appartement, Maison
                Element element = (Element) iNode;
                // Hote
                Element hoteElement = (Element) element.getElementsByTagName("hote").item(0);
                String nom = hoteElement.getElementsByTagName("nom").item(0).getTextContent();
                String prenom = hoteElement.getElementsByTagName("prenom").item(0).getTextContent();
                int age = Integer.parseInt(hoteElement.getElementsByTagName("age").item(0).getTextContent());
                int delaiReponse = Integer.parseInt(hoteElement.getElementsByTagName("delaiReponse").item(0).getTextContent());

                // Création de l'hote avec les données récupérées
                Hote hote = new Hote(nom, prenom, age, delaiReponse);

                // Vérification des doublons - Attention ! Méthode equals à override dans la classe Personne et Hote
                int index = listHotes.indexOf(hote);
                // Si l'hôte est déjà présent dans la liste
                if (index != -1) {
                    hote = listHotes.get(index);
                } else {
                    listHotes.add(hote);
                }

                String nomLogement = element.getAttribute("name");
                int tarifParNuit = Integer.parseInt(element.getElementsByTagName("tarifParNuit").item(0).getTextContent());
                String adresse = element.getElementsByTagName("adresse").item(0).getTextContent();
                int superficie = Integer.parseInt(element.getElementsByTagName("superficie").item(0).getTextContent());
                int nbVoyageursMax = Integer.parseInt(element.getElementsByTagName("nbVoyageursMax").item(0).getTextContent());

                // Si l'élément est un appartement
                if (element.getNodeName().equals("Appartement")) {
                    int numeroEtage = Integer.parseInt(element.getElementsByTagName("numeroEtage").item(0).getTextContent());
                    int superficieBalcon = Integer.parseInt(element.getElementsByTagName("superficieBalcon").item(0).getTextContent());
                    // Création de l'appartement
                    Appartement appartement = new Appartement(
                            nomLogement,
                            hote,
                            tarifParNuit,
                            adresse,
                            superficie,
                            nbVoyageursMax,
                            numeroEtage,
                            superficieBalcon
                    );
                    // Ajout de l'appartement
                    listLogements.add(appartement);
                }

                // Si l'élément est une maison
                if (element.getNodeName().equals("Maison")) {
                    int superficieJardin = Integer.parseInt(element.getElementsByTagName("superficieJardin").item(0).getTextContent());
                    int possedePiscine = Integer.parseInt(element.getElementsByTagName("possedePiscine").item(0).getTextContent());
                    // Création de la maison
                    Maison maison = new Maison(
                            nomLogement,
                            hote,
                            tarifParNuit,
                            adresse,
                            superficie,
                            nbVoyageursMax,
                            superficieJardin,
                            possedePiscine == 1 ? true : false
                    );
                    // Ajout de la maison
                    listLogements.add(maison);
                }
            }
        }
    }
}
