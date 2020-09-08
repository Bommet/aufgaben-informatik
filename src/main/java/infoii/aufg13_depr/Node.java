package infoii.aufg13_depr;

class Node<K extends Comparable<K>, D> {
  K key;
  D data;
  Node<K, D> left;
  Node<K, D> right;

  Node(K k, D d, Node<K, D> l, Node<K, D> r) {
    key = k;
    data = d;
    left = l;
    right = r;
  }

  public void insertNode(K k, D data) {
    if (key.compareTo(k) < 0)
      if (right == null)
        right = new Node<K, D>(k, data, null, null);
      else
        right.insertNode(k, data);
    else if (left == null)
      left = new Node<K, D>(k, data, null, null);
    else
      left.insertNode(k, data);
  }

  public D findNode(K k) throws Exception {
    if (key.compareTo(k) < 0)
      if (right == null)
        throw new Exception(k + " nicht gefunden");
      else
        return right.findNode(k);
    else if (k.compareTo(key) < 0)
      if (left == null)
        throw new Exception(k + " nicht gefunden");
      else
        return left.findNode(k);
    else
      return data;
  }

  private Node<K, D> findMaxPred() {
    if (right.right == null)
      return this;
    else
      return right.findMaxPred();
  }

  public Node<K, D> deleteNode(K k) {
    if (key.compareTo(k) < 0) {
      if (right != null)
        right = right.deleteNode(k);
      return this;
    } else if (k.compareTo(key) < 0) {
      if (left != null)
        left = left.deleteNode(k);
      return this;
    }
    if (left == null)
      return right;
    if (right == null)
      return left;
    if (left.right == null) {
      left.right = right;
      return left;
    }
    Node<K, D> maxPred = left.findMaxPred();
    Node<K, D> max = maxPred.right;
    maxPred.right = max.left;
    max.left = left;
    max.right = right;
    return max;
  }
}