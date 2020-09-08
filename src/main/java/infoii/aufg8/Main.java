package infoii.aufg8;
package ;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Permute<Integer> perm = new Permute<Integer>();

		Integer[] a = { 1, 2, 3, 4, 5 };
		Integer[] b = { 1, 2, 3 };
		List<Integer> aList = Arrays.asList(a);
		List<Integer> bList = Arrays.asList(b);

		List<List<Integer>> permutationsA = perm.permute(aList)
				.filter(x -> (x.get(0) == 1) && (x.get(1) == 2) && (x.get(2) != 3) && (x.get(3) != 4))
				.collect(Collectors.toList());
		System.out.println(permutationsA.size());
		List<List<Integer>> permutationsB = perm.permute(bList).collect(Collectors.toList());

		for (int i = 0; i < permutationsA.size(); i++) {
			System.out.println(permutationsA.get(i));
		}

		for (int i = 0; i < permutationsB.size(); i++) {
			System.out.println(permutationsB.get(i));
		}

		System.out.println("Sorted: " + perm.sortByPermutationImproved(aList));
		System.out.println("Also Sorted: " + perm.sortByPermutation(aList));
	}
}