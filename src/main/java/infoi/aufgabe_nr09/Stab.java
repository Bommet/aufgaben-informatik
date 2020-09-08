package infoi.aufgabe_nr09;

import java.util.Stack;

/**
 * Representiert einen Stab, auf dem mehrere Scheiben in einem Stapel liegen koenen.
 */
public class Stab implements Comparable<Stab> {

	/**
	 * Die Scheiben auf diesem Stab.
	 */
	private final Stack<Scheibe> scheiben;

	/**
	 * Der Name von diesem Stab, kann z.B. einfach nur "A" heissen.
	 */
	private final String name;

	/**
	 * Erstellt einen neuen Stab mit dem uebergebenen Namen.
	 * @param name der Name von diesem Stab, kann z.B. einfach nur "A" heissen.
	 */
	public Stab(String name) {
		this.name = name;
		this.scheiben = new Stack<Scheibe>();
	}

	/**
	 * Legt eine neue Scheibe oben auf den Stab.
	 * @param scheibe die neue Scheibe, welche anschliessend oben auf dem Stab liegt.
	 */
	public void push(Scheibe scheibe) {
		this.scheiben.push(scheibe);
	}

	/**
	 * Nimmt die oberste Scheibe vom Stab und gibt diese zurueck.
	 * @return die oberste Scheibe vom Stab, oder <code>null</code> wenn keine Scheiben auf diesem Stab sind.
	 */
	public Scheibe pop() {
		if(this.scheiben.size() == 0) {
			return null;
		}
		return this.scheiben.pop();
	}

	/**
	 * Gibt die oberste Scheibe von diesem Stab zurueck, ohne sie jedoch vom Stab zu nehmen.
	 * @return die oberste Scheibe von diesem Stab, oder <code>null</code> wenn keine Scheiben auf diesem Stab sind.
	 */
	public Scheibe peek() {
		if(this.scheiben.size() == 0) {
			return null;
		}
		return this.scheiben.peek();
	}

	/**
	 * Gibt die Anzahl der Scheiben auf diesem Stab zurueck.
	 * @return die Anzahl der Scheiben auf diesem Stab.
	 */
	public int size() {
		return this.scheiben.size();
	}

	/**
	 * Gibt die i-te Scheibe zurueck, wobei i=0 die unterste Scheibe beschreibt.
	 * @param i index von der Scheibe auf diesem Stab.
	 * @return die i-te Scheibe, oder <code>null</code> wenn es keine i-te Scheibe gibt.
	 */
	public Scheibe get(int i) {
		if(i < 0 || i >= size()) return null;
		return this.scheiben.get(i);
	}

	@Override
	public String toString() {
		return name + ": " + scheiben.toString();
	}

	@Override
	public int compareTo(Stab o) {
		if(this.size() == 0 && o.size() == 0) return 0;
		if(this.size() == 0) return +1;
		if(o.size()    == 0) return -1;
		if(this.peek().getGroesse() < o.peek().getGroesse()) {
			return -1;
		}
		return +1;
	}
}