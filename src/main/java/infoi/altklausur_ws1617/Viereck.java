package infoi.altklausur_ws1617;

public abstract class Viereck {
	protected int hoehe, breite;

	public Viereck (int pHoehe, int pBreite) {
		hoehe = pHoehe;
		breite = pBreite;
	}

	public int getHoehe() {
		return hoehe;
	}

	public int getBreite() {
		return breite;
	}

	public int flaeche() {
		return hoehe*breite;
	};
}
