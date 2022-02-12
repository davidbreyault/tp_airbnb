package breyault.airbnb.menu;

import breyault.airbnb.utilisateurs.Hote;

class GestionHotes {

    static void listerHotes() {

        System.out.println("-------------------------------------");
        System.out.println("Liste des hôtes ");
        System.out.println("-------------------------------------");

        // Afficher la liste des hôtes
        for (int i = 0; i < Menu.listHotes.size(); i++) {
            System.out.print("Hôte n°" + (i + 1) + " : ");
            Menu.listHotes.get(i).afficher();
            System.out.println("");
        }

        System.out.println("\nSaisir une option : ");
        System.out.println("1 : Ajouter un hôte");
        System.out.println("2 : Supprimer un hôte");
        System.out.println("3 : Retour");

        try {
            switch (Menu.choix(3)) {
                case 1:
                    ajouterHote();
                    break;
                case 2:
                    supprimerHote();
                    break;
                case 3:
                    Menu.listerMenu();
                    break;
            }
        } catch (Exception e) {
            System.err.println("Une erreur est survenue.");
            Menu.scanner.next();
            listerHotes();
        }
    }

    private static void ajouterHote() throws Exception {

        System.out.println("-------------------------------------");
        System.out.println("Ajouter un nouvel hôte");

        // TODO
        System.out.println("Nom :");
        String nom = Menu.scanner.next();
        System.out.println("Prénom :");
        String prenom = Menu.scanner.next();
        System.out.println("Age :");
        int age = Menu.scanner.nextInt();
        System.out.println("Délai de réponse :");
        int delaiDeReponse = Menu.scanner.nextInt();

        Hote hote = new Hote(nom, prenom, age, delaiDeReponse);
        Menu.listHotes.add(hote);

        listerHotes();
    }

    private static void supprimerHote() {

        System.out.println("-------------------------------------");
        System.out.println("Supprimer un hôte");

        // TODO

        listerHotes();
    }
}
