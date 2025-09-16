import java.util.Collection;
import java.util.Iterator;

public class Ex3
{
    public static <T extends Comparable> T getMax(Collection<T> col) {
        return (col == null) ? null : getMax(col.iterator());
    }

    private static <T extends Comparable> T getMax(Iterator<T> iter) {
        if (iter == null || !iter.hasNext()) return null;


        T elem_a = iter.next();
        T elem_b = getMax(iter);

        if (elem_a == null || (elem_b != null && elem_a.compareTo(elem_b) < 0)) {
            return elem_b;
        }

        return elem_a;
    }
}
