package infoi.altklausur_ss17;

public abstract class Medium {
	protected final String titel;
	protected final Kategorie kategorie;

	public Medium (String pTitel, Kategorie pKategorie) {
		titel = pTitel;
		kategorie = pKategorie;
	}

	public String getTitel() {
		return titel;
	}

	public Kategorie getKategorie() {
		return kategorie;
	}
}