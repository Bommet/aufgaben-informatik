package infoi.aufgabe_nr03;

public class Kreis {
	private int radius;

	//Constructor
	public Kreis(int pRadius) {
		radius = pRadius;
	}

	//Methods
	public int getRadius() {
		return radius;
	}
	public int getDurchmesser() {
		return radius*2;
	}

	//Part b
	public boolean passtInRechteck(Rechteck rechteck) {
		if (this.getDurchmesser() <= rechteck.getBreite() && this.getDurchmesser() <= rechteck.getLaenge()) return true;
		return false;
	}
}
