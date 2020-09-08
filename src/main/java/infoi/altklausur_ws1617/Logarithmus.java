package infoi.altklausur_ws1617;

public class Logarithmus {
	public static double log2 (double x) {
		double result = ln(x)/ln(2);
		System.out.println("log2("+x+") = "+result);
		return result;
	}

	private static double ln (double z) {
		double result = 0;
		double x = z-1;
		if (z > 1) {
			result = -ln(1-x/(1+x));
		} else if (Math.abs(z) < 1 || z == 1.0){
			for (int k = 1; Math.abs(nebenrechnung(k, x)) > 0.001; k++) {
				result += nebenrechnung(k, x);
			}
		} else {
			result = 0;
		}
		return result;
	}

	private static double nebenrechnung (int k, double x) {
		return Math.pow((-1),(k+1))*(Math.pow(x, k)/k);
	}

	public static void main (String[] args) {
		log2(1);
		log2(-5);
		log2(0);
		log2(5);
		log2(0.5);
	}
}
