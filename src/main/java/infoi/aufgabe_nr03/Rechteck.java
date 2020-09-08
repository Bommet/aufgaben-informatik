package infoi.aufgabe_nr03;

public class Rechteck {
	private int laenge, breite;

	//Constructor
	public Rechteck(int pLaenge, int pBreite) {
		laenge = pLaenge;
		breite = pBreite;
	}
	 //Methods
	public int getLaenge() {
		return laenge;
	}
	public int getBreite() {
		return breite;
	}
	public int getFlaeche() {
		return laenge * breite;
	}
	public boolean isQuadrat() {
		if (breite == laenge) return true;
		return false;
	}
}
