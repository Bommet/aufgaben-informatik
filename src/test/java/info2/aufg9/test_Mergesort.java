package aufg9;

import org.junit.Test;

import infoii.aufg9.aufg8_2;

import static org.junit.Assert.*;

public class test_Mergesort {
  private aufg8_2.Mergesort merge = new aufg8_2.Mergesort();

  @Test
  public void test_null() {
    // assertThrows(AssertionError.class, () -> merge.naturalmergesort(null));
  }

  @Test
  public void test_size1() {
    int[] size1 = { 3 };
    int[] expected = { 3 };
    merge.naturalmergesort(size1);
    assertArrayEquals(size1, expected);
  }

  @Test
  public void test_empty() {
    int[] a = {};
    merge.naturalmergesort(a);
    assertArrayEquals(a, new int[0]);
  }

  @Test
  public void test_length() {
    int[] a = { 1, 3, 5, 8, 2, 45, 11, 78, 15, 35 };
    int[] aSorted = { 1, 2, 3, 5, 8, 11, 15, 35, 45, 78 };
    merge.naturalmergesort(a);
    assertArrayEquals(aSorted, a);
  }
}