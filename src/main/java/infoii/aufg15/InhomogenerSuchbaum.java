/**
 * @author Hannes Gebker, 460 111
 */
package infoii.aufg15;

public class InhomogenerSuchbaum<K extends Comparable<K>, D> implements MyCollection<K, D> {
  private Knoten<K, D> root = null;

  public D find(K k) throws Exception, IllegalArgumentException {
    if (k == null) {
      throw new IllegalArgumentException("Key can´t be null");
    }

    if (root == null) {
      throw new Exception("nicht gefunden");
    } else {
      return root.findKnoten(k);
    }
  }

  public void insert(K k, D c) throws IllegalArgumentException {
    if (k == null || c == null) {
      throw new IllegalArgumentException("Input can´t be null");
    }

    if (root == null) {
      root = new Blatt<K, D>(k, c);
    } else {
      root.insertKnoten(k, c);
    }
  }

  public void delete(K k) throws IllegalArgumentException {
    if (k == null) {
      throw new IllegalArgumentException("Key can´t be null");
    }
    if (root != null) {
      root = root.deleteKnoten(k);
    }
  }
}