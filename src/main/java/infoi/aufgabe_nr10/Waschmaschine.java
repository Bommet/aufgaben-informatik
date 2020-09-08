package infoi.aufgabe_nr10;

public class Waschmaschine extends Geraet implements Wasserverbraucher{
	private int upm = 0;
	private double verbrauch = 0;

	public Waschmaschine(double pKaufpreis, int pUpm) {
		super(pKaufpreis);
		upm = pUpm;
	}

	public int getUpm() {
		return upm;
	}
	public double getRestwert(int n) {
		if(n>5) {
			return 0;
		} else if(n==0) {
			return kaufpreis;
		} else {
			return kaufpreis - kaufpreis*(n/5);
		}
	}
	public double getWasserverbrauch() {
		return verbrauch;
	}
	public void setVerbrauch(double pVerbrauch) {
		verbrauch = pVerbrauch;
	}
}
