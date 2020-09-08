package infoi.aufgabe_nr16;

public class Produkt {
	private final int gewichtInGramm;
	private final int preis;
	private final double volumenCM3;

	//Konstruktor
	public Produkt(int preis, int gewichtInGramm, double volumenCM3) {
		this.preis = preis;
		this.gewichtInGramm = gewichtInGramm;
		this.volumenCM3 = volumenCM3;
	}

	//Methoden
	public int getPreis() {
		return preis;
	}
	public int getGewichtInGramm() {
		return gewichtInGramm;
	}
	public double getVolumenCM3() {
		return volumenCM3;
	}
}
