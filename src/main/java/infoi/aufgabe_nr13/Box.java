package infoi.aufgabe_nr13;

public class Box {
	private Element<?>[] elements;
	private int index;

	//Konstruktor
	public Box(int n) {
		if(n<=0) throw new IllegalArgumentException("n ist kleiner 0");
		elements = new Element<?>[n];
		index = 0;
	}

	//Methoden
	public Element<?>[] getElements(){
		return elements;
	}
	public void addElement(Element<?> e) throws FullBoxException{
		if((index+e.getSize())>elements.length) {
			throw new FullBoxException();
		} else {
			elements[index] = e;
			index += e.getSize();
		}
	}
}
