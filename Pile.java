package proj;
import java.util.ArrayList;

public class Pile<T> {
    private ArrayList<T> elements;

    public Pile() {
        elements = new ArrayList<>();
    }

    public void inserer(T element) {
        elements.add(element);
    }

    public T extraire() {
        if (elements.isEmpty()) {
            throw new IllegalStateException("La pile est vide.");
        }
        return elements.remove(elements.size() - 1);
    }

    public T sommet() {
        if (elements.isEmpty()) {
            throw new IllegalStateException("La pile est vide.");
        }
        return elements.get(elements.size() - 1);
    }

    public boolean vide() {
        return elements.isEmpty();
    }

    public int taille() {
        return elements.size();
    }
}
