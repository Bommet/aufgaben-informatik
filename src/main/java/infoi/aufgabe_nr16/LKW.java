package infoi.aufgabe_nr16;

public class LKW {
	private final int maxGewichtInKG;
	private final double maxM3Volumen;

	//Konsruktoren
	public LKW(int maxGewichtInKG, double maxM3Volumen) {
		this.maxGewichtInKG = maxGewichtInKG;
		this.maxM3Volumen = maxM3Volumen;
	}

	//Methoden
	public int getMaxGewichtInKG() {
		return this.maxGewichtInKG;
	}
	public double getMaxM3Volumen() {
		return this.maxM3Volumen;
	}
}