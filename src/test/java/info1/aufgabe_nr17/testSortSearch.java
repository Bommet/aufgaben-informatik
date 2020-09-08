package aufgabe_nr17;

import java.util.Arrays;

import org.junit.Test;

import infoi.aufgabe_nr17.BinarySearch;
import infoi.aufgabe_nr17.MergeSort;

import static org.junit.Assert.*;

class testSortSearch {

	@Test
	void testBinarySearch() {
		int[] a = {1,2,3,4,5,7};
		assertEquals(BinarySearch.binarySearch(a,5),4);
		assertEquals(BinarySearch.binarySearch(a,1),0);
		assertEquals(BinarySearch.binarySearch(null, 4),-1);
		assertEquals(BinarySearch.binarySearch(a, 6),-1);
	}

	@Test
	void testMergeSort() {
		int[] a = {1,5,3,4,2};
		int[] b = {1,2,3,4,5};
		int[] c = {4,3,6,7,2};
		int[] nullArray = null;
		MergeSort.sort(a);
		MergeSort.sort(c);
		MergeSort.sort(nullArray);
		assertTrue(Arrays.equals(a,b));
		assertEquals(Arrays.equals(b,c), false);
		assertEquals(nullArray, null);
	}


}
