package infoii.AntisymmetricMatrix;

public class AntisymmetricMatrix {
  private double[] array;
  private int n;

  public AntisymmetricMatrix(int pN) {
    n = pN * (pN - 1) / 2;
    array = new double[n];
  }

  public double M(int i, int j) throws IllegalArgumentException {
    if (i < 1 || j < 1 || i > n || j > n) {
      throw new IllegalArgumentException();
    }
    if (i == j) {
      return 0;
    } else if (j > i) {
      return -M(j, i);
    }

    return array[(i - 2) * (i - 1) / 2 + j - 1];
  }

  public static void main(String[] args) {
    AntisymmetricMatrix matrix = new AntisymmetricMatrix(5);
    System.out.println(matrix.M(5, 2));
  }
}