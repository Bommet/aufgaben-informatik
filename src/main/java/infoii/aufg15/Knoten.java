/**
 * @author Hannes Gebker, 460 111
 */
package infoii.aufg15;

public abstract class Knoten<K extends Comparable<K>, D> {
  protected K key;
  protected D data;
  protected Knoten<K, D> left;
  protected Knoten<K, D> right;

  public Knoten(K k, D d, Knoten<K, D> l, Knoten<K, D> r) {
    key = k;
    data = d;
    left = l;
    right = r;
  }

  public void insertKnoten(K pKey, D pData) {
    if (key.compareTo(pKey) < 0) {
      if (right == null) {
        left = new Blatt<K, D>(key, data);
        right = new Blatt<K, D>(pKey, pData);
        data = null;
      } else {
        right.insertKnoten(pKey, pData);
      }
    } else if (key.compareTo(pKey) > 0) {
      if (left == null) {
        left = new Blatt<K, D>(pKey, pData);
        right = new Blatt<K, D>(key, data);
        data = null;
        key = pKey;
      } else {
        left.insertKnoten(pKey, pData);
      }
    }
  }

  public D findKnoten(K pKey) throws Exception {
    if (key.compareTo(pKey) < 0) {
      if (right == null) {
        throw new Exception(pKey + " nicht gefunden");
      } else {
        return right.findKnoten(pKey);
      }
    } else if (key.compareTo(pKey) > 0) {
      if (left == null) {
        throw new Exception(pKey + " nicht gefunden");
      } else {
        return left.findKnoten(pKey);
      }
    } else {
      if (data == null) {
        return left.findKnoten(pKey);
      }
      return data;
    }
  }

  public Knoten<K, D> deleteKnoten(K pKey) {
    if (key.compareTo(pKey) < 0) {
      if (right != null) {
        right = right.deleteKnoten(pKey);
        if (right == null) {
          key = left.key;
          data = left.data;
          right = left.right;
          left = left.left;
        }
      }
      return this;
    } else if (key.compareTo(pKey) > 0) {
      if (left != null) {
        left = left.deleteKnoten(pKey);
      }
      if (left == null) {
        key = right.key;
        data = right.data;
        left = right.left;
        right = right.right;
      }
      return this;
    }
    left = null;
    return right;
  }
}