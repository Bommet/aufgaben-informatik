package infoii.aufg26;

import java.util.Arrays;

public class Main26 {
  public static void main(String[] args) {
    HashTabelle table = new HashTabelle(7);
    table.add(4);
    System.out.println(Arrays.toString(table.hashtable));
  }
}