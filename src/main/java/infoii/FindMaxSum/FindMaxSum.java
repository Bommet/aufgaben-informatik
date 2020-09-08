package infoii.FindMaxSum;

public class FindMaxSum {
  public static void main(String[] args) {
    int[] a = { -3, 1, -4, 6, 7, -5, 8 };
    int[] b = { 2, 1, -3, 4, -1, 2, 1, -5, 4 };
    findMaxSum(a);
    findMaxSum(b);
  }

  public static int findMaxSum(int[] list) {
    int sum = 0;
    int tempSum = 0;
    for (int i = 0; i < list.length; i++) {
      tempSum += list[i];
      if (tempSum < 0) {
        tempSum = 0;
      }
      if (tempSum > sum) {
        sum = tempSum;
      }
    }
    System.out.println(sum);
    return sum;
  }
}