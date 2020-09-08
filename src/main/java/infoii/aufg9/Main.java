package infoii.aufg9;

public class Main {
  public static void main(String[] args) {
    int[] a = { 3, 5, 1, 4, 7, 2, 6, 9 };
    int[] b = { 8, 4, 6, 9, 2, 7, 1, 456, 123, 12, 11, -4, -6, -90 };
    Mergesort merge = new Mergesort();

    merge.naturalmergesort(a);
    merge.naturalmergesort(b);

    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i]);
    }
    System.out.println();

    for (int i = 0; i < b.length; i++) {
      System.out.print(b[i]);
    }
  }
}