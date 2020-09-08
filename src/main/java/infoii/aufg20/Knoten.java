package infoii.aufg20;

/**
 * @author Hannes Gebker, 460 111
 */
public class Knoten<K extends Comparable<K>, D> {
  protected K key;
  protected D content;
  protected Knoten<K, D> left;
  protected Knoten<K, D> right;
  protected int anzahlLinks, anzahlRechts;
  protected boolean unbalanced = false;

  public Knoten(K k, D d, Knoten<K, D> l, Knoten<K, D> r, int aL, int aR) {
    key = k;
    content = d;
    left = l;
    right = r;
    anzahlLinks = aL;
    anzahlRechts = aR;
  }

  public D findKnoten(K k) throws Exception {
    if (key.compareTo(k) < 0) {
      if (right == null) {
        throw new Exception("nicht gefunden");
      } else {
        return right.findKnoten(k);
      }
    } else if (k.compareTo(key) < 0) {
      if (left == null) {
        throw new Exception("nicht gefunden");
      } else {
        return left.findKnoten(k);
      }
    } else {
      return content;
    }
  }

  public Knoten<K, D> insertKnoten(K k, D d) {
    Knoten<K, D> current;
    if (key.compareTo(k) < 0) { //Rechts
      if (right != null) {
        right = right.insertKnoten(k, d);
        anzahlRechts++;
        unbalanced = checkBalance();
        if (unbalanced) {
          current = rotiereLinks();
          return current;
        } else {
          return this;
        }
      } else {
        right = new Knoten<K, D>(k, d, null, null, 0, 0);
        anzahlRechts++;
        return this;
      }
    } else { //Links
      if (left != null) {
        left = left.insertKnoten(k, d);
        anzahlLinks++;
        unbalanced = checkBalance();
        if (unbalanced) {
          current = rotiereRechts();
          return current;
        } else {
          return this;
        }
      } else {
        left = new Knoten<K, D>(k, d, null, null, 0, 0);
        anzahlLinks++;
        return this;
      }
    }
  }

  private Knoten<K, D> rotiereLinks() {
    Knoten<K, D> current = right;
    right = right.left;
    current.left = this;
    return current;
  }

  private Knoten<K, D> rotiereRechts() {
    Knoten<K, D> current = left;
    left = left.right;
    current.right = this;
    return current;
  }

  public boolean checkBalance() {
    float temp = (float) (anzahlLinks + 1) / (anzahlLinks + anzahlRechts + 2);
    if (temp < 0.25 || temp > 0.75) {
      return true;
    } else {
      return false;
    }
  }

  public String toString(String margin) {
    String newmargin = margin + "  ";
    String result = margin + "(" + key.toString() + "," + content.toString() + ")\n";
    if (left != null)
      result += left.toString(newmargin);
    else
      result += newmargin + "-\n";
    if (right != null)
      result += right.toString(newmargin);
    else
      result += newmargin + "-\n";
    return result;
  }
}