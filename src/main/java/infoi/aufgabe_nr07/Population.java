package infoi.aufgabe_nr07;

public class Population {
	private int i = 0;

	public int population(int n, int m) {
		if(m<=n) {
			return 1;
		} else {
			int summe = 0;
			if(i<=n) {
				i++;
				summe = summe + population(n, m-i);
			}
			return summe;
		}
	}
	public int populationOhneRekursion(int n, int m) {
		int summe = 0;
		int mTemp = m;
		for(int i = 1; i<=n; i++) {
			if(mTemp<=n) summe++;
			mTemp = m-i;
		}
		return summe;
	}
}
