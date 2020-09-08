package infoi.aufgabe_nr15;

import java.util.Arrays;

public class Scan {

	public static final int[] a = {42,17,56,98,76,33,24,15,15,29};

	public static int[] scan(int[] a, IntOperation op) {
		if(a.length>0) {
			int[] z = new int[a.length];
			z[0]= a[0];
			for(int j=1; j<a.length; j++) {
				z[j] = op.evaluate(z[j-1], a[j-1]);
			}
			return z;
		} else {
			return new int[0];
		}
	}

	public static int[] scanAdd(int[] a) {
		return scan(a, (x,y)->x+y);
	}

	public static int[] scanMul(int[] a) {
		return scan(a, (x,y)->x*y);
	}

	public static int[] scanMax(int[] a) {
		return scan(a, (x,y)->Math.max(x,y));
	}


	public static void main(String[] args) {
		int[] aAdd = scanAdd(a);
		int[] aMul = scanMul(a);
		int[] aMax = scanMax(a);

		final String s = "\t(%s) Scan mit %s auf: %s = %s\n";
		System.out.printf(String.format(s, "i",   "Addition", Arrays.toString(a), Arrays.toString(aAdd)));
		System.out.printf(String.format(s, "ii",  "Multiplikation", Arrays.toString(a), Arrays.toString(aMul)));
		System.out.printf(String.format(s, "iii", "Maximum", Arrays.toString(a), Arrays.toString(aMax)));
	}

}
