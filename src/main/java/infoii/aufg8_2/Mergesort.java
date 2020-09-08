package infoii.aufg8_2;

public class Mergesort {
  public void naturalmergesort(int[] a) {
    sort(a, 0, a.length - 1);
  }

  public void sort(int[] a, int init, int end) {
    for (int i = 0; i <= end; i++) {
      int sortedFirst = distribute(a, init);
      int sortedSecond = distribute(a, sortedFirst + 1);

      if (sortedSecond <= end) {
        merge(a, sortedFirst, sortedSecond);
        i = sortedSecond;
      }
    }
  }

  public int distribute(int[] a, int init) {
    for (int i = init; i < a.length - 1; i++) {
      if (a[i] > a[i + 1]) {
        return i;
      }
    }
    return a.length - 1;
  }

  public void merge(int[] a, int init, int end) {
    int[] b = a.clone();
    int[] c = a.clone();

    int i = 0;
    int bCount = 0;
    int cCount = init + 1;
    while (bCount <= init && cCount <= end) {
      a[i++] = b[bCount] < c[cCount] ? b[bCount++] : c[cCount++];
    }
    while (bCount <= init) {
      a[i++] = b[bCount++];
    }
    while (cCount <= end) {
      a[i++] = c[cCount++];
    }
  }
}