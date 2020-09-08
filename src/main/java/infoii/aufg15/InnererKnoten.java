/**
 * @author Hannes Gebker, 460 111
 */
package infoii.aufg15;

public class InnererKnoten<K extends Comparable<K>, D> extends Knoten<K, D> {
  public InnererKnoten(K pKey, Knoten<K, D> pLeft, Knoten<K, D> pRight) {
    super(pKey, null, pLeft, pRight);
  }
}