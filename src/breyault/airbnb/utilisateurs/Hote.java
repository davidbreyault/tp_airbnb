package breyault.airbnb.utilisateurs;

public class Hote extends Personne {

    private int delaiDeReponse;

    public Hote(String nom, String prenom, int age, int delaiDeReponse) {
        super(nom, prenom, age);
        this.delaiDeReponse = delaiDeReponse;
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.print(" qui s'engage à répondre dans ");
        if (delaiDeReponse > 1) {
            System.out.print("les " + this.delaiDeReponse + " heures.");
        } else {
            System.out.print("l'heure.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Hote hote = (Hote) o;
        return super.equals(o) && delaiDeReponse == hote.delaiDeReponse;
    }

    @Override
    public int getValueToCompare() {
        return this.delaiDeReponse;
    }
}
