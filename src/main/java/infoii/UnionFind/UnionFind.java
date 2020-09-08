package infoii.UnionFind;

import java.util.Arrays;

public class UnionFind {
  private int[] array;

  public UnionFind() {
    array = new int[1024];
    Arrays.fill(array, -1);
  }

  public void makeSet(int x) {
    if (findSet(x) == -1) {
      array[x] = x;
    }
  }

  public void union(int x, int y) {
    int rx = findSet(x);
    int ry = findSet(y);
    if (rx == -1 || ry == -1) {
      return;
    }
    for (int i = 0; i < array.length; i++) {
      if (array[i] == ry) {
        array[i] = rx;
      }
    }
  }

  public int findSet(int x) {
    return array[x];
  }

  public static void main(String[] args) {
    UnionFind u = new UnionFind();
    u.makeSet(2);
    u.makeSet(5);
    u.makeSet(8);
    System.out.println(u.findSet(2));
    System.out.println(u.findSet(3));
    u.union(2, 5);
    System.out.println(u.findSet(5));
  }
}