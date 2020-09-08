package infoi.aufgabe_nr17;

public class BinarySearch {

	public static int binarySearch(int[] sortedArray, int x) {
		if(sortedArray == null) {
			return -1;
		}

		int left  = 0;
		int right = sortedArray.length - 1;

		while (left <= right) {
			int mid = left + (right-left) / 2;
			if(sortedArray[mid] == x) {
				return mid;
			}
			if(sortedArray[mid] < x) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return -1;
	}

}