package breyault.airbnb.outils;

import java.util.ArrayList;

public class CompareMoreThanTwo<T extends Comparable> {

    private ArrayList<T> list;

    public CompareMoreThanTwo() {
        this.list = new ArrayList<T>();
    }

    public CompareMoreThanTwo(ArrayList<? extends T> list) {
        this.list = new ArrayList<T>();
        this.list.addAll(list);
    }

    public T get(int i) {
        return list.get(i);
    }

    public void add(T element) {
        this.list.add(element);
    }

    public void remove(int i) {
        this.list.remove(i);
    }

    public T getHigher() {
        T higher = null;
        int maxValue = Integer.MIN_VALUE;

        for (T element : this.list) {
            if (element.getValueToCompare() > maxValue) {
                maxValue = element.getValueToCompare();
                higher = element;
            }
        }
        return higher;
    }

    public T getLower() {
        T lower = null;
        int minValue = Integer.MAX_VALUE;

        for (T element : this.list) {
            if (element.getValueToCompare() < minValue) {
                minValue = element.getValueToCompare();
                lower = element;
            }
        }
        return lower;
    }
}
