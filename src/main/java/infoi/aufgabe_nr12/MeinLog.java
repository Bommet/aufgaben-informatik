package infoi.aufgabe_nr12;

public class MeinLog {
	public MeinLog(double z) {
		try {
			System.out.println("ln("+z+"): "+ln(z));
		} catch(IllegalArgumentException e) {
			System.out.println("Illegale Eingabe: " + e.getMessage());
		}
	}
	public static double ln (double z) {
		if (z==0) {
			return Double.NEGATIVE_INFINITY;
		} else if (z < 0) {
			throw new IllegalArgumentException("z ist kleiner 0");
		} else if (z == Double.POSITIVE_INFINITY) {
			return Double.POSITIVE_INFINITY;
		} else if (z > 1) {
			return -(ln(1+((-z)/(1+z))));
		} else {
			int i = 1;
			double result = 0.0;
			while(!((Math.pow(z, i)/i) < 0.000001)) {
				if(i % 2 == 1) {
					result += (Math.pow(z, i)/i);
				} else {
					result -= (Math.pow(z, i)/i);
				}
				i++;
			}
			return result;
		}
	}
}
