// package multimappa;

import java.util.Collection;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MultiMappa<K, V>
        implements Iterable<MultiMappa.Elemento<K, V>> {
    Map<K, Collection<V>> mappa;

    public MultiMappa() {
      mappa = new HashMap<>();
    }

    public void put(K k, V v) {
        if (!mappa.containsKey(k))
            mappa.put(k, new HashSet<>());
        mappa.get(k).add(v);
    }

    public void putAll(MultiMappa<K, V> multimappa) {
        for (K k : multimappa.mappa.keySet()) {
            for (V v : multimappa.mappa.get(k))
                put(k, v);
        }
    }

    public void removeAll(MultiMappa<K, V> multimappa) {
        for (K k : multimappa.mappa.keySet()) {
            mappa.remove(k);
        }
    }

    public Set<V> get(K k) {
        return (Set<V>)mappa.get(k);
    }

    public Set<V> get(K k, Predicate<V> p) {
        Set<V> result = new HashSet<>();
        if (!mappa.containsKey(k))
            return result;
        for (V v : mappa.get(k))
            if (p.test(v))
                result.add(v);
        return result;
    }

    public List<V> values() {
        List<V> lista = new LinkedList<>();
        mappa.forEach((k, c) -> lista.addAll(c));
        return lista;
    }

    public Set<V> valueSet() {
        Set<V> insieme = new HashSet<>();
        mappa.forEach((k, c) -> insieme.addAll(c));
        return insieme;
    }

    public <Z> MultiMappa<K, Z> transformToMultiMappa(BiFunction<K, V, Z> f) {
        MultiMappa<K, Z> result = new MultiMappa<>();
        mappa.forEach(
            (k, c) -> c.forEach(
                v -> result.put(k, f.apply(k, v))));
        return result;
    }

    public void mapEach(BiFunction<K, V, V> f) {
        for (K k : mappa.keySet()) {
            Collection<V> c = new HashSet<>();
            for (V v : mappa.get(k)) {
                c.add(f.apply(k, v));
                mappa.put(k, c);
            }
        }
    }

    public static class Elemento<K, V> {
        K chiave;
        Collection<V> valori;

        public Elemento(K chiave, Collection<V> valori) {
            this.chiave = chiave;
            this.valori = valori;
        }
    }

    @Override
    public Iterator<Elemento<K, V>> iterator() {
        return new Iterator<>() {
            Iterator<Entry<K, Collection<V>>> it = mappa.entrySet().iterator();

            @Override
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override
            public Elemento<K, V> next() {
                Entry<K, Collection<V>> entry = it.next();
                return new Elemento(entry.getKey(), entry.getValue());
            }
        };
    }

    public static void main(String[] args) {

    }
}
