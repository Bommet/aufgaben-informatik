package infoi.aufgabe_nr09;
/**
 * Representiert eine Scheibe.
 */
public class Scheibe implements Comparable<Scheibe> {

	/**
	 * Gibt die Groesse dieser Scheibe an, sollte positiv sein.
	 */
	private final int groesse;

	/**
	 * Erstellt eine neue Scheibe mit einer festen Groesse.
	 * @param groesse die Groesse dieser Scheibe.
	 */
	public Scheibe(int groesse) {
		this.groesse = groesse;
	}

	/**
	 * Gibt die fixe Groesse dieser Scheibe zurueck.
	 * @return die Groesse dieser Scheibe.
	 */
	public int getGroesse() {
		return this.groesse;
	}

	@Override
	public String toString() {
		return "("+groesse+")";
	}

	@Override
	public int compareTo(Scheibe o) {
		if(this.groesse > o.groesse) return +1;
		if(this.groesse < o.groesse) return -1;
		return 0;
	}
}