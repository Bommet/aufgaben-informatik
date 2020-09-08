package infoi.aufgabe_nr10;

public class Herd extends Geraet{
	private int anzahlKochfelder = 0;

	public Herd (double pKaufpreis, int pAnzahlKochfelder) {
		super(pKaufpreis);
		anzahlKochfelder = pAnzahlKochfelder;
	}

	public int getAnzahlKochfelder() {
		return anzahlKochfelder;
	}
	public double getRestwert(int n) {
		if(n>5) {
			return 0;
		} else if(n==0) {
			return kaufpreis;
		} else {
			return kaufpreis - kaufpreis*(n/10);
		}
	}
}
