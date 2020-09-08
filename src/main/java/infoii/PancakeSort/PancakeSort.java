package infoii.PancakeSort;

public class PancakeSort {
  public void sort(int[] a) {
    for (int i = a.length - 1; i > 0; i--) {
      int max = Integer.MIN_VALUE;
      int maxpos = 0;
      for (int j = 0; j <= i; j++) {
        if (a[i] > max) {
          max = a[j];
          maxpos = j;
        }
      }
      flip(a, maxpos);
      flip(a, i);
    }
  }

  public void flip(int[] a, int i) {
    int temp = 0;
    for (int j = i; j > i / 2; j--) {
      int temp2 = a[j];
      a[j] = a[temp];
      a[temp] = temp2;
    }
  }
}