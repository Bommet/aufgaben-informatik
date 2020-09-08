/**
 * @author Hannes Gebker, 460 111
 */
package infoii.aufg15;

public class Blatt<K extends Comparable<K>, D> extends Knoten<K, D> {
  public Blatt(K pKey, D pData) {
    super(pKey, pData, null, null);
  }
}