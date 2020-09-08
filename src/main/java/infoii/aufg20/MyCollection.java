package infoii.aufg20;

public interface MyCollection<K extends Comparable<K>, D> {

  public D find(K k) throws Exception;

  public void insert(K k, D c);

  public String toString();
}
