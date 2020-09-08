package infoii.aufg20;

/**
 * @author Hannes Gebker, 460 111
*/
public class GewichtSuchbaum<K extends Comparable<K>, D> implements MyCollection<K, D> {
  private Knoten<K, D> root = null;
  // private float alpha, beta;

  public GewichtSuchbaum(float alpha, float beta) {
    /* alpha = (float) 0.25;
    beta = (float) 0.75; */
  }

  @Override
  public D find(K k) throws Exception, IllegalArgumentException {
    if (k == null) {
      throw new IllegalArgumentException("Argument can not be null!");
    }
    if (root == null) {
      throw new Exception("nicht gefunden");
    } else {
      return root.findKnoten(k);
    }
  }

  @Override
  public void insert(K k, D d) throws IllegalArgumentException {
    if (k == null || d == null) {
      throw new IllegalArgumentException("Argument can not be null!");
    }
    if (root == null) {
      root = new Knoten<K, D>(k, d, null, null, 0, 0);
    } else {
      root = root.insertKnoten(k, d);
    }
  }

  public String toString() {
    if (root != null)
      return root.toString("");
    else
      return "Baum ist leer";
  }
}