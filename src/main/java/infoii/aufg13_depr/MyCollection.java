package infoii.aufg13_depr;

import java.util.*;

public interface MyCollection<K extends Comparable<K>, D> extends Iterable<Pair<K, D>> {

  public D find(K k) throws Exception;

  public void insert(K k, D c);

  public void delete(K k);

  public Iterator<Pair<K, D>> iterator();

  public String toString();
}
