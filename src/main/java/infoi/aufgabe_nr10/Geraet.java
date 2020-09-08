package infoi.aufgabe_nr10;

public abstract class Geraet {
	protected double kaufpreis = 0;

	public Geraet(double pKaufpreis) {
		kaufpreis = pKaufpreis;
	}

	public abstract double getRestwert(int n);
}
