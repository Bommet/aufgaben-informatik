package infoi.aufgabe_nr13;

public class Element<T> {
	private T value;
	private int size = 0;

	//Konstruktoren
	public Element(T pValue, int pSize) {
		value = pValue;
		size = pSize;
	}
	public Element(T pValue){
		this(pValue, 1);
	}

	//Methoden
	public T getValue() {
		return value;
	}
	public int getSize() {
		return size;
	}
	public String toString() {
		return value.toString();
	}
}
