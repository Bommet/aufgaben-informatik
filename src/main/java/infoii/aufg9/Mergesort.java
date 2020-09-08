package infoii.aufg9;

import java.util.Arrays;

public class Mergesort {
  public void naturalmergesort(int[] a) {
    sort(a, 0, a.length - 1);
  }

  public void sort(int[] a, int init, int end) {
    // Finden der ersten sortierten Teilfolgen durch aufeinanderfolgende Aufrufe von
    // distribute()
    int sortedFirst = distribute(a, init);
    // Aufrufen von merge() mit den Indizes der jeweils ersten Teilfolgen
    merge(a, sortedFirst, distribute(a, sortedFirst + 1));
  }

  public int distribute(int[] a, int init) {
    // Rückgabe des Index der von init ausgehenden ersten sortierten Teilfolge
    for (int i = init; i < a.length - 1; i++) {
      if (a[i] > a[i + 1]) {
        return i;
      }
    }
    // Wenn keine Unordnung gefunden wird letzter Index des Arrays zurückgegeben
    // Array dann bereits sortiert
    return a.length - 1;
  }

  public void merge(int[] a, int init, int end) {
    // Aufteilung auf zwei Hilfsarrays mit ersten zwei sortierten Folgen und Rest
    int[] sortedParts = Arrays.copyOfRange(a, 0, end + 1);
    int[] other = Arrays.copyOfRange(a, end + 1, a.length);

    // Mergeprozess
    int i = 0;
    int firstCount = 0;
    int secondCount = init + 1;
    while (firstCount <= init && secondCount <= end) {
      a[i++] = sortedParts[firstCount] < sortedParts[secondCount] ? sortedParts[firstCount++]
          : sortedParts[secondCount++];
    }
    while (firstCount <= init) {
      a[i++] = sortedParts[firstCount++];
    }
    while (secondCount <= end) {
      a[i++] = sortedParts[secondCount++];
    }
    int k = 0;
    while (k < other.length) {
      a[i++] = other[k++];
    }

    // Wenn erste sortierte Folge nicht ganzes Array, dann sortiere weiter mit
    // bearbeitetem Array
    for (int h = 0; h < a.length; h++) {
      System.out.print(a[h]);
    }
    if (!(distribute(a, init) == a.length - 1)) {
      sort(a, 0, a.length - 1);
    }
  }
}