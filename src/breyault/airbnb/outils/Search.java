package breyault.airbnb.outils;

import breyault.airbnb.logements.Appartement;
import breyault.airbnb.logements.Logement;
import breyault.airbnb.logements.Maison;

import java.util.ArrayList;

public class Search {
    private static final int YES = 1;
    private static final int NO = 2;
    private static final int WE_DONT_CARE = 3;

    private final int nbVoyageurs;
    private final int tarifMin;
    private final int tarifMax;
    private final int possedePiscine;
    private final int possedeJardin;
    private final int possedeBalcon;

    private Search(Builder builder) {
        this.nbVoyageurs = builder.nbVoyageursBuilder;
        this.tarifMin = builder.tarifMinBuilder;
        this.tarifMax = builder.tarifMaxBuilder;
        this.possedePiscine = builder.possedePiscineBuilder;
        this.possedeJardin = builder.possedeJardinBuilder;
        this.possedeBalcon = builder.possedeBalconBuilder;
    }

    public static class Builder {
        private final int nbVoyageursBuilder;
        private int tarifMinBuilder;
        private int tarifMaxBuilder;
        private int possedePiscineBuilder;
        private int possedeJardinBuilder;
        private int possedeBalconBuilder;

        public Builder(int nbVoyageur) {
            this.nbVoyageursBuilder = nbVoyageur;
            this.tarifMinBuilder = 0;
            this.tarifMaxBuilder = Integer.MAX_VALUE;
            this.possedePiscineBuilder = WE_DONT_CARE;
            this.possedeJardinBuilder = WE_DONT_CARE;
            this.possedeBalconBuilder = WE_DONT_CARE;
        }

        public Builder tarifMinParNuit(int tarifMin) {
            this.tarifMinBuilder = tarifMin;
            return this;
        }

        public Builder tarifMaxParNuit(int tarifMax) {
            this.tarifMaxBuilder = tarifMax;
            return this;
        }

        public Builder possedePiscine(boolean possedePiscine) {
            this.possedePiscineBuilder = possedePiscine ? YES : NO;
            return this;
        }

        public Builder possedeJardin(boolean possedeJardin) {
            this.possedeJardinBuilder = possedeJardin ? YES : NO;
            return this;
        }

        public Builder possedeBalcon(boolean possedeBalcon) {
            this.possedeBalconBuilder = possedeBalcon ? YES : NO;
            return this;
        }

        public Search build() {
            return new Search(this);
        }
    }

    public ArrayList<Logement> result() {

        ArrayList<Logement> result = new ArrayList<>();

        for (Logement logement : AirBnbData.getInstance().getListLogements()) {

            // Test nombre de voyageur
            if (logement.getNbVoyageursMax() < this.nbVoyageurs)
                continue;

            // Test du tarif par nuit
            if (logement.getTarifParNuit() < this.tarifMin || logement.getTarifParNuit() > this.tarifMax)
                continue;

            // Test pour la piscine
            if (this.possedePiscine == YES) {
                // Oui pour la piscine du coup c'est forcément une maison
                if (logement instanceof Maison) {
                    Maison maison = (Maison) logement;
                    // La maison n'a pas de piscine, on ne la prend pas
                    if (!maison.hasPiscine())
                        continue;
                } else
                    continue;

            } else if (this.possedePiscine == NO) {
                // Non pour la piscine
                if (logement instanceof Maison) {
                    Maison maison = (Maison) logement;
                    // Si la maison a une piscine, on ne la prend pas
                    if (maison.hasPiscine())
                        continue;
                }
            }

            // Test pour le jardin
            if (this.possedeJardin == YES) {
                // Oui pour le jardin du coup c'est forcément une maison
                if (logement instanceof Maison) {
                    Maison maison = (Maison) logement;
                    // La maison n'a pas de jardin, on ne la prend pas
                    if (maison.getSuperficieJardin() == 0)
                        continue;
                } else
                    continue;

            } else if (this.possedeJardin == NO) {
                // Non pour le jardin
                if (logement instanceof Maison) {
                    Maison maison = (Maison) logement;
                    // Si la maison a un jardin, on ne la prend pas
                    if (maison.getSuperficieJardin() != 0)
                        continue;
                }
            }

            // Test pour le balcon
            if (possedeBalcon == YES) {
                // Oui pour le balcon, c'est forcément un appartement
                if (logement instanceof Appartement) {
                    Appartement appartement = (Appartement) logement;
                    // Si l'appartement n'a pas de balcon, on ne le prend pas
                    if (appartement.getSuperficieBalcon() == 0)
                        continue;
                } else
                    continue;
            } else if (possedeBalcon == NO) {
                // Non pour le balcon
                if (logement instanceof Appartement) {
                    Appartement appartement = (Appartement) logement;
                    // Si l'appartement a pas un balcon, on ne le prend pas
                    if (appartement.getSuperficieBalcon() != 0)
                        continue;
                }

            }
            result.add(logement);
        }

        return result;
    }
}
