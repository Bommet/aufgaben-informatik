package infoi.altklausur_ss17;

public class Cosinus {
	public static double cos (double x) {
		double result = 0;
		for (int k = 0; Math.abs(nebenrechnung(k, x)) > 0.001; k++) {
			result += nebenrechnung(k, x);
		}
		System.out.println("cos("+x+") = "+result);
		return result;
	}

	public static double nebenrechnung (int k, double x) {
		return Math.pow((-1), k)*(Math.pow(x, 2*k)/fakultaet(2*k));
	}

	public static int fakultaet (int x) {
		int result = 0;
		for (int i=0; i<=x; i++) {
			if (i==0) {
				result = 1;
			} else {
				result *= i;
			}
		}
		return result;
	}

	public static void main (String[] args) {
		cos(0.5);
		cos(0);
		cos(1);
	}
}