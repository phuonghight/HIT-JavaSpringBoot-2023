import java.util.Comparator;

public record PersonNameComparator() implements Comparator<Honey> {

    @Override
    public int compare(Honey h1, Honey h2) {
        // TODO Auto-generated method stub
        return h1.getName().compareTo(h2.getName());
    }
}
