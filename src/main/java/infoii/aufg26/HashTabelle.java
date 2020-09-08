package infoii.aufg26;

/**
 * @author Hannes Gebker, 460 111
 */

import java.util.Arrays;

public class HashTabelle {
  // Temporary public
  public Integer[] hashtable;
  private double theta = (Math.sqrt(5) - 1) / 2;
  private int help = (int) Math.floor((Math.pow(2, 31) - 1) / theta);

  public HashTabelle(int size) {
    hashtable = new Integer[size];
    Arrays.fill(hashtable, -1);
  }

  public Integer find(Integer value) {
    Integer result = -1;
    for (int i = 0; i < hashtable.length; i++) {
      if (hashtable[i] == value) {
        result = hashtable[i];
      }
    }
    return result;
  }

  public boolean add(Integer value) throws IllegalArgumentException {
    if (value == null) {
      throw new IllegalArgumentException("Given value can not be null.");
    }

    if (find(value) != -1) {
      return false;
    } else {
      //Finden des Platzes nach Fibonacci-Hashing
      System.out.println(help * value);
      Integer place = value * help;

      //Sondieren, wenn zugewiesener Platz schon belegt ist
      while (hashtable[place] != -1) {
        place = (place + 1) % hashtable.length;
      }

      //Platz zuweisen
      hashtable[place] = value;
      return true;
    }
  }
}