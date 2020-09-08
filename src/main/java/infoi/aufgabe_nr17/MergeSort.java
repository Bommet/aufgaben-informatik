package infoi.aufgabe_nr17;

public class MergeSort {

	public static void sort(int[] array) {
		if (array == null) {
			return;
		}

		if (array.length > 1) {
			int mid = array.length / 2;

			int[] left = new int[mid];
			for (int i = 0; i < mid; i++) {
				left[i] = array[i];
			}

			int[] right = new int[array.length - mid];
			for (int i = mid; i < array.length; i++) {
				right[i - mid] = array[i];
			}

			sort(left);
			sort(right);

			int i = 0;
			int j = 0;
			int k = 0;

			while (i < left.length && j < right.length) {
				if (left[i] < right[j]) {
					array[k++] = left[i++];
				} else {
					array[k++] = right[j++];
				}
			}

			while (i < left.length) {
				array[k++] = left[i++];
			}
			while (j < right.length) {
				array[k++] = right[j++];
			}
		}
	}
}