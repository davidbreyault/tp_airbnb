package breyault.airbnb.utilisateurs;

import breyault.airbnb.outils.Comparable;

public abstract class Personne implements Comparable {
    private String nom;
    private String prenom;
    private int age;

    public Personne(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    public void afficher() {
        System.out.print(this.prenom + " " + this.nom + " (" + this.age + " ans)");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personne personne = (Personne) o;
        return age == personne.age && prenom.equals(personne.prenom) && nom.equals(personne.nom);
    }

    @Override
    public int getValueToCompare() {
        return this.age;
    }
}
