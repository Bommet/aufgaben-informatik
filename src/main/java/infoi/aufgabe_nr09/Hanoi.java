package infoi.aufgabe_nr09;

public class Hanoi {

	public void loese(Stab a, Stab b, Stab c) {
		ausgangszustand(5, c, b, a);
		bewege(5, a, b, c);
	}

	/**
	 * Bewegt <code>n</code> Scheiben von dem Stab <code>start</code> zum Stab <code>ziel</code>.
	 * @param n > 0 Anzahl der Scheiben die bewegt werden sollen
	 * @param start Start Stab
	 * @param hilf Hilfsstab
	 * @param ziel Ziel Stab
	 */
	public void bewege(int n, Stab start, Stab hilf, Stab ziel) {
		if(n == 1) {
			System.out.println(start + " -> " + ziel);
			ziel.push(start.pop());
		} else {
			bewege(n-1, start, ziel, hilf);
			System.out.println(start + " -> " + ziel);
			ziel.push(start.pop());
			bewege(n-1, hilf, start, ziel);
		}
	}
	public void ausgangszustand(int n, Stab start, Stab hilf, Stab ziel) {
		if(n==5) {
			ziel.push(start.pop());
		}
	}

	/**
	 * Start vom Programm.
	 */
	public static void main(String[] args) {
		Stab a = new Stab("A");
		Stab b = new Stab("B");
		Stab c = new Stab("C");

		a.push(new Scheibe(4));
		a.push(new Scheibe(3));
		b.push(new Scheibe(5));
		b.push(new Scheibe(1));
		c.push(new Scheibe(2));

		new Hanoi().loese(a,b,c);
	}
}
