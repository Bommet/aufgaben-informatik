package infoii.aufg13_depr;

import java.util.*;

class LWR<K extends Comparable<K>, D> implements Iterator<Pair<K, D>> {
  protected Stack<Node<K, D>> stack = new Stack<Node<K, D>>();

  public LWR(Node<K, D> root) {
    pushSpine(root);
  }

  private void pushSpine(Node<K, D> current) {
    while (current != null) {
      stack.push(current);
      current = current.left;
    }
  }

  public boolean hasNext() {
    return !stack.empty();
  }

  public Pair<K, D> next() {
    Node<K, D> current = stack.pop();
    if (current.right != null)
      pushSpine(current.right);
    return new Pair<K, D>(current.key, current.data);
  }

  public void remove() {
    // Versvollständigen Sie diese Methode
    throw new UnsupportedOperationException();
  }
}