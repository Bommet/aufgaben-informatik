package infoi.aufgabe_nr05;

public class MyVector {
	//Attributes
	private int[] values;

	//Constructor
	public MyVector(int[] pValues) {
		values = pValues;
	}

	//Methods
	public int[] getValues() {
		return values;
	}
	public int skalarprodukt(MyVector b) {
		int skalarprodukt = 0;
		int[] valuesB = b.getValues();

		if(values.length != valuesB.length) return 0;

		for(int i = 0; i < values.length; i++) {
			skalarprodukt = skalarprodukt + values[i]*valuesB[i];
		}
		return skalarprodukt;
	}
}
