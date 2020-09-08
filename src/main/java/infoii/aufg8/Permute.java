package infoii.aufg8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Permute<T extends Comparable<T>> {
  public Stream<List<T>> permute(List<T> input) {
    assert input != null;
    List<T> inputCopy = new ArrayList<T>(input);
    List<List<T>> permutedArrays = new ArrayList<>();
    List<List<T>> subPermutations = new ArrayList<>();

    for (int i = 0; i < input.size(); i++) {
      if (input.size() <= 1) {
        permutedArrays.add(input);
      } else if (input.size() == 2) {
        Collections.reverse(inputCopy);
        permutedArrays.add(input);
        permutedArrays.add(inputCopy);

        return permutedArrays.parallelStream();
      } else {
        List<T> listHead = input.subList(0, 1);
        subPermutations = permute(input.subList(1, input.size())).collect(Collectors.toList());

        for (int j = 0; j < subPermutations.size(); j++) {
          List<T> finished = new ArrayList<T>(listHead);
          finished.addAll(subPermutations.get(j));
          permutedArrays.add(finished);
        }

        input = new ArrayList<T>(input.subList(1, input.size()));
        input.add(listHead.get(0));
      }
    }
    return permutedArrays.parallelStream();
  }

  public List<T> sortByPermutation(List<T> inputArray) {
    List<List<T>> permutedArrays = permute(inputArray).collect(Collectors.toList());
    List<T> sortedArray = new ArrayList<T>();
    Boolean sorted = false;

    for (int i = 0; i < (permutedArrays.size()) && (sorted != true); i++) {
      sorted = true;
      for (int j = 0; (j < permutedArrays.get(i).size() - 1) && (sorted != false); j++) {
        if (permutedArrays.get(i).get(j).compareTo(permutedArrays.get(i).get(j + 1)) > 0) {
          sorted = false;
        }
      }

      if (sorted == true) {
        sortedArray = permutedArrays.get(i);
      }
    }

    return sortedArray;
  }

  public List<T> sortByPermutationImproved(List<T> inputArray) {
    List<List<T>> permutedArrays = permute(inputArray).collect(Collectors.toList());
    List<T> sortedArray = new ArrayList<T>();
    Boolean sorted = false;

    for (int i = 0; i < (permutedArrays.size()) && (sorted != true); i++) {
      sorted = true;
      for (int j = 0; (j < permutedArrays.get(i).size() - 1) && (sorted != false); j++) {
        if (permutedArrays.get(i).get(j).compareTo(permutedArrays.get(i).get(j + 1)) > 0) {
          sorted = false;
          List<T> nonSortedList = permutedArrays.get(i).subList(0, j + 1);
          permutedArrays = permutedArrays.stream()
              .filter(x -> x.subList(0, nonSortedList.size()).equals(nonSortedList) == false)
              .collect(Collectors.toList());
        }
      }

      if (sorted == true) {
        sortedArray = permutedArrays.get(i);
      }
      i = -1;
    }

    return sortedArray;
  }
}