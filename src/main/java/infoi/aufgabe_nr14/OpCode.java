package infoi.aufgabe_nr14;

public enum OpCode {
	PUSH(0,1), ADD(2,1), SUB(2,1), JUMP(1,0), STOP(0,0);

	private final int produces;
	private final int consumes;

	//Konstruktor
	OpCode(int pConsumes, int pProduces) {
		produces = pProduces;
		consumes = pConsumes;
	}

	//Methoden
	public int getConsumes() {
		return consumes;
	}
	public int getProduces() {
		return produces;
	}
}