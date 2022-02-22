package breyault.airbnb.outils;

// Classe générique de type T, où T peut être n'importe quel type de classe tant qu'elle implémente l'interface Comparable
public class Compare <T extends Comparable> {

    private T object1;
    private T object2;

    public Compare(T object1, T object2) {
        this.object1 = object1;
        this.object2 = object2;
    }

    public T getHigher() {
        return this.object1.getValueToCompare() > this.object2.getValueToCompare()
                ? object1
                : object2;
    }

    public T getLower() {
        return this.object1.getValueToCompare() < this.object2.getValueToCompare()
                ? object1
                : object2;
    }
}
