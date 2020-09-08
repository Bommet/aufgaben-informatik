package infoii.aufg15;

public interface MyCollection<K extends Comparable<K>, D> {

  public D find(K k) throws Exception;

  public void insert(K k, D c);

  public void delete(K k);

  public String toString();
}
