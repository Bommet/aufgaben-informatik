package infoi.aufgabe_nr08;

public class Exotic {
	private int i = 0, anzahlDreiecke = 1;
	private double volumen = 0;

	public double getVolumenRekursiv(int n, double m) {
		if(m>0) {
			if (i<=n) {
				i++;
				anzahlDreiecke *= 3;
				volumen += Math.pow(m, 3) + (getVolumenRekursiv(n, m/2*i))*(anzahlDreiecke);
			}
		}
		return volumen;
	}
}
