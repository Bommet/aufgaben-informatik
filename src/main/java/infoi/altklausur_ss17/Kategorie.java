package infoi.altklausur_ss17;

public class Kategorie {
	protected final String bezeichnung;
	protected final Kategorie oberKategorie;

	public Kategorie (String pBezeichnung, Kategorie pOberKategorie) {
		bezeichnung = pBezeichnung;
		oberKategorie = pOberKategorie;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public Kategorie getOberKategorie() {
		return oberKategorie;
	}
}
