package breyault.airbnb.logements;

import breyault.airbnb.utilisateurs.Hote;

public class Appartement extends Logement {

    private final int numeroEtage;
    private final int superficieBalcon;

    public Appartement(String nom, Hote hote, int tarifParNuit, String adresse, int superficie, int nbVoyageursMax, int numeroEtage, int superficieBalcon) {
        super(nom, hote, tarifParNuit, adresse, superficie, nbVoyageursMax);
        this.numeroEtage = numeroEtage;
        this.superficieBalcon = superficieBalcon;
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("\nLe logement est un appartement situé " + this.getAdresse() + this.gestionEtageAdresse(this.numeroEtage));
        System.out.println("Superficie : " + this.getSuperficie() + "m2.");
        System.out.println("Balcon : " + (this.superficieBalcon > 0 ? "Oui (" + this.superficieBalcon + "m2)" : "Non"));
    }

    /**
     *
     * @param numeroEtage Le numéro de l'étage de l'appartement.
     * @return Une chaîne de caractère adéquat à afficher à l'utilisateur.
     */
    public String gestionEtageAdresse(int numeroEtage) {

        String etageAdresse = "";

        if (numeroEtage == 0) {
            etageAdresse = " au rez de chaussée.";
        }
        if (numeroEtage == 1) {
            etageAdresse = " au 1er étage.";
        }
        if (numeroEtage > 1) {
            etageAdresse = " au " + numeroEtage + "ème étage.";
        }

        return etageAdresse;
    }
}
