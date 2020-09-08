package infoi.aufgabe_nr06;

public class Dual {
	private boolean[] values = new boolean[32];

	public Dual() {
		for(int i = 0; i < values.length; i++) {
			values[i] = false;
		}
	}

	public boolean get(int index) {
		if(index <= values.length) return values[index];
		return false;
	}
	public void set(int index, boolean value) {
		if(index <= values.length) values[index] = value;
	}
	public void fromDecimal(int decimal) {
		if(decimal <= Integer.MAX_VALUE && decimal >= Integer.MIN_VALUE) {
			if(decimal == Integer.MAX_VALUE) {
				values[0] = false;
				for(int i = 1; i < values.length; i++) {
					values[i] = true;
				}
			} else if (decimal == Integer.MIN_VALUE) {
				values[0] = true;
				for(int i = 1; i < values.length; i++) {
					values[i] = false;
				}
			} else if (decimal >= 0){
				int helpDecimal = decimal;
				for(int i = 0; i < values.length; i++) {
					if(helpDecimal >= (Math.pow(2, (31-i)))) {
						values[i] = true;
						helpDecimal = helpDecimal-(int)(Math.pow(2, (31-i)));
					} else {
						values[i] = false;
					}
				}
			} else {
				int helpDecimal = -decimal;
				for(int i = 0; i < values.length; i++) {
					if(helpDecimal >= (Math.pow(2, (31-i)))) {
						values[i] = true;
						helpDecimal = helpDecimal-(int)(Math.pow(2, (31-i)));
					} else {
						values[i] = false;
					}
				}
				for(int i = 0; i < values.length; i++) {
					if(values[i] == true) {
						values[i] = false;
					} else {
						values[i] = true;
					}
				}
			}
		}
	}
	public int toDecimal() {
		int decimal = 0;
		for(int i = 0; i < values.length; i++) {
			if(values[i] == true) decimal = decimal + (int)Math.pow(2, (31-i));
		}
		return decimal;
	}
	public void fromDecimalMuster(int decimal) {
		boolean bit;
		values = new boolean[values.length];
		for(int i = 0; i < values.length; i++) {
			if((decimal & 1) == 1) {
				bit = true;
			} else {
				bit = false;
			}
			values[i] = bit;
			decimal >>= 1;
		}
	}
}
