package infoii.aufg13_depr;

public class Tree<K extends Comparable<K>, D> implements MyCollection<K, D> {
  protected Node<K, D> root = null;

  public void insert(K key, D data) {
    if (root == null)
      root = new Node<K, D>(key, data, null, null);
    else
      root.insertNode(key, data);
  }

  public D find(K key) throws Exception {
    if (root == null)
      throw new Exception("nicht gefunden");
    else
      return root.findNode(key);
  }

  public void delete(K key) {
    if (root != null)
      root = root.deleteNode(key);
  }

  public LWR<K, D> iterator() {
    return new LWR<K, D>(root);
  }
}