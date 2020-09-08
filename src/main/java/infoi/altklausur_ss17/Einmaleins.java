package infoi.altklausur_ss17;

public class Einmaleins {

	public static void kleinesEinmaleins() {
		for (int i=1; i<11; i++) {
			for (int j=1; j<11; j++) {
				System.out.println(""+j+" x "+i+" = "+i*j);
			}
		}
	}

	public static void main (String[] args) {
		kleinesEinmaleins();
	}
}